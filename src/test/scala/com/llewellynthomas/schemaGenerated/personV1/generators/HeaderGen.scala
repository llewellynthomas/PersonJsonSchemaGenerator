package com.llewellynthomas.schemaGenerated.personV1.generators

import com.llewellynthomas.schemaGenerated.personV1.event.Header
import org.scalacheck.Gen

import java.time.Instant

object HeaderGen {

  private val instant: Instant = Instant.parse("2023-10-21T00:00:00.00Z")

  val header: Gen[Header] = for {
    id <- Gen.uuid.map(_.toString)
    when <- Gen.const(instant)
  } yield Header(id, when)

}