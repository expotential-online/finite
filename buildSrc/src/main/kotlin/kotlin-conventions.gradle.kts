plugins {
    kotlin("jvm")
    id("org.jetbrains.dokka")
    jacoco
}

val kotlinLoggingVersion = "3.0.5"
val logbackVersion = "1.5.7"

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.github.microutils:kotlin-logging-jvm:$kotlinLoggingVersion")
    testImplementation(kotlin("test"))
    testImplementation("ch.qos.logback:logback-classic:$logbackVersion")
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(21)
}

tasks.jacocoTestReport {
    reports.xml.required.set(true)
}
