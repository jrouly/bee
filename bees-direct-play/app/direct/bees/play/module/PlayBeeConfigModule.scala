package direct.bees.play.module

import com.softwaremill.macwire.{Module, wire}
import com.typesafe.config.Config
import direct.bees.config._
import direct.bees.play.config.TypesafeBeeConfig

@Module
class PlayBeeConfigModule(config: Config) {

  lazy val beeConfig: BeeConfig = LoggingBeeConfig(
    MultiplexingBeeConfig(
      wire[TypesafeBeeConfig],
      wire[EnvironmentBeeConfig]
    )
  )

  lazy val buzzConfig: BeeVarietyConfig = wire[BeeVarietyConfig]

}
