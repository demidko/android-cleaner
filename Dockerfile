FROM gradle:jdk17 as toolchain
RUN apt -y update && apt -y upgrade && apt -y install llvm

FROM toolchain as builder
WORKDIR /project
COPY src ./src
COPY build.gradle.kts ./build.gradle.kts
RUN gradle clean build

FROM debian as backend
WORKDIR /root
COPY --from=builder /project/build/graal/app ./app
ENTRYPOINT ["/root/app"]