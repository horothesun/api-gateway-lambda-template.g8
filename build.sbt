ThisBuild / scalaVersion := "3.8.4"

lazy val root = (project in file("."))
  .enablePlugins(ScriptedPlugin)
  .settings(
    name := "API Gateway Lambda template",

    scriptedLaunchOpts ++= List(
      "-Xms1024m",
      "-Xmx1024m",
      "-XX:ReservedCodeCacheSize=128m",
      "-Xss2m",
      "-Dfile.encoding=UTF-8"
    )
  )

// The command alias seamlessly chains the tasks without macro cycles
addCommandAlias("test", ";g8Test;Test/test")
