package com.$github_org;format="camel,lower"$.$repo_name;format="camel"$.lambda

import HandlerOutput._
import Models._
import Models.BodyEncoding._
import com.$github_org;format="camel,lower"$.$repo_name;format="camel"$.Models.Output._
import java.time.{LocalDateTime, Month}
import munit.FunSuite

class HandlerOutputSuite extends FunSuite {

  test("createResponse with DateTimeBody and NoEncoding") {
    val body = DateTimeBody(LocalDateTime.of(2022, Month.APRIL, 15, 13, 33, 0))
    val r    = createResponse(body, NoEncoding)
    assertEquals(r.getStatusCode, 200)
    assertEquals(r.getBody, "{\"server_date_time\":\"2022-04-15T13:33:00\"}")
    assertEquals(r.getIsBase64Encoded, false)
  }

  test("createResponse with plain-text body") {
    val body = "{\"hello\":\"world\"}"
    val r    = createResponse(StatusCode.Ok, body, NoEncoding)
    assertEquals(r.getStatusCode, 200)
    assertEquals(r.getBody, body)
    assertEquals(r.getIsBase64Encoded, false)
  }

  test("createResponse with base64 encoded body") {
    val r = createResponse(StatusCode.Ok, "{\"hello\":\"world\"}", Base64)
    assertEquals(r.getStatusCode, 200)
    assertEquals(r.getBody, "eyJoZWxsbyI6IndvcmxkIn0=")
    assertEquals(r.getIsBase64Encoded, true)
  }

  test("createBadRequestResponse with plain-text body") {
    val r = createBadRequestResponse(BadRequestError("test-body"), NoEncoding)
    assertEquals(r.getStatusCode, 400)
    assertEquals(r.getBody, """{"error":"test-body"}""")
    assertEquals(r.getIsBase64Encoded, false)
  }

}
