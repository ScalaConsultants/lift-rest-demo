package code.api

import net.liftweb.common.{Box, Full, Empty, Failure}
import net.liftweb.http.{ LiftRules, Req, GetRequest }
import net.liftweb.http.JsonResponse
import code.model.User
import net.liftweb.json._
import net.liftweb.json.JsonAST._
import net.liftweb.json.JsonDSL._
import net.liftweb.http.BadResponse

object UserApi {
  def dispatch: LiftRules.DispatchPF = {
    // Define our getters first
    case r @ Req("api" :: "user" :: id :: Nil, _, GetRequest) =>
      () => {
        User.find(id) match {
          case Full(user) => Full(JsonResponse(user.asJValue))
          case _ => Full(BadResponse())
        }
      }
  }
}