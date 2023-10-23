package com.llewellynthomas.schemaGenerated.personV1.event

import io.circe.Codec
import io.circe.generic.semiauto.deriveCodec

case class Body(firstName: String, lastName: String)

object Body {
  implicit val codec: Codec[Body] = {
    val codec = deriveCodec[Body]
    Codec.from(codec, codec.mapJson(_.dropNullValues))
  }
}
