import play.api.libs.json.{Json, OFormat}

package object models {

  case class JarvisResponse(message: String)

  object JarvisResponse {
    implicit val JarvisResponse: OFormat[JarvisResponse] = Json.format[JarvisResponse]
  }

}
