package services

import models.{JarvisResponse, Version}
import org.scalamock.scalatest.MockFactory
import org.scalatest.FunSpec
import org.scalatest.BeforeAndAfter

import scala.concurrent.Future
import scala.concurrent.Future.successful

class JarvisServiceSpec extends FunSpec with MockFactory with BeforeAndAfter{

  val expectedResponse: Future[JarvisResponse] = successful(JarvisResponse("All good here. Was there anything else?"))
  val expectedVersion: Future[Version] = successful(Version(1,0,0))

  val jarvisService: JarvisService = mock[JarvisService]

  describe ("serverStatus") {
    it("should respond with a good status.") {
      (jarvisService.serverStatus _).expects().returning(successful(JarvisResponse("All good here. Was there anything else?")))
      assert(jarvisService.serverStatus.value === expectedResponse.value)
    }
  }
  describe("getVersoin"){
    it("should respond with a valid version"){
      (jarvisService.getVersion _).expects().returning(successful(Version(1,0,0)))
      assert(jarvisService.getVersion.value === expectedVersion.value)
    }
  }
}

