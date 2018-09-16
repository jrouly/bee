package direct.bees.module

import com.softwaremill.macwire.{Module, wire}
import direct.bees.config.BeeVarietyConfig
import direct.bees.service._
import net.rouly.common.config.Configuration

@Module
class BeeServiceModule(configuration: Configuration) {

  lazy val buzzConfig: BeeVarietyConfig = wire[BeeVarietyConfig]
  lazy val beeService: BeeService = wire[ConfigurableBeeService]

}
