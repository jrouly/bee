package direct.bees.service

import direct.bees.model.Bee

/**
  * Enterprise-ready service for producing bees.
  */
trait BeeService {

  /**
    * Emit a bee.
    */
  def bee: Bee

}
