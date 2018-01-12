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

    it("should bee") {
      service.bee shouldEqual Bee.standard
    }

    it("should moreBees") {
      service.moreBees.take(0) should have length 0
      service.moreBees.take(50) should have length 50
      service.moreBees.take(500) should have length 500

      service.moreBees.take(500) shouldEqual Stream.fill(500)(Bee.standard)
    }

    it("should nBees") {
      service.nBees(0) should have length 0
      service.nBees(50) should have length 50
      service.nBees(500) should have length 500

      service.nBees(500) shouldEqual Stream.fill(500)(Bee.standard)
    }

  }
}
