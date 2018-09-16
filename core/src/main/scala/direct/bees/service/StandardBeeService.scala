package direct.bees.service

import direct.bees.model.Bee

/**
  * Standardized bee service for emitting standardized ISO bees.
  */
class StandardBeeService extends BeeService {

  /**
    * Emit a standard bee.
    */
  override lazy val bee: Bee = Bee.standard

}
