package com.llewellynthomas.schemaGenerated.personV1

import com.github.andyglow.jsonschema.AsCirce._
import com.llewellynthomas.schemaGenerated.personV1.event.PersonEventV1
import json.schema.Version
import zio.stream.{ZSink, ZStream}
import zio.{ExitCode, URIO, ZIO}

import java.nio.file.{Files, Path, Paths}


object Main extends zio.App {

  private val schemaPath: Path = Paths.get("src/main/resources/generated/schema.json")

  private val jsonSchema =
    ZIO.effect(PersonEventV1.schema.asCirce(Version.Draft04()).toString())

  private val genSchema = {
    for {
      schema <- jsonSchema
      _ <- ZStream.fromIterable(schema.getBytes).run(ZSink.fromFile(schemaPath))
    } yield ()
  }.orDie.exitCode

  private val diffSchema = {
    val diff = for {
      current <- ZIO.effect(Files.readString(schemaPath))
      schema <- jsonSchema
    } yield current != schema
    ZIO.whenM(diff)(ZIO.dieMessage("Json schema has changed but has not been regenerated")).exitCode
  }

  override def run(args: List[String]): URIO[zio.ZEnv, ExitCode] = args match {
    case "generate" :: Nil => genSchema
    case "diff" :: Nil     => diffSchema
    case _                 => genSchema //todo remove!
    case _                 => ZIO.dieMessage(s"Running schema main with unknown option $args")
  }
}