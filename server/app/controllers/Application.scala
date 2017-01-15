package controllers

import play.api.libs.json.Json
import play.api.mvc._
import shared.{Message, SharedMessages}

class Application extends Controller {

  def index = Action {
    Ok(views.html.index(SharedMessages.itWorks))
  }

  def getMessage = Action {
    Ok(Json.toJson(Message("Good morning from the controller")))
  }

}
