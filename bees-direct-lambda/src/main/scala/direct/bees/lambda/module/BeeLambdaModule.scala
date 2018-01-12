package direct.bees.lambda.module

import com.softwaremill.macwire.{Module, wire}
import direct.bees.lambda.{BeeLambda, LoggingBeeLambda, StandardBeeLambda}
import direct.bees.module.{BeeConfigModule, BeeServiceModule}
import net.rouly.common.config.Configuration

@Module
class BeeLambdaModule {

  lazy val configuration: Configuration = Configuration.default
  lazy val beeConfigModule: BeeConfigModule = wire[BeeConfigModule]
  lazy val beeServiceModule: BeeServiceModule = wire[BeeServiceModule]

  lazy val lambda: BeeLambda = new LoggingBeeLambda(wire[StandardBeeLambda])

}
