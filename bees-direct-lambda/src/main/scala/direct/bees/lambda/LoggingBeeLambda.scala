package direct.bees.lambda

import com.amazonaws.services.lambda.runtime.Context
import com.typesafe.scalalogging.StrictLogging
import direct.bees.lambda.BeeLambda.BeeRequestStream
import direct.bees.lambda.model.BeeResponse

class LoggingBeeLambda(
  underlying: BeeLambda
) extends BeeLambda
  with StrictLogging {

  def processBeeRequestStream(input: BeeRequestStream, context: Context): BeeResponse = {
    logger.debug(s"Incoming request for bees requestId=${context.getAwsRequestId}")
    underlying.processBeeRequestStream(input, context)
  }

}
