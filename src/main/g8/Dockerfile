ARG JAVA_VERSION=21


# BUILDER

FROM eclipse-temurin:\${JAVA_VERSION}-jdk-jammy as builder

ARG SBT_VERSION=1.10.2

# install dependencies
RUN apt-get update && apt-get install -y curl bash tar ca-certificates make git procps \
       && rm -rf /var/lib/apt/lists/*

# install sbt
RUN curl -fsL "https://github.com/sbt/sbt/releases/download/v\${SBT_VERSION}/sbt-\${SBT_VERSION}.tgz" | tar xfz - -C /opt \
  && ln -s /opt/sbt/bin/sbt /usr/bin/sbt \
  && chmod +x /usr/bin/sbt

# run from non-root folder
RUN mkdir -p /work
WORKDIR /work

# compile
COPY . /work
RUN sbt clean assembly


# RUNNER

FROM public.ecr.aws/lambda/java:\${JAVA_VERSION}

COPY --from=builder /work/target/scala-2.13/$repo_name$.jar \${LAMBDA_TASK_ROOT}/lib/

CMD ["com.$github_org;format="camel,lower"$.$repo_name;format="camel"$.lambda.Handler::handleRequest"]
