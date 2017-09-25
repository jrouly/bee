package direct.bees.module

import com.softwaremill.macwire.wire
import com.typesafe.config.Config
import direct.bees.controllers.BeeController
import play.api.mvc.ControllerComponents

trait BeeControllers {

  def config: Config
  lazy val beeConfigModule: BeeConfigModule = wire[BeeConfigModule]
  lazy val beeServiceModule: BeeServiceModule = wire[BeeServiceModule]

  def controllerComponents: ControllerComponents
  lazy val beeController: BeeController = wire[BeeController]

}
