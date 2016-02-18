name := "mleap"

updateOptions := updateOptions.value.withCachedResolution(true)

lazy val `root` = project.in(file("."))
  .settings(Common.settings)
  .settings(publishArtifact in (Compile, packageBin) := false,
    publishArtifact in (Compile, packageDoc) := false,
    publishArtifact in (Compile, packageSrc) := false)
  .aggregate(`mleap-core`, `mleap-runtime`, `mleap-learning`, `mleap-spark`)

lazy val `mleap-core` = project.in(file("mleap-core"))
  .settings(Common.settings)
  .settings(libraryDependencies ++= Dependencies.mleapCoreDependencies)

lazy val `mleap-runtime` = project.in(file("mleap-runtime"))
  .settings(Common.settings)
  .settings(libraryDependencies ++= Dependencies.mleapRuntimeDependencies)
  .dependsOn(`mleap-core`)

lazy val `mleap-learning` = project.in(file("mleap-learning"))
  .settings(Common.settings)
  .settings(libraryDependencies ++= Dependencies.mleapLearningDependencies)
  .dependsOn(`mleap-runtime`)

lazy val `mleap-spark` = project.in(file("mleap-spark"))
  .settings(Common.settings)
  .settings(libraryDependencies ++= Dependencies.mleapSparkDependencies)
  .dependsOn(`mleap-runtime`, `mleap-learning`)
