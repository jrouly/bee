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
  .aggregate(`bees-direct`)

lazy val `bees-direct` = project
  .enablePlugins(PlayScala)
  .settings(commonSettings)
  .settings(libraryDependencies ++= Seq(
    Common.enumeratum,
    Common.logback,
    Common.scalaLogging,
    Common.scalaTest,
    Common.macwireMacros,
    Common.macwireUtil,
    Play26.playJson,
    Play26.playServer,
    Play26.playTest
  ))
