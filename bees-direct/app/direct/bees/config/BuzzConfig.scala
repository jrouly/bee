package direct.bees.config

import direct.bees.models.Bee

class BuzzConfig(beeConfig: BeeConfig) {

  lazy val varietyOfBee: Bee = {
    val buzz = beeConfig.get("kind.of.bee", Bee.standard.buzz)
    Bee(buzz)
  }

}
