package direct.bees.service

import direct.bees.config.BeeVarietyConfig
import direct.bees.model.Bee

class ConfigurableBeeService(buzzConfig: BeeVarietyConfig) extends StandardBeeService {

  override lazy val bee: Bee = buzzConfig.varietyOfBee

}
