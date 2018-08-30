package direct.bees.lambda.model

import direct.bees.model.Bee

case class BeeResponse(bees: Seq[Bee])

object BeeResponse {
  def single: BeeResponse = BeeResponse(Stream(Bee.standard))
}
