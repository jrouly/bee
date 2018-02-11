package direct.bees.play

import com.softwaremill.macwire.wire
import com.typesafe.config.ConfigFactory
import direct.bees.play.module.{BeeControllers, BeePlayApplication}
import net.rouly.common.server.play.config.AppServerConfig
import net.rouly.common.server.play.filters.ApplicationHttpFilters
import net.rouly.common.server.play.module._
import play.api.ApplicationLoader.Context
import play.api._
import play.api.routing.Router
import play.filters.HttpFiltersComponents
import router.Routes

class BeeLoader extends AppServerLoader {
  def buildComponents(context: Context): BeeComponents =
    new BuiltInComponentsFromContext(context) with BeeComponents
}

trait BeeComponents
  extends AppServerComponents
  with BeeControllers
  with HttpFiltersComponents {
  self: BuiltInComponents =>

  lazy val prefix = "/" // routing prefix

  override lazy val router: Router = wire[Routes]
  override lazy val httpFilters = new ApplicationHttpFilters(
    ApplicationHttpFilters.commonFilters: _*
  ).filters

  lazy val config = ConfigFactory.defaultApplication
  lazy val appConfig = wire[AppServerConfig]

  override lazy val beeApplication: BeePlayApplication = wire[BeePlayApplication]

}
