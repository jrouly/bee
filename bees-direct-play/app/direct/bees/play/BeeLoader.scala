package direct.bees.play

import com.softwaremill.macwire.wire
import com.typesafe.config.ConfigFactory
import direct.bees.play.filters.CommonHttpFilters
import direct.bees.play.module.BeeControllers
import play.api.ApplicationLoader.Context
import play.api._
import play.api.mvc.EssentialFilter
import play.api.routing.Router
import play.filters.HttpFiltersComponents
import router.Routes

class BeeLoader extends ApplicationLoader {
  def buildComponents(context: Context): BeeComponents =
    new BuiltInComponentsFromContext(context) with BeeComponents

  override def load(context: ApplicationLoader.Context): Application = {
    // set up logger
    LoggerConfigurator(context.environment.classLoader).foreach {
      _.configure(context.environment, context.initialConfiguration, Map.empty)
    }

    val components = buildComponents(context)
    components.application
  }
}

trait BeeComponents
  extends BuiltInComponents
  with BeeControllers
  with HttpFiltersComponents {
  self: BuiltInComponents =>

  implicit lazy val as = actorSystem
  implicit lazy val ec = executionContext

  lazy val prefix = "/" // routing prefix

  lazy val mode = environment.mode
  lazy val config = ConfigFactory.defaultApplication

  override lazy val router: Router = wire[Routes]
  override lazy val httpFilters: Seq[EssentialFilter] = wire[CommonHttpFilters].filters
}

