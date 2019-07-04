package services

import models.{JarvisResponse, Version}
import org.mongodb.scala.Observable

import scala.concurrent.Future

class JarvisService(data: JarvisData) {

  def serverStatus: Future[JarvisResponse] = {
    Future.successful(JarvisResponse("All good here.  Was there anything else?"))
  }

  def greetingMessage: Future[JarvisResponse] = {
    Future.successful(JarvisResponse("Hello, my name is Jarvis, 🤓."))
  }

  def getVersion: Future[Version] = {
    Future.successful(Version(1, 0, 0))
  }

  def getSomething: Future[String] = {
    data.db.listCollectionNames().subscribe(observer => observer)
  }

}
