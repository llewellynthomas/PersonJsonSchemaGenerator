package com.llewellynthomas.schemaGenerated.personV1

import cats.data.Validated
import com.github.andyglow.jsonschema.AsCirce._
import com.llewellynthomas.schemaGenerated.personV1.event.PersonEventV1
import io.circe.schema.Schema
import io.circe.syntax._
import json.schema.Version
import org.scalatest.flatspec._
import org.scalatest.matchers._
import org.scalatestplus.scalacheck.ScalaCheckDrivenPropertyChecks.forAll
import com.llewellynthomas.schemaGenerated.personV1.generators.PersonEventGen.personEventV1

class SchemaValidationSpec extends AnyFlatSpec with should.Matchers {
  "PersonEventV1 Encoder" should "produce JSON that complies with JSON Schema" in {
    forAll { ee: PersonEventV1 =>
      val json = ee.asJson
      val schema = PersonEventV1.schema.asCirce(Version.Draft04())

      Schema.load(schema).validate(json) match {
        case Validated.Valid(_) => succeed
        case Validated.Invalid(errors) =>
          val errorMsg: String =
            s"""
               |schema:
               | - ${schema.noSpaces}
               |
               |json:
               | - ${ee.asJson}
               |
               |schema validation errors:
               | ${errors.toList.mkString("- ", "\n - ", "")}
               |""".stripMargin

          fail(errorMsg)
      }
    }
  }

  "PersonEventV1 Decoder" should "read JSON that complies with JSON Schema" in {
    import scala.jdk.CollectionConverters._
    val sample = java.nio.file.Files
      .readAllLines(
        java.nio.file.Paths.get(this.getClass().getClassLoader().getResource("sample.json").toURI())
      )
      .asScala
      .mkString
    val result = io.circe.jawn.decode[PersonEventV1](sample)
    result.isRight shouldBe true
  }
}
