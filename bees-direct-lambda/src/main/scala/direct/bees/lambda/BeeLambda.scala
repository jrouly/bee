package direct.bees.lambda

import java.io.{InputStream, OutputStream}

import com.amazonaws.services.lambda.runtime.{Context, RequestStreamHandler}
import direct.bees.lambda.BeeLambda.{BeeRequestStream, BeeResponseStream}
import direct.bees.lambda.model.BeeResponse

trait BeeLambda extends RequestStreamHandler {

  override def handleRequest(input: BeeRequestStream, output: BeeResponseStream, context: Context) = {
    import io.Implicits._

    val beeResponse = processBeeRequestStream(input, context)
    io.writeStream(beeResponse, output)
  }

  def processBeeRequestStream(input: BeeRequestStream, context: Context): BeeResponse

}

object BeeLambda {

  type BeeRequestStream = InputStream
  type BeeResponseStream = OutputStream

}
