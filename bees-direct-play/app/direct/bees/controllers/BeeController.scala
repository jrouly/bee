package direct.bees.controllers

import akka.stream.scaladsl.Source
import direct.bees.controllers.BeeWriteables._
import direct.bees.service.BeeService
import play.api.mvc.{AbstractController, ControllerComponents}

class BeeController(
  cc: ControllerComponents,
  beeService: BeeService
) extends AbstractController(cc) {

  def bee = Action {
    Ok(beeService.bee)
  }

  def moreBees = Action {
    Ok.chunked(Source(beeService.moreBees))
  }

  def nBees(n: Int) = Action {
    Ok.chunked(Source(beeService.nBees(n)))
  }

}
