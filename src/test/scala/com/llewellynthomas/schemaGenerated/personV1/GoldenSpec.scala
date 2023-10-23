package com.llewellynthomas.schemaGenerated.personV1

import com.llewellynthomas.schemaGenerated.personV1.event.PersonEventV1
import com.llewellynthomas.schemaGenerated.personV1.generators.PersonEventGen.personEventV1
import io.circe.testing.ArbitraryInstances
import io.circe.testing.golden.GoldenCodecTests
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.prop.Configuration
import org.typelevel.discipline.scalatest.FlatSpecDiscipline

class GoldenSpec extends AnyFlatSpec with FlatSpecDiscipline with Configuration with ArbitraryInstances {

  override protected def maxJsonObjectSize: Int = 1
  override protected def maxJsonDepth: Int = 1
  override protected def maxJsonArraySize: Int = 1

  checkAll("PersonEventsV1", GoldenCodecTests[PersonEventV1].goldenCodec)
}