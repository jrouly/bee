package direct.bees.lambda

import com.amazonaws.services.lambda.runtime.Context
import com.typesafe.scalalogging.StrictLogging
import direct.bees.lambda.BeeLambda._
import direct.bees.lambda.model.BeeResponse
import direct.bees.service.BeeService

import scala.util.control.NonFatal

class StandardBeeLambda(
  beeService: BeeService
) extends BeeLambda
  with StrictLogging {

  def processBeeRequestStream(input: BeeRequestStream, context: Context): BeeResponse = {
    import io.Implicits._

    val beeResponse = for {
      beeRequest <- input
      bees = beeService.nBees(beeRequest.numberOfBees)
      beeResponse = BeeResponse(bees)
    } yield beeResponse

    val handledBeeResponse = beeResponse.fold({
      case NonFatal(error) =>
        logger.error("Unknown serialization error encountered.", error)
        BeeResponse.single
    }, identity)

    handledBeeResponse
  }

}
