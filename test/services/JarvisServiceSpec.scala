package services

import models.JarvisResponse
import org.scalamock.scalatest.MockFactory
import org.scalatest.FlatSpec

import scala.concurrent.{ExecutionContext, Future}
import scala.concurrent.Future.successful

class JarvisServiceSpec extends FlatSpec with MockFactory {
  implicit val ec = ExecutionContext.global

  val expectedResponse: Future[JarvisResponse] = successful(JarvisResponse("All good here. Was there anything else?"))

  val mockCollaborator: JarvisService = mock[JarvisService]
  (mockCollaborator.serverStatus _).expects().returning(successful(JarvisResponse("All good here. Was there anything else?")))

  "JarvisService" should "reply with a greeting" in {
    assert(mockCollaborator.serverStatus().value === expectedResponse.value)
  }
}

