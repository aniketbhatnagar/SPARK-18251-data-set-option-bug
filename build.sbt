name := """SPARK-18251-data-set-option-bug"""

version := "1.0"

scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % "2.0.1",
  "org.apache.spark" %% "spark-sql" % "2.0.1")

outputStrategy := Some(StdoutOutput)

fork := true

