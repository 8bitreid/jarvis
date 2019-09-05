package controllers

import play.api.libs.json.Json
import play.api.mvc.{AbstractController, Action, AnyContent, ControllerComponents}
import services.JarvisService

import scala.concurrent.ExecutionContext

class JarvisController(jarvisService: JarvisService, cc: ControllerComponents)(
  implicit ec: ExecutionContext
) extends AbstractController(cc) {

  def status: Action[AnyContent] = Action.async {
    jarvisService.serverStatus.map { res =>
      Ok(Json.toJson(res))
    }
  }

  def helloJarvis: Action[AnyContent] = Action.async {
    jarvisService.greetingMessage.map { res =>
      Ok(Json.toJson(res))
    }
  }

  def version: Action[AnyContent] = Action.async {
    jarvisService.getVersion.map { res =>
      Ok(Json.toJson(res))
    }
  }

  def voiceRecSso: Action[AnyContent] = TODO
}
