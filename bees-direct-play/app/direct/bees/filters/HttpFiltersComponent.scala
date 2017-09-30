package direct.bees.filters

import akka.stream.Materializer
import play.api.http.DefaultHttpFilters
import play.api.mvc._

import scala.concurrent.ExecutionContext

object CommonHttpFilters {
  def common(
    implicit
    mat: Materializer,
    executionContext: ExecutionContext
  ): List[EssentialFilter] =
    List(new RequestLoggingFilter)
}

class CommonHttpFilters(
  implicit
  mat: Materializer,
  executionContext: ExecutionContext
) extends DefaultHttpFilters(CommonHttpFilters.common: _*)
