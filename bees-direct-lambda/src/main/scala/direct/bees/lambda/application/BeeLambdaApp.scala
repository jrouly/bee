package direct.bees.lambda.application

import java.io.{InputStream, OutputStream}

import com.amazonaws.services.lambda.runtime.{Context, RequestStreamHandler}
import com.softwaremill.macwire.wire
import direct.bees.lambda.module.BeeLambdaModule

object BeeLambdaApp extends RequestStreamHandler {

  private lazy val lambda = wire[BeeLambdaModule].lambda

  override def handleRequest(input: InputStream, output: OutputStream, context: Context): Unit =
    lambda.streamBees(output)

}
