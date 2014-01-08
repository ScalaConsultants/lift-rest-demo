package code.api

//see https://www.assembla.com/wiki/show/liftweb/Box
import net.liftweb.common.{Box, Full, Empty, Failure}
import net.liftweb.http.{ S, LiftRules, Req, GetRequest, PostRequest }
import net.liftweb.http.{ LiftResponse, JsonResponse, BadResponse }
import code.model.User
import net.liftweb.json._
import net.liftweb.json.JsonDSL._
import net.liftweb.common.Logger

object UserApi extends Logger {
  def dispatch: LiftRules.DispatchPF = {
    case r @ Req("api" :: "user" :: id :: Nil, _, GetRequest) =>
      debug("Requested user " + id)
      () => {
        User.find(id) match {
          case Full(user) => Full(JsonResponse(user.asJValue))
          case _ => Full(BadResponse())
        }
      }
    case r @ Req("api" :: "user" :: "find" :: Nil, _, PostRequest) =>
      () => {
        debug("Find user with params " + S.request.map(_.params))
        
        val response: Box[LiftResponse] = for {
          jsonString <- S.param("q")
          net.liftweb.json.JInt(yob) = parse(jsonString) \\ "yob"
        } yield {
          JsonResponse(User.sameAge(yob.toInt).map(_.asJValue))
        }
        
        response
      }
  }
}