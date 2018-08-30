package direct.bees.service

import direct.bees.model.Bee
import org.scalatest.{BeforeAndAfterEach, FunSpec, Matchers}

class StandardBeeServiceTest
  extends FunSpec
  with Matchers
  with BeforeAndAfterEach {

  var service: StandardBeeService = _

  override def beforeEach {
    service = new StandardBeeService
  }

  describe("StandardBeeServiceTest") {

    it("should emit an ISO bee") {
      service.bee shouldEqual Bee.standard
    }

  }
}
