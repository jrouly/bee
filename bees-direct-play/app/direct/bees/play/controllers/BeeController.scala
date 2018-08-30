package direct.bees.play.controllers

import akka.stream.scaladsl.Source
import direct.bees.play.controllers.BeeWriteables._
import direct.bees.service.BeeService
import play.api.mvc.{AbstractController, Action, AnyContent, ControllerComponents}

class BeeController(
  cc: ControllerComponents,
  beeService: BeeService
) extends AbstractController(cc) {

  def bee: Action[AnyContent] = Action {
    Ok(beeService.bee)
  }

  def bees: Action[AnyContent] = Action {
    val beeSource = Source.repeat(beeService.bee)
    Ok.chunked(beeSource)
  }

}
