package com.llewellynthomas.schemaGenerated.personV1.generators

import com.llewellynthomas.schemaGenerated.personV1.event.Body
import org.scalacheck.Gen

object BodyGen {
  val body: Gen[Body] = for {
    firstName <- Gen.alphaStr
    lastName <- Gen.alphaStr
  } yield Body("john", "smith")
}
