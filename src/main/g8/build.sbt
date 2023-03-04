name := "$name$"

version := "$version$"

scalaVersion := "$scalaVersion$"

resolvers ++= Seq(
  "apache-snapshots" at "https://repository.apache.org/snapshots/"
)

libraryDependencies ++= Seq(
  "org.apache.spark"    %% "spark-core"         % "$sparkVersion$"  %  "provided",
  "org.apache.spark"    %% "spark-sql"          % "$sparkVersion$"  %  "provided",
  "org.apache.spark"    %% "spark-hive"         % "$sparkVersion$"  %  "provided",
  "org.apache.spark"    %% "spark-graphx"       % "$sparkVersion$",
  "com.chuusai"         %% "shapeless"          % "2.3.10",
  "com.github.scopt"    %% "scopt"              % "4.1.0",
  "org.scalatest"       %% "scalatest"          % "3.2.14" % Test,
  "com.github.mrpowers" %% "spark-fast-tests"   % "1.3.0"  % Test
)

assemblyJarName in assembly := "$name;format="lower"$-fatjar-$version$.jar"

assembly / assemblyMergeStrategy := {
  case PathList("META-INF", xs @ _*) => MergeStrategy.discard
  case x => MergeStrategy.first
}


// test suite settings
fork in Test := true
javaOptions ++= Seq("-Xms512M", "-Xmx2048M", "-XX:+CMSClassUnloadingEnabled")
// Show runtime of tests
testOptions in Test += Tests.Argument(TestFrameworks.ScalaTest, "-oD")
