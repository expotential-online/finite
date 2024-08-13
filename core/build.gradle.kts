plugins {
    kotlin("jvm") version "2.0.0"
    id("org.sonarqube") version "5.1.0.4882"
    jacoco
}

group = "online.expotential"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
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

sonar {
    properties {
        property("sonar.projectKey", "expotential-online_finite")
        property("sonar.organization", "expotential-online")
        property("sonar.host.url", "https://sonarcloud.io")
    }
}
