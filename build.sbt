import Dependencies._
import Repositories._

name := "bees.direct"

lazy val commonSettings = Seq(
  organization := "direct.bees",
  scalaVersion := "2.12.2",
  version := "0.0.3",
  isSnapshot := false,
  resolvers += RoulyNet.release
)

lazy val root = (project in file("."))
  .settings(commonSettings)
  .aggregate(
    `bees-direct`,
    `bees-direct-play`,
    `bees-direct-lambda`
  )
  .settings(
    publish in Docker := {},
    publishArtifact := false
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
  .settings(libraryDependencies ++= Seq(
    AWS.lambda
  ))
  .settings(
    assemblyJarName in assembly := "bees-direct-lambda.jar",
    mainClass in assembly := Some("direct.bees.lambda.application.BeeLambdaApplication")
  )
