package direct.bees.module

import com.softwaremill.macwire.{Module, wire}
import direct.bees.config.BeeVarietyConfig
import direct.bees.service._

@Module
class BeeServiceModule(config: BeeVarietyConfig) {

  lazy val beeService: BeeService = wire[ConfigurableBeeService]

}
