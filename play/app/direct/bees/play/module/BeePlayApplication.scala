package direct.bees.play.module

import com.softwaremill.macwire.{Module, wire}
import direct.bees.module.BeeServiceModule
import direct.bees.play.controllers.BeeController
import net.rouly.common.config.Configuration
import play.api.mvc.ControllerComponents

@Module
class BeePlayApplication(
  configuration: Configuration,
  controllerComponents: ControllerComponents
) {

  lazy val beeServiceModule: BeeServiceModule = wire[BeeServiceModule]
  lazy val beeController: BeeController = wire[BeeController]

}
