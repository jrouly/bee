package direct.bees.config

import direct.bees.model.Bee

class BeeVarietyConfig(beeConfig: BeeConfig) {

  lazy val varietyOfBee: Bee = {
    val buzz = beeConfig.get("kind.of.bee", Bee.standard.buzz)
    Bee(buzz)
  }

}
