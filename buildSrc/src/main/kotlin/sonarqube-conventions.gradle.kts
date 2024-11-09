plugins {
    id("org.sonarqube")
}

repositories {
    mavenCentral()
}

sonar {
    properties {
        property("sonar.projectKey", "expotential-online_finite")
        property("sonar.organization", "expotential-online")
        property("sonar.host.url", "https://sonarcloud.io")
    }
}

subprojects {
    sonar {
        properties {
            property("sonar.sources", "src/main")
        }
    }
}
