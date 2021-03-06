name := "Lift demo"

version := "0.0.3"

organization := "net.liftweb"

scalaVersion := "2.10.0"

resolvers ++= Seq("snapshots"     at "http://oss.sonatype.org/content/repositories/snapshots",
                "releases"        at "http://oss.sonatype.org/content/repositories/releases"
                )

seq(com.github.siasia.WebPlugin.webSettings :_*)

unmanagedResourceDirectories in Test <+= (baseDirectory) { _ / "src/main/webapp" }

scalacOptions ++= Seq("-deprecation", "-unchecked")

EclipseKeys.withSource := true

libraryDependencies ++= {
  val liftVersion = "2.6-M2"
  Seq(
    "net.liftweb" %% "lift-webkit" % liftVersion % "compile",
    "net.liftmodules" %% "lift-jquery-module_2.6" % "2.5",
    "org.eclipse.jetty" % "jetty-webapp" % "8.1.7.v20120910" % "container,test",
    "org.eclipse.jetty.orbit" % "javax.servlet" % "3.0.0.v201112011016" % "container,test" artifacts Artifact("javax.servlet", "jar", "jar"),
    "ch.qos.logback" % "logback-classic" % "1.0.6",
    "net.liftweb" %% "lift-mongodb" % "2.5",
    "net.liftweb" %% "lift-mongodb-record" % "2.5",
    "com.foursquare" %% "rogue-field" % "2.2.0",
    "com.foursquare" %% "rogue-core" % "2.2.0",
    "com.foursquare" %% "rogue-lift" % "2.2.0",
    "com.foursquare" %% "rogue-index" % "2.2.0",
    "net.liftweb" %% "lift-json" % "2.2",
    "org.specs2" %% "specs2" % "1.14" % "test"
  )
}

