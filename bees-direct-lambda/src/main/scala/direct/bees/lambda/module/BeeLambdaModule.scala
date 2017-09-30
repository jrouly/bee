package direct.bees.lambda.module

import com.softwaremill.macwire.{Module, wire}
import direct.bees.lambda.{BeeLambda, LoggingBeeLambda, StandardBeeLambda}
import direct.bees.module.{BeeConfigModule, BeeServiceModule}

@Module
class BeeLambdaModule {

  lazy val beeConfigModule: BeeConfigModule = wire[BeeConfigModule]
  lazy val beeServiceModule: BeeServiceModule = wire[BeeServiceModule]

  lazy val lambda: BeeLambda = new LoggingBeeLambda(wire[StandardBeeLambda])

}
