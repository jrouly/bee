package direct.bees.lambda.application

import com.softwaremill.macwire.wire
import direct.bees.lambda.module.BeeLambdaModule

object BeeLambdaApp extends App {
  lazy val beeLambdaModule = wire[BeeLambdaModule]
  def lambda = beeLambdaModule.lambda
}
