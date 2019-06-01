import controllers.JarvisController
import play.api.i18n.Langs
import play.api.mvc.ControllerComponents
import services.JarvisServicesModule

import scala.concurrent.ExecutionContext

trait JarvisModule extends JarvisServicesModule {

  import com.softwaremill.macwire._
  implicit val ec = ExecutionContext.global

  lazy val jarvisController: JarvisController = wire[JarvisController]

  def controllerComponents: ControllerComponents
}
