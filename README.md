# API Gateway triggered Lambda template

[![CI](https://github.com/horothesun/api-gateway-lambda-template.g8/actions/workflows/ci.yml/badge.svg)](https://github.com/horothesun/api-gateway-lambda-template.g8/actions/workflows/ci.yml)
[![Renovate enabled](https://img.shields.io/badge/renovate-enabled-brightgreen.svg?style=flat-square)](https://renovatebot.com)
[![Scala](https://img.shields.io/badge/Scala-2.13-%23DC322F?style=flat&labelColor=%23383838&logo=Scala&logoColor=%23DC322F&logoWidth=12&cacheSeconds=3600)](https://www.scala-lang.org/)
[![CE3](https://img.shields.io/badge/Cats%20Effect-3-%23DC322F?style=flat&labelColor=%23383838&logo=Scala&logoColor=%23DC322F&logoWidth=12&cacheSeconds=3600)](https://typelevel.org/cats-effect/)

Giter8 template to generate an API Gateway triggered Lambda.

## Example

[horothesun/demo-api-gateway-lambda](https://github.com/horothesun/demo-api-gateway-lambda)

## Terraform module

[horothesun/api-gateway-lambda-infra](https://github.com/horothesun/api-gateway-lambda-infra)

## Requirements

- sbt ([install](https://www.scala-sbt.org/download.html))

## Generate new project

```bash
sbt new horothesun/api-gateway-lambda-template.g8
cd <repo_name>
```
