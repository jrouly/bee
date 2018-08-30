package direct.bees.config

import direct.bees.model.Bee
import net.rouly.common.config.{Configuration, MemoryConfiguration}
import org.scalatest.{BeforeAndAfterEach, FunSpec, Matchers}

class BeeVarietyConfigTest
  extends FunSpec
  with Matchers
  with BeforeAndAfterEach {

  var config: Configuration = _
  var beeVarietyConfig: BeeVarietyConfig = _

  override def beforeEach {
    config = MemoryConfiguration(Map.empty)
    beeVarietyConfig = new BeeVarietyConfig(config)
  }

  describe("varietyOfBee") {
    it("should default correctly") {
      beeVarietyConfig.variety shouldEqual Bee.standard
    }

    it("should correctly configure") {
      beeVarietyConfig = new BeeVarietyConfig(MemoryConfiguration(Map("kind.of.bee" -> "duck")))
      beeVarietyConfig.variety shouldEqual Bee("duck")
    }
  }

}
