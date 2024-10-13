plugins {
    id("org.sonarqube")
}

repositories {
    mavenCentral()
}

sonarqube {
    properties {
        property("sonar.projectKey", "expotential-online_finite")
        property("sonar.organization", "expotential-online")
        property("sonar.host.url", "https://sonarcloud.io")
    }
}
