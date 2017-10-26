scalaVersion := "2.12.4"

libraryDependencies += "org.scastie" %% "runtime-scala" % "0.26.0+9e74ecbd91cb45eaa213a8f98a3eef1b629142fb"

scalacOptions ++= Seq(
  "-deprecation",
  "-encoding", "UTF-8",
  "-feature",
  "-unchecked"
)

ensimeIgnoreMissingDirectories := true