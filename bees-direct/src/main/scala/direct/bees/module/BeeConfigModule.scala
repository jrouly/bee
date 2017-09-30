package direct.bees.module

import com.softwaremill.macwire.{Module, wire}
import direct.bees.config._

@Module
class BeeConfigModule {

  lazy val beeConfig: BeeConfig = LoggingBeeConfig(wire[EnvironmentBeeConfig])
  lazy val buzzConfig: BeeVarietyConfig = wire[BeeVarietyConfig]

}
