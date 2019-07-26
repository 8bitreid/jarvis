package di.versioning

import di.versioning.ClientModelsNotThings.ClientTypeThingWithOtherStuff

trait TransformerClient{
  def getTheTransformedThing: ClientTypeThingWithOtherStuff
}

class TransformerClientThing(transformer: TransformerThingy)extends TransformerClient {
  override def getTheTransformedThing: ClientTypeThingWithOtherStuff = transformer.transformTheThing().map {
    // using an interface breaks this.. since we don't know which implementation to use
    thing => ClientTypeThingWithOtherStuff(thing.name)
  }.getOrElse(ClientTypeThingWithOtherStuff(""))
}
