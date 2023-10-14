package com.$github_org_package_name_after_com$.$scala_package_name_after_com_org$.lambda

import com.amazonaws.services.lambda.runtime.events._
import com.$github_org_package_name_after_com$.$scala_package_name_after_com_org$.Models.Input
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
