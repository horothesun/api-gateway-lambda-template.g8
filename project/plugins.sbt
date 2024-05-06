addSbtPlugin("org.foundweekends.giter8" %% "sbt-giter8"      % "0.16.2")
libraryDependencies += "org.scala-sbt"  %% "scripted-plugin" % sbtVersion.value

addSbtPlugin("org.scalameta" % "sbt-scalafmt" % "2.5.2")
addSbtPlugin("com.eed3si9n"  % "sbt-assembly" % "2.2.0")
