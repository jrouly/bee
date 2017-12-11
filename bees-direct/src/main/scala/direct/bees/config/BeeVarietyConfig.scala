package direct.bees.config

import direct.bees.model.Bee
import net.rouly.common.config.Configuration

class BeeVarietyConfig(configuration: Configuration) {

  lazy val varietyOfBee: Bee = {
    val buzz = configuration.get("kind.of.bee", Bee.standard.buzz)
    Bee(buzz)
  }

}
