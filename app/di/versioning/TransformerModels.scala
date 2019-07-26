package di.versioning

object TransformerModels {
  trait ThingP
  case class ThingA(name: String, id: Int, sound: String) extends ThingP

  case class ThingB(name: String, sound: String, b: Int, c: Int, d: String) extends ThingP

}
