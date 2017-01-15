package controllers

import play.api.Logger
import play.api.mvc._
import shared.{Message, SharedMessages}
import upickle.default._

class Application extends Controller {

  def index = Action {
    Ok(views.html.index(SharedMessages.itWorks))
  }

  def getMessage = Action {
    Logger.logger.info("call from js")
    Ok(write(Message("Good morning from the controller")))
  }

}
