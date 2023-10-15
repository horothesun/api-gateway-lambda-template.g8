package com.$github_org;format="camel,lower"$.$repo_name;format="camel"$.lambda

import com.amazonaws.services.lambda.runtime.events._
import com.$github_org;format="camel,lower"$.$repo_name;format="camel"$.Models.Input
import Models._
import Models.BodyEncoding._

object HandlerInput {

  def getDecodedBody(event: APIGatewayV2HTTPEvent): Option[Input] =
    getBody(event)
      .flatMap(getBodyEncoding(event).decode)
      .map(Input)

  def getBody(event: APIGatewayV2HTTPEvent): Option[String] =
    Option(event.getBody)

  def getBodyEncoding(event: APIGatewayV2HTTPEvent): BodyEncoding =
    if (event.getIsBase64Encoded) Base64
    else NoEncoding

}
