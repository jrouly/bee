package direct.bees.module

import com.softwaremill.macwire.{Module, wire}
import direct.bees.config.BuzzConfig
import direct.bees.service._

@Module
class BeeServiceModule(config: BuzzConfig) {

  lazy val beeService: BeeService = wire[ConfigurableBeeService]

}
