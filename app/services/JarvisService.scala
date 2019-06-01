package services

import models.JarvisResponse
import scala.concurrent.Future

class JarvisService {

  def serverStatus(): Future[JarvisResponse] = {
    Future.successful(JarvisResponse("All good here.  Was there anything else?"))
  }

  def greetingMessage():Future[JarvisResponse] = {
    Future.successful(JarvisResponse("Hello, my name is Jarvis, 🤓."))
  }

}
