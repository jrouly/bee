package direct.bees.config

import com.typesafe.scalalogging.StrictLogging

import scala.collection.{concurrent, mutable}

class LoggingBeeConfig(underlying: BeeConfig) extends BeeConfig with StrictLogging {

  private val configMap: mutable.Map[String, String] = new concurrent.TrieMap[String, String]

  override def get(key: String, default: => String): String = {
    val value = underlying.get(key, default)
    val ValuePattern = value

    configMap.get(key) match {
      case Some(ValuePattern) => // same value as before, let it be
      case _ =>
        configMap.put(key, value)
        logger.info(s"loaded config: ${key}=${value}")
    }

    value
  }

}

object LoggingBeeConfig {
  def apply(underlying: BeeConfig): LoggingBeeConfig = new LoggingBeeConfig(underlying)
}

