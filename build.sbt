organization := "com.github.krasserm"

name := "streamz"

version := "0.1-SNAPSHOT"

scalaVersion in ThisBuild := "2.11.0"

resolvers in ThisBuild += "Scalaz Bintray Repo" at "http://dl.bintray.com/scalaz/releases"

scalacOptions in ThisBuild ++= Seq("-feature", "-language:higherKinds", "-language:implicitConversions")

libraryDependencies in ThisBuild ++= Seq(
  "com.typesafe.akka" %% "akka-testkit" % Version.akka      % "test",
  "org.scalatest"     %% "scalatest"    % Version.scalatest % "test"
)

lazy val root = (project.in(file("."))).aggregate(util, akkaCamel, akkaPersistence)

lazy val util = project.in(file("streamz-util"))

lazy val akkaCamel = project.in(file("streamz-akka-camel")).dependsOn(util)

lazy val akkaPersistence = project.in(file("streamz-akka-persistence")).dependsOn(util)
