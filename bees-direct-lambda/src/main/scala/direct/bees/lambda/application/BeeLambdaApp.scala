package direct.bees.lambda.application

import java.io.{InputStream, OutputStream}

import com.amazonaws.services.lambda.runtime.{Context, RequestStreamHandler}
import com.softwaremill.macwire.wire
import direct.bees.lambda.module.BeeLambdaModule

object BeeLambdaApp extends RequestStreamHandler {

  lazy val beeLambdaModule = wire[BeeLambdaModule]

  override def handleRequest(input: InputStream, output: OutputStream, context: Context) =
    beeLambdaModule.lambda.handleRequest(input, output, context)

}
