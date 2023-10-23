package com.llewellynthomas.schemaGenerated.personV1.event

import cats.Eq
import com.github.andyglow.jsonschema.AsCirce._
import io.circe._
import io.circe.generic.semiauto.deriveCodec
import json.schema.Version._
import json.{Schema, Json => JsonSchema}

final case class PersonEventV1(header: Header, body: Body)


object PersonEventV1 {
  val schema: Schema[PersonEventV1] = JsonSchema.schema[PersonEventV1]

  implicit val codec: Codec[PersonEventV1] = deriveCodec

  implicit val hasSchema = (_: PersonEventV1) =>
    new io.confluent.kafka.schemaregistry.json.JsonSchema(schema.asCirce(Draft04()).spaces2)

  implicit val eq: Eq[PersonEventV1] = Eq.fromUniversalEquals[PersonEventV1]
}