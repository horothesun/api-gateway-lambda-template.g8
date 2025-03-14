import sbtassembly.MergeStrategy

scalacOptions += "-Xfatal-warnings"

ThisBuild / organization     := "com.$github_org;format="camel,lower"$"
ThisBuild / organizationName := "$github_org$"
ThisBuild / scalaVersion     := "2.13.16"

val projectName = "$repo_name$"

lazy val root = project
  .in(file("."))
  .settings(name := projectName)
  .settings(Dependencies.core)
  .settings(
    assembly / test := Def
      .sequential(Test / test)
      .value,
    assembly / assemblyMergeStrategy := customMergeStrategy,
    assembly / assemblyJarName       := s"\$projectName.jar"
  )

val customMergeStrategy: String => MergeStrategy = {
  case r if r.endsWith(".conf")            => MergeStrategy.concat
  case PathList("META-INF", "MANIFEST.MF") => MergeStrategy.discard
  // https://stackoverflow.com/questions/46287789/running-an-uber-jar-from-sbt-assembly-results-in-error-could-not-find-or-load-m
  case _ => MergeStrategy.first
}
