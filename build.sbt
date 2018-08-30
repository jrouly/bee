import Bintray._
import Dependencies._

name := "bees.direct"

lazy val noPublish = Seq(
  publishArtifact := false,
  publish in Docker := {},
  publishLocal := {},
  publish := {}
)

lazy val commonSettings = Seq(
  licenses += ("MIT", url("http://opensource.org/licenses/MIT")),
  organization := "direct.bees",
  scalaVersion := "2.12.2",
  version := "0.0.5",
  isSnapshot := false
) ++ bintraySettings

lazy val root = (project in file("."))
  .settings(commonSettings)
  .settings(noPublish)
  .aggregate(
    `bees-direct`,
    `bees-direct-play`,
    `bees-direct-lambda`
  )

lazy val `bees-direct` = project
  .settings(commonSettings)
  .settings(libraryDependencies ++= Seq(
    Rouly.libCommon,
    Common.logback,
    Common.macwireMacros,
    Common.macwireUtil,
    Common.scalaLogging,
    Common.scalaTest
  ))

lazy val `bees-direct-play` = project
  .enablePlugins(PlayScala)
  .enablePlugins(DockerPlugin)
  .dependsOn(`bees-direct`)
  .settings(commonSettings)
  .settings(libraryDependencies ++= Seq(
    Rouly.libCommon,
    Play26.libCommonServer,
    Play26.playJson,
    Play26.playServer,
    Play26.playTest
  ))
  .settings(dockerBaseImage := "openjdk:8-jre")
  .settings(dockerRepository := Some("jrouly"))
  .settings(dockerUpdateLatest := true)

lazy val `bees-direct-lambda` = project
  .dependsOn(`bees-direct`)
  .settings(commonSettings)
  .settings(libraryDependencies += AWS.lambda)
  .settings(
    assemblyJarName in assembly := "bees-direct-lambda.jar",
    mainClass in assembly := Some("direct.bees.lambda.application.BeeLambdaApplication")
  )

resolvers += Resolver.bintrayRepo("jrouly", "sbt-release")
