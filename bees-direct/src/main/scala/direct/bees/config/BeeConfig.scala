package direct.bees.config

trait BeeConfig {

  def get(key: String, default: => String): String

}
