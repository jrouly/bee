package direct.bees.config

class EnvironmentBeeConfig extends BeeConfig {
  override def get(key: String, default: => String) = {
    val envKey = keyToEnvironment(key)
    Option(System.getenv(envKey)).getOrElse(default)
  }

  private def keyToEnvironment(key: String): String = key.replaceAllLiterally(".", "_").toUpperCase
}

object EnvironmentBeeConfig {
  def apply: EnvironmentBeeConfig = new EnvironmentBeeConfig
}
