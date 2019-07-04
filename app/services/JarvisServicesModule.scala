package services

trait JarvisServicesModule {

  import com.softwaremill.macwire._

  lazy val jarvisService = wire[JarvisService]
  lazy val jarvisData = wire[JarvisData]
}
