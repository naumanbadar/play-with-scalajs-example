package shared

import play.api.libs.json.Json

object SharedMessages {
  def itWorks = "It works!"
}

case class Message(content: String)

object Message {
  implicit val write = Json.writes[Message]
  implicit val read = Json.reads[Message]
}