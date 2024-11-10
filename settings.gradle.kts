plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
//    `maven-publish`
//    signing
//    id("io.github.gradle-nexus:publish-plugin:1.3.0")
}

rootProject.name = "finite"

include(
    "core",
    "enforcement",
    "scala"
)
