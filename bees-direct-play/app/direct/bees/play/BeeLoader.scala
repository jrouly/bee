package direct.bees.play

import com.softwaremill.macwire.wire
import direct.bees.play.module.BeePlayApplication
import net.rouly.common.server.play.filters.ApplicationHttpFilters
import net.rouly.common.server.play.module._
import play.api.ApplicationLoader.Context
import play.api._
import play.api.mvc.EssentialFilter
import play.api.routing.Router
import play.filters.HttpFiltersComponents
import router.Routes

class BeeLoader extends AppServerLoader {

  def buildComponents(context: Context): BeeComponents =
    new BuiltInComponentsFromContext(context) with BeeComponents

}

trait BeeComponents
  extends AppServerComponents
  with HttpFiltersComponents {
  self: BuiltInComponents =>

  override lazy val router: Router = {
    val prefix = "/" // routing prefix
    wire[Routes]
  }
  override lazy val httpFilters: List[EssentialFilter] = ApplicationHttpFilters.commonFilters

  lazy val beeApplication: BeePlayApplication = wire[BeePlayApplication]
}
