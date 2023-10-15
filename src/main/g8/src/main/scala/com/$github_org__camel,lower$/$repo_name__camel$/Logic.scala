package com.$github_org;format="camel,lower"$.$repo_name;format="camel"$

import cats.effect.implicits._
import cats.effect.{IO, Resource}
import Models._
import Models.Output._
import Logic._

case class Logic(log: Logger) {

  def appLogic(input: Input): IO[Output] =
    getClients.use(clock => getOutput(clock)(input))

}

object Logic {

  def getOutput(clock: Clock)(input: Input): IO[Output] =
    clock.currentDateTime.map(DateTimeBody.apply)

  def getClients: Resource[IO, Clock] =
    IO(Clock.create).toResource

}
