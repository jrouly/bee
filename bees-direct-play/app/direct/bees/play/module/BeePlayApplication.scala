package direct.bees.play.module

import com.softwaremill.macwire.{Module, wire}
import direct.bees.module.{BeeConfigModule, BeeServiceModule}
import net.rouly.common.config.Configuration

@Module
class BeePlayApplication(configuration: Configuration) {

  lazy val beeConfigModule: BeeConfigModule = wire[BeeConfigModule]

  lazy val beeServiceModule: BeeServiceModule = wire[BeeServiceModule]

}

