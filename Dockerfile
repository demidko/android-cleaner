FROM gradle:jdk17 as toolchain
RUN apt -yq update && apt -yq upgrade && apt -yc install build-essential

FROM toolchain as builder
WORKDIR /project
COPY src ./src
COPY build.gradle.kts ./build.gradle.kts
RUN gradle clean build

FROM debian as backend
WORKDIR /root
COPY --from=builder /project/build/graal/app ./app
ENTRYPOINT ["/root/app"]