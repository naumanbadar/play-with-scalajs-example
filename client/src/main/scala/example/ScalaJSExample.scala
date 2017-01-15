package example

import org.scalajs.dom.raw.{Event, XMLHttpRequest}
import org.scalajs.jquery.{JQueryXHR, jQuery}
import shared.{Message, SharedMessages}
import upickle.default._

import scala.scalajs.js
import scala.scalajs.js.{Dynamic, JSON}

object ScalaJSExample extends js.JSApp {
  def main(): Unit = {
    println("Hello Console!")
    jQuery("#scalajsShoutOut").text(SharedMessages.itWorks)

    val mes2 = Message("Locally instantiated message")

    //    val mes2 = Json.parse("{\"content\":\"Good morning from the controller\"}").as[Message]

    //    jQuery("#message").load("/message")

    read[Message]("""{"content":"Good morning from the controller"}""")


    /*
    //works with dom
        val httpRequest = new XMLHttpRequest()
        httpRequest.open("GET", "/message")
        httpRequest.onload = (e: Event) => {
          println("loaded from server")
          if (httpRequest.status == 200) {
            val parsed = JSON.parse(httpRequest.responseText)
            val mes = read[Message](httpRequest.responseText)
            println(mes)
          }
        }
        httpRequest.send()
    */

    jQuery("#Load").click {
      () =>

        //        val jQuery1: String = jQuery().load("/message").text()
        //        jQuery.getJSON("/message").onload
        //        println(jQuery1)
        jQuery("#rawMessage").load("/message")
        //        jQuery("#unpickledMessage").text(mes2.content)
        //        jQuery("#unpickledMessage").text(read[Message](jQuery1).content)


        /*
                val hR: JQueryXHR = jQuery.get("/message")
                hR.onload = {
                  (_ : Event) =>
                    jQuery("#unpickledMessage").text(read[Message](hR.responseText).content)
                }
                hR.send()
        */

        val xMLHttpRequest = new XMLHttpRequest()
        xMLHttpRequest.open(
          method = "GET",
          url = "/message"
        )
        xMLHttpRequest.onload = (_: Event) => {
          jQuery("#unpickledMessage").text(read[Message](xMLHttpRequest.responseText).content)
        }
        xMLHttpRequest.send()

    }

    /*jQuery("#unpickledMessage").load("/message", (res: String, stat: String, xhr: JQueryXHR) => {
      //      jQuery("#unpickledMessage").text(res)
    })*/

    //    reqq.onload = {
    //      _: Event =>
    //              jQuery("#unpickledMessage").text(read[Message](hR.responseText).content)
    //    }
    //      reqq.send(null)


  }
}
