package direct.bees.play.controllers

import direct.bees.model.Bee
import play.api.http.{ContentTypeOf, ContentTypes, Writeable}
import play.api.mvc.Codec

trait BeeWriteables {
  implicit def writeable(implicit codec: Codec): Writeable[Bee] = Writeable(bee => codec.encode(bee.buzz))
  implicit val contentType: ContentTypeOf[Bee] = ContentTypeOf(Some(ContentTypes.TEXT))
}

object BeeWriteables extends BeeWriteables
