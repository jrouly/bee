package direct.bees.config

class MultiplexingBeeConfig(underlying: BeeConfig*) extends BeeConfig {
  override def get(key: String, default: => String): String =
    underlying
      .toStream
      .map(_.get(key, default))
      .find(_ != default)
      .getOrElse(default)
}

object MultiplexingBeeConfig {
  def apply(underlying: BeeConfig*): MultiplexingBeeConfig = new MultiplexingBeeConfig(underlying: _*)
  def applySeq(underlying: Seq[BeeConfig]): MultiplexingBeeConfig = new MultiplexingBeeConfig(underlying: _*)
}
