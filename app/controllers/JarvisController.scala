package controllers

import play.api.Logger

import scala.concurrent.ExecutionContext
import play.api.mvc.{AbstractController, Action, AnyContent, ControllerComponents}
import play.api.libs.json.Json
import services.JarvisService

class JarvisController(jarvisService: JarvisService,
                       cc: ControllerComponents)
                      (implicit ec: ExecutionContext) extends AbstractController(cc) {

  private val logger = Logger(getClass)

  def status: Action[AnyContent] = Action.async {
    logger.info("Jarvis, can you check the server?" )
    println("Jarvis, can you check the server?")
    jarvisService.serverStatus.map {
      res => Ok(Json.toJson(res))
    }
  }

  def helloJarvis: Action[AnyContent] = Action.async {
    // TODO get logging working.
    logger.info("Jarvis, you're attention is required." )
    println("Jarvis, you're attention is required")
    jarvisService.greetingMessage.map{
      res => Ok(Json.toJson(res))
    }
  }

  def version: Action[AnyContent] = Action.async {
    jarvisService.getVersion. map{
      res => Ok(Json.toJson(res))
    }
  }

  def voiceRecSso: Action[AnyContent] = TODO
}
