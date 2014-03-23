name := "marvel-cards"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache
)

libraryDependencies += "com.github.codingricky" % "marvel-rest-client" % "1.0-SNAPSHOT"

libraryDependencies += "org.apache.commons" % "commons-lang3" % "3.3"

play.Project.playJavaSettings
