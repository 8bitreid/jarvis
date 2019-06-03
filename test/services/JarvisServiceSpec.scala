package services

import models.{JarvisResponse, Version}
import org.scalamock.scalatest.MockFactory
import org.scalatest.FlatSpec

import scala.concurrent.Future
import scala.concurrent.Future.successful

class JarvisServiceSpec extends FlatSpec with MockFactory {

  val expectedResponse: Future[JarvisResponse] = successful(JarvisResponse("All good here. Was there anything else?"))
  val expectedVersion: Future[Version] = successful(Version(1,0,0))

  val mockCollaborator: JarvisService = mock[JarvisService]

  (mockCollaborator.serverStatus _).expects().returning(successful(JarvisResponse("All good here. Was there anything else?")))
  (mockCollaborator.getVersion _).expects().returning(successful(Version(1,0,0)))

  "JarvisService" should
    "reply with a greeting" in {
    assert(mockCollaborator.serverStatus.value === expectedResponse.value)
    assert(mockCollaborator.getVersion.value === expectedVersion.value)
  }
}

