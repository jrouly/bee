import Dependencies._

import com.typesafe.sbt.SbtScalariform.ScalariformKeys
import scalariform.formatter.preferences._

name := """bees.direct"""

lazy val scalariformPreferences = FormattingPreferences()

lazy val commonSettings = Seq(
  organization := "direct.bees",
  version := "0.0.0",
  scalaVersion := "2.12.2",
  ScalariformKeys.preferences := scalariformPreferences
)

lazy val root = (project in file("."))
  .settings(commonSettings)
  .aggregate(
    `bees-direct`,
    `bees-direct-play`,
    `bees-direct-lambda`
  )

lazy val `bees-direct` = project
  .settings(commonSettings)
  .settings(libraryDependencies ++= Seq(
    Common.logback,
    Common.scalaLogging,
    Common.scalaTest
  ))

lazy val `bees-direct-play` = project
  .enablePlugins(PlayScala)
  .dependsOn(`bees-direct`)
  .settings(commonSettings)
  .settings(libraryDependencies ++= Seq(
    Common.macwireMacros,
    Common.macwireUtil,
    Play26.playJson,
    Play26.playServer,
    Play26.playTest
  ))


lazy val `bees-direct-lambda` = project
  .dependsOn(`bees-direct`)
  .settings(commonSettings)
  .settings(libraryDependencies ++= Seq(
    AWS.lambda
  ))
