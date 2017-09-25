package direct.bees.service

import direct.bees.config.BuzzConfig
import direct.bees.models.Bee

class ConfigurableBeeService(buzzConfig: BuzzConfig) extends StandardBeeService {

  override lazy val bee: Bee = buzzConfig.varietyOfBee

}
