package direct.bees.lambda

import java.io.OutputStream

import com.typesafe.scalalogging.StrictLogging
import direct.bees.service.BeeService

class StandardBeeLambda(beeService: BeeService)
  extends BeeLambda
  with StrictLogging {

  def streamBees(output: OutputStream): Unit =
    output.write(beeService.bee)

}
