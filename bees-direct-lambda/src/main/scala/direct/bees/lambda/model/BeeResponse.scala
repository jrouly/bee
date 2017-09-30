package direct.bees.lambda.model

import direct.bees.model.Bee

case class BeeResponse(bees: Stream[Bee])

object BeeResponse {
  def single: BeeResponse = BeeResponse(Stream(Bee.standard))
}
