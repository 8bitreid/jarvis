package di.versioning

class ThingyModule {
  import com.softwaremill.macwire._

  lazy val clientThingy: TransformerClient = wire[TransformerClientThing]
  lazy val transformerThing: TransformerThingy = wire[TransformerImpl]
}
