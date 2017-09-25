package direct.bees.module

import com.softwaremill.macwire.{Module, wire}
import com.typesafe.config.Config
import direct.bees.config.{BuzzConfig, BeeConfig, LoggingBeeConfig, TypesafeBeeConfig}

@Module
class BeeConfigModule(config: Config) {

  lazy val beeConfig: BeeConfig = LoggingBeeConfig(wire[TypesafeBeeConfig])
  lazy val buzzConfig: BuzzConfig = wire[BuzzConfig]

}
