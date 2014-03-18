name := "marvel-cards"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache
)

libraryDependencies += "com.github.codingricky" % "marvel-rest-client" % "1.0-SNAPSHOT"

play.Project.playJavaSettings
