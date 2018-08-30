package direct.bees.service

import direct.bees.config.BeeVarietyConfig
import direct.bees.model.Bee

/**
  * Highly configurable bee emission service.
  */
class ConfigurableBeeService(config: BeeVarietyConfig) extends BeeService {

  override lazy val bee: Bee = config.variety

}
