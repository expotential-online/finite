plugins {
    kotlin("jvm") version "2.0.0"
    scala
}

repositories {
    mavenCentral()
}

val kotlinLoggingVersion = "3.0.5"
val scalaLibraryVersion = "2.13.15-M1"
val logbackVersion = "1.5.7"

dependencies {
    implementation(project(":core"))
    implementation("io.github.microutils:kotlin-logging-jvm:$kotlinLoggingVersion")
    implementation("org.scala-lang:scala-library:$scalaLibraryVersion")
    testImplementation(kotlin("test"))
    testImplementation("ch.qos.logback:logback-classic:$logbackVersion")
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(21)
}
