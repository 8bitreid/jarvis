package services

import org.mongodb.scala._

class JarvisData {

  private val uri: String = "mongodb+srv://jarvis:HVSVIrOmltso5Kxl@jarvis-mongo-smpel.mongodb.net/sample_airbnb?retryWrites=true&w=majority"
  private val client: MongoClient = MongoClient(uri)
  val db: MongoDatabase = client.getDatabase("sample_airbnb")

}
