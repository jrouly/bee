package direct.bees.play.config

import com.typesafe.config.Config
import direct.bees.config.BeeConfig

import scala.util.Try

class TypesafeBeeConfig(config: Config) extends BeeConfig {
  override def get(key: String, default: => String) = Try(config.getString(key)).getOrElse(default)
}

object TypesafeBeeConfig {
  def apply(config: Config): TypesafeBeeConfig = new TypesafeBeeConfig(config)
}
