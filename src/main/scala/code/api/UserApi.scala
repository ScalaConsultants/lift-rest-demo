package code.api

import net.liftweb.http.LiftRules
import net.liftweb.http.Req
import net.liftweb.http.GetRequest 
import net.liftweb.common.{Box, Full, Empty, Failure}
import net.liftweb.http.JsonResponse 

object UserApi {
  def dispatch: LiftRules.DispatchPF = {
    // Define our getters first
    case r @ Req("api" :: "user" :: id :: Nil, _, GetRequest) =>
      () => Full(JsonResponse("test"))
  }
}