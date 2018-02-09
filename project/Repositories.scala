import sbt._
import sbt.Keys._
import java.net.URL

object Repositories {

  private def resolverUrl(id: String, url: String): Resolver =
    Resolver.url(id, new URL(url))(Resolver.ivyStylePatterns)

  private def resolverArtifactory(id: String, url: String, realm: String = "Artifactory Realm"): Resolver =
    realm at s"$url/$id"

  object RoulyNet {
    private lazy val base = "https://artifacts.rouly.net/artifactory"
    lazy val snapshot = resolverArtifactory("sbt-dev", base)
    lazy val release = resolverArtifactory("sbt-release", base)
  }

}
