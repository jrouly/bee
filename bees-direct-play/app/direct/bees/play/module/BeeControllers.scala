package direct.bees.play.module

import com.softwaremill.macwire.wire
import com.typesafe.config.Config
import direct.bees.module.BeeServiceModule
import direct.bees.play.controllers.BeeController
import play.api.mvc.ControllerComponents

trait BeeControllers {

  def config: Config
  lazy val beeConfigModule: PlayBeeConfigModule = wire[PlayBeeConfigModule]
  lazy val beeServiceModule: BeeServiceModule = wire[BeeServiceModule]

  def controllerComponents: ControllerComponents
  lazy val beeController: BeeController = wire[BeeController]

}
