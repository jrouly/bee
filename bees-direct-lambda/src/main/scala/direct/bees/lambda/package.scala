package direct.bees

import java.io.{InputStream, OutputStream}

import com.typesafe.scalalogging.StrictLogging
import direct.bees.lambda.BeeLambda.BeeRequestStream
import direct.bees.lambda.model.{BeeRequest, BeeResponse}

import scala.util.Try

package object lambda {
  object io extends StrictLogging {

    type BeeRequestDeserializer = BeeRequestStream => Try[BeeRequest]
    type BeeResponseSerializer = BeeResponse => Array[Byte]

    private def readStream(inputStream: InputStream): Array[Byte] = {
      Stream
        .continually(inputStream.read)
        .takeWhile(_ != -1)
        .map(_.toByte)
        .toArray
    }

    def writeStream(data: Array[Byte], outputStream: OutputStream): Unit = {
      data.foreach(d => outputStream.write(d))
    }

    object Implicits {
      implicit val deserialize: BeeRequestDeserializer = {
        case stream => Try {
          val data = readStream(stream)
          new String(data).toInt
        } map BeeRequest.apply
      }

      implicit val serialize: BeeResponseSerializer = {
        case beeResponse => beeResponse.bees.map(_.buzz).mkString.getBytes
      }
    }

  }
}
