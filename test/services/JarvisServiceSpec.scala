package services

import models.JarvisResponse
import org.scalamock.scalatest.MockFactory
import org.scalatest.{BeforeAndAfter, FunSpec}

import scala.concurrent.Future
import scala.concurrent.Future.successful

class JarvisServiceSpec extends FunSpec with MockFactory with BeforeAndAfter {
  val expectedResponse: Future[JarvisResponse] = successful(JarvisResponse("All good here. Was there anything else?"))

  val jarvisService: JarvisService = mock[JarvisService]

  describe("serverStatus") {
    it("should respond with a good status.") {
      (jarvisService.serverStatus _).expects().returning(successful(JarvisResponse("All good here. Was there anything else?")))
      assert(jarvisService.serverStatus.value === expectedResponse.value)
    }
  }
}

