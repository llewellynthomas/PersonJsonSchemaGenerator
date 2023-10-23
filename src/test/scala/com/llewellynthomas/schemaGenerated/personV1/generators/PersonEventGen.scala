package com.llewellynthomas.schemaGenerated.personV1.generators

import com.llewellynthomas.schemaGenerated.personV1.event.PersonEventV1
import org.scalacheck.Arbitrary

object PersonEventGen {

  implicit val personEventV1: Arbitrary[PersonEventV1] = Arbitrary(for {
    header <- HeaderGen.header
    body <- BodyGen.body
  } yield PersonEventV1(header, body))
}
