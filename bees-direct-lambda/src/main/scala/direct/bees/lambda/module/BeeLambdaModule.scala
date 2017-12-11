package direct.bees.lambda.module

import com.softwaremill.macwire.{Module, wire}
import direct.bees.lambda.module.BeeLambdaModule.BeeLambdaConfig
import direct.bees.lambda.{BeeLambda, LoggingBeeLambda, StandardBeeLambda}
import direct.bees.module.{BeeConfigModule, BeeServiceModule}
import net.rouly.common.config.Configuration
import net.rouly.common.config.decorators.{EnvironmentConfiguration, LoggingConfiguration, PropertiesConfiguration}

@Module
class BeeLambdaModule {

  lazy val configuration: Configuration = wire[BeeLambdaConfig]
  lazy val beeConfigModule: BeeConfigModule = wire[BeeConfigModule]
  lazy val beeServiceModule: BeeServiceModule = wire[BeeServiceModule]

  lazy val lambda: BeeLambda = new LoggingBeeLambda(wire[StandardBeeLambda])

}

object BeeLambdaModule {
  class BeeLambdaConfig
    extends Configuration
    with LoggingConfiguration
    with EnvironmentConfiguration
    with PropertiesConfiguration
}
