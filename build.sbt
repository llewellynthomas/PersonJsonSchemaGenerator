ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.12"
ThisBuild / scalaVersion := versions.Scala

// Scoverage configuration
ThisBuild / coverageEnabled := true
ThisBuild / coverageFailOnMinimum := true
ThisBuild / coverageMinimumStmtTotal := 100

lazy val root = (project in file("."))
  .settings(
    name := "PersonJsonSchemaGenerator",
    resolvers ++= Seq(
      "confluent" at "https://packages.confluent.io/maven/",
      "jitpack".at("https://jitpack.io")
    ),
    libraryDependencies ++= Seq(
      "com.github.andyglow" %% "scala-jsonschema-core" % versions.AndyGlowJsonSchema,
      "com.github.andyglow" %% "scala-jsonschema-circe-json" % versions.AndyGlowJsonSchema,
      "com.github.andyglow" %% "scala-jsonschema-cats" % versions.AndyGlowJsonSchema,
      "io.circe" %% "circe-generic-extras" % versions.Circe,
      "io.circe" %% "circe-testing" % versions.Circe % Test,
      "io.circe" %% "circe-golden" % versions.CirceGolden % Test,
      "org.scalatest" %% "scalatest" % versions.ScalaTest % Test,
      "org.typelevel" %% "discipline-scalatest" % versions.DisciplineScalaTest % Test,
      "io.chrisdavenport" %% "cats-scalacheck" % versions.CatsScalaCheck % Test,
      "com.github.alexarchambault" %% "scalacheck-shapeless_1.15" % versions.ScalaCheckShapeless % Test,
      "org.scalatestplus" %% "scalacheck-1-15" % versions.ScalaTestPlusScalaCheck % Test,
      "io.circe" %% "circe-json-schema" % versions.CirceJsonSchema % Test,
      "org.everit.json" % "org.everit.json.schema" % "1.2.0",
      "dev.zio" %% "zio" % versions.Zio,
      "io.github.kitlangton" %% "zio-magic" % versions.ZioMagic,
      "io.confluent" % "kafka-json-schema-serializer" % "7.5.1"
    )
  )
