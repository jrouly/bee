package direct.bees.lambda.module

import com.softwaremill.macwire.{Module, wire}
import direct.bees.lambda.{BeeLambda, StandardBeeLambda}
import direct.bees.module.BeeServiceModule
import net.rouly.common.config.Configuration

@Module
class BeeLambdaModule {

  lazy val configuration: Configuration = Configuration.default
  lazy val beeServiceModule: BeeServiceModule = wire[BeeServiceModule]
  lazy val lambda: BeeLambda = wire[StandardBeeLambda]

}
