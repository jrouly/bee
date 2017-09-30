package direct.bees.module

import com.softwaremill.macwire.{Module, wire}
import com.typesafe.config.Config
import direct.bees.config.{BeeVarietyConfig, BeeConfig, LoggingBeeConfig, TypesafeBeeConfig}

@Module
class BeeConfigModule(config: Config) {

  lazy val beeConfig: BeeConfig = LoggingBeeConfig(wire[TypesafeBeeConfig])
  lazy val buzzConfig: BeeVarietyConfig = wire[BeeVarietyConfig]

}
