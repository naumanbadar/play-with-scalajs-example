package example

import org.scalajs.jquery.jQuery
import shared.SharedMessages

import scala.scalajs.js

object ScalaJSExample extends js.JSApp {
  def main(): Unit = {
    println("Hello Console!")
    jQuery("#scalajsShoutOut").text(SharedMessages.itWorks)
  }
}
