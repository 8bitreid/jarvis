name := """JARVIS"""

version := "1.0.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

enablePlugins(JavaAppPackaging, DockerPlugin)

scalaVersion := "2.12.8"

crossScalaVersions := Seq("2.11.12", "2.12.8")

libraryDependencies ++= Seq(
    "org.scalatestplus.play" %% "scalatestplus-play" % "4.0.2" % Test,
    "com.softwaremill.macwire" %% "macros" % "2.3.2" % "provided"
)

scalacOptions ++= Seq(
    "-feature",
    "-deprecation",
    "-Xfatal-warnings"
)
//Docker Configuration
dockerEnvVars := Map("APPLICATION_SECRET"->"QCYtAnfkaZiwrNwnxIlR6CTfG3gf90Latabg5241ABR5W1uDFNIkn")
dockerExposedPorts ++= Seq(9000, 9001)

javaOptions in Universal ++= Seq(
    "-Dpidfile.path=/dev/null"
)
dockerUpdateLatest := true