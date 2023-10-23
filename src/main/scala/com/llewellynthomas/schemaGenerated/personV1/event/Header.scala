package com.llewellynthomas.schemaGenerated.personV1.event

import io.circe.Codec
import io.circe.generic.semiauto.deriveCodec

import java.time.Instant

case class Header(id: String, when: Instant)

object Header {
  implicit val codec: Codec[Header] = {
    val codec = deriveCodec[Header]
    Codec.from(codec, codec.mapJson(_.dropNullValues))
  }
}
