package di.versioning

object TransformerModels {
  trait ThingP {
    def name: String
    def sound: String
    // not shared field...
  }
  case class ThingA(name: String, id: Int, sound: String) extends ThingP

  // new version of thing to transform
  case class ThingB(name: String, sound: String, b: Int, c: Int, d: String) extends ThingP

}
