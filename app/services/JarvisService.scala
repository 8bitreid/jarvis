package services

import jarvis.info.BuildInfo
import models.JarvisResponse

import scala.concurrent.{ExecutionContext, Future}

class JarvisService {

  implicit val ec = ExecutionContext.global

  def serverStatus: Future[JarvisResponse] = Responses.genResponse.map(resp => JarvisResponse(resp))

  def greetingMessage: Future[JarvisResponse] = {
    Future.successful(JarvisResponse("Hello, my name is Jarvis."))
  }

  def getBuildInfo: Future[String] = {
    Future.successful(JarvisVersion.currentVersionJson)
  }


  object JarvisVersion {
    val currentVersionJson = BuildInfo.toJson
  }
  object Responses {

    import scala.util.Random

    private val jarvisResponse: Seq[String] = Seq(
      "Everything here looks tip top.",
      "All good here.",
      "It's all rainbows and butterflies."
    )
    private val jarvisPoliteRequest: Seq[String] = Seq(
      "Was there anything else?",
      "How else may I be of service?",
      "Will that be all?"
    )

    def genResponse: Future[String] = {
      val rand = new Random
      val positiveExpression = jarvisResponse(rand.nextInt(jarvisResponse.length))
      val politeRequest = jarvisPoliteRequest(rand.nextInt(jarvisPoliteRequest.length))
      Future.successful(s"$positiveExpression $politeRequest")
    }
  }

}
