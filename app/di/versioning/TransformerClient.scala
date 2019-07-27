package di.versioning

import di.versioning.ClientModelsNotThings.ClientTypeThingWithOtherStuff

trait TransformerClient{
  def getTheTransformedThing: ClientTypeThingWithOtherStuff
}

class TransformerClientThing(transformer: TransformerThingy)extends TransformerClient {
  override def getTheTransformedThing: ClientTypeThingWithOtherStuff = transformer.transformTheThing().map {
    // using an interface breaks this.. since we don't know which implementation to use
    transformedThing => ClientTypeThingWithOtherStuff(transformedThing.name, otherStuff, transformedThing.id)
  }.getOrElse(ClientTypeThingWithOtherStuff("", 0, 0))

  private val otherStuff: Int = 42
}

// TODO add new function login for ThingB...


