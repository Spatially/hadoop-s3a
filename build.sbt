name := "hadoop-s3a"

organization := "org.apache.hadoop"
version := "0.0.17-SNAPSHOT"
scalaVersion := Versions.scalaVersion

// additional libraries
libraryDependencies ++= Seq(
	//Hadoop
	"org.apache.hadoop" % "hadoop-common" % "2.4.0" % "compile" excludeAll(
		ExclusionRule(organization = "net.java.dev.jets3t", artifact = "jets3t"),
		ExclusionRule(organization = "com.sun.jersey", artifact = "jersey-server"),
		ExclusionRule(organization = "org.apache.zookeeper", artifact = "zookeeper"),
		ExclusionRule(organization = "com.google.guava", artifact = "guava")
	),
	// AWS
	"com.amazonaws" % "aws-java-sdk" % "1.9.37" % "compile" excludeAll
		ExclusionRule(organization = "commons-codec", artifact = "commons-codec"),
	// Guava
	"com.google.guava" % "guava" % "18.0" % "compile",
	// Tests
	"org.apache.hadoop" % "hadoop-common-test" % "0.22.0" % "test",
	"org.apache.hadoop" % "hadoop-auth" % "2.4.0" % "test",
	"junit" % "junit" % "4.11" % "test"
)

// publish settings
publishTo := {
  val nexus = "https://oss.sonatype.org/"
  if (isSnapshot.value)
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases"  at nexus + "service/local/staging/deploy/maven2")
}
