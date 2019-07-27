package di.versioning

import di.versioning.TransformerModels._

trait TransformerThingy {
  def transformTheThing(): Option[ThingP]
}

class TransformerImpl extends TransformerThingy {
  override def transformTheThing(): Option[ThingP] = Some(ThingA(name = "reid", id = 1, sound = "buzzz"))

}

class TransformerImplV2 extends TransformerThingy {
  override def transformTheThing(): Option[ThingP] = Some(ThingB(name = "notReid", sound = "grrrr", b = 2, c = 3, d = "that's all folks"))

}
