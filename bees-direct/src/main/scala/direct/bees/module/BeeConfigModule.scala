package direct.bees.module

import com.softwaremill.macwire.{Module, wire}
import direct.bees.config._
import net.rouly.common.config.Configuration

@Module
class BeeConfigModule(configuration: Configuration) {

  lazy val buzzConfig: BeeVarietyConfig = wire[BeeVarietyConfig]

}
