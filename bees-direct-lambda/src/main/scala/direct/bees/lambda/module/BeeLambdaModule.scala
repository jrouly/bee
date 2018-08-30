package direct.bees.lambda.module

import akka.actor.ActorSystem
import akka.stream.{ActorMaterializer, Materializer}
import com.softwaremill.macwire.{Module, wire}
import direct.bees.lambda.{BeeLambda, StandardBeeLambda}
import direct.bees.module.BeeServiceModule
import net.rouly.common.config.Configuration

import scala.concurrent.ExecutionContext

@Module
class BeeLambdaModule {

  implicit val actorSystem: ActorSystem = ActorSystem()
  implicit val executionContext: ExecutionContext = actorSystem.dispatcher
  implicit val materializer: Materializer = ActorMaterializer()

  lazy val configuration: Configuration = Configuration.default
  lazy val beeServiceModule: BeeServiceModule = wire[BeeServiceModule]
  lazy val lambda: BeeLambda = wire[StandardBeeLambda]

}
