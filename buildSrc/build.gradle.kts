plugins {
    `kotlin-dsl`
}

repositories {
    gradlePluginPortal()
}

dependencies {
    implementation("org.jetbrains.dokka:dokka-gradle-plugin:1.9.20")
    implementation("org.jetbrains.kotlin.jvm:org.jetbrains.kotlin.jvm.gradle.plugin:2.0.0")
    implementation("org.jreleaser:jreleaser-gradle-plugin:1.14.0")
    implementation("org.sonarsource.scanner.gradle:sonarqube-gradle-plugin:5.1.0.4882")
//    runtimeOnly("io.github.gradle-nexus:publish-plugin:1.3.0")
    implementation("com.vanniktech:gradle-maven-publish-plugin:0.29.0")
    implementation("org.kordamp.gradle:pomchecker-gradle-plugin:1.12.0")
}
