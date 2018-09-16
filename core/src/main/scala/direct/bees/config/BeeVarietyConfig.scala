package direct.bees.config

import direct.bees.model.Bee
import net.rouly.common.config.Configuration

class BeeVarietyConfig(configuration: Configuration) {

  lazy val variety: Bee = Bee(configuration.get("kind.of.bee", Bee.standard.buzz))

}
