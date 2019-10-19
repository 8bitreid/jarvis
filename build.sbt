name := """JARVIS"""

lazy val root = (project in file("."))
.enablePlugins(
  PlayScala,
  JavaAppPackaging, 
  DockerPlugin, 
  GitVersioning,
  BuildInfoPlugin
  ).settings(
    buildInfoKeys := Seq[BuildInfoKey](name, version, scalaVersion, sbtVersion),
    buildInfoPackage := "jarvis.info"
  )

  libraryDependencies ++= Seq(
  "com.softwaremill.macwire" %% "macros" % "2.3.2" % "provided",
  "org.scalamock" %% "scalamock" % "4.1.0" % Test,
  "org.scalatest" %% "scalatest" % "3.0.4" % Test
)
// Scala Version 
scalaVersion := "2.12.8"

//Build Info
buildInfoOptions += BuildInfoOption.ToJson
  
//Git Info
showCurrentGitBranch
git.useGitDescribe := true

crossScalaVersions := Seq("2.11.12", "2.12.8")

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