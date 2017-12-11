package direct.bees.play.module

import com.softwaremill.macwire.wire
import direct.bees.play.controllers.BeeController
import play.api.mvc.ControllerComponents

trait BeeControllers {

  def beeApplication: BeePlayApplication
  def controllerComponents: ControllerComponents

  lazy val beeController: BeeController = wire[BeeController]

}
