repositories {
  mavenCentral()
  maven("https://jitpack.io")
}
plugins {
  kotlin("jvm") version "1.6.10"
  id("com.github.johnrengelman.shadow") version "7.1.0"
  id("com.palantir.graal") version "0.10.0"
}
dependencies {
  implementation("com.github.vidstige:jadb:v1.2.1")
  implementation("com.github.ajalt.clikt:clikt:3.3.0")
  testImplementation("org.junit.jupiter:junit-jupiter:5.8.2")
  testImplementation("com.willowtreeapps.assertk:assertk-jvm:0.25")
  testImplementation("io.mockk:mockk:1.12.1")
}
tasks.compileKotlin {
  kotlinOptions.jvmTarget = "17"
  kotlinOptions.freeCompilerArgs += "-Xopt-in=kotlin.time.ExperimentalTime"
}
tasks.compileTestKotlin {
  kotlinOptions.jvmTarget = "17"
  kotlinOptions.freeCompilerArgs += "-Xopt-in=kotlin.time.ExperimentalTime"
}
tasks.test {
  useJUnitPlatform()
}
graal {
  graalVersion("21.3.0")
  javaVersion("17")
  mainClass("AppKt")
  outputName(projectDir.name)
  option("--no-fallback")
  windowsVsVersion("2022")
}
tasks.build {
  dependsOn(tasks.nativeImage)
}
