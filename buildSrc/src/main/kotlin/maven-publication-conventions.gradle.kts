import gradle.kotlin.dsl.accessors._cc6c7a362e4f9d431d10f00d05f11adf.sourceSets
import org.jreleaser.model.Active.ALWAYS

plugins {
    id("org.jreleaser")
//    id("org.kordamp.gradle.pomchecker")
    `maven-publish`
//    signing
//    id("io.github.gradle-nexus.publish-plugin")
}

// Needed to avoid property shadowing
val projectName = project.name
//val projectDescription = project.extra["projectDescription1"]
println(project.findProperty("component.description"))
fun projectDescription(): String = project.findProperty("component.description") as String
//println(project.extra.properties)
//println("Desc [$projectDescription]")

// TODO: Need to fix this!
val projectVersion = "1.0-SNAPSHOT"

// TODO: Find a way to move this into the language-level conventions
val sourcesJar = task<Jar>("sourcesJar") {
    archiveClassifier.set("sources")
    from(sourceSets["main"].allSource)
}

// TODO: Find a way to move this into the language-level conventions
val docsJar = task<Jar>("docsJar") {
    archiveClassifier.set("javadoc")
    group = JavaBasePlugin.DOCUMENTATION_GROUP
}

publishing {
    publications {
        create<MavenPublication>(projectName) {

            artifactId = "finite-$projectName"

            from(components["java"])

            artifacts {
                artifact(sourcesJar)
                artifact(docsJar)
            }

            // See https://docs.gradle.org/current/dsl/org.gradle.api.publish.maven.MavenPom.html
            pom {
                description = projectDescription()
                inceptionYear = "2024"
                name = "Finite $projectName library"
                packaging = "jar"
                url = "https://github.com/expotential-online/finite"

                developers {
                    developer {
                        id = "pdcooper80@gmail.com"
                        name = "Paul Cooper"
                        email = "pdcooper80@gmail.com"
                        roles.addAll(
                            "architect",
                            "developer"
                        )
                        timezone = "Europe/London"
                    }
                }

                issueManagement {
                    system = "GitHub"
                    url = "https://github.com/expotential-online/finite/issues"
                }

                licenses {
                    license {
                        name = "MIT License"
                        url = "https://github.com/expotential-online/finite/blob/main/LICENSE"
                    }
                }


                scm {
                    connection = "https://github.com/expotential-online/finite.git"
                    developerConnection = "https://github.com/expotential-online/finite.git"
                    url = "https://github.com/expotential-online/finite"
                }
            }
        }
    }

    repositories {
        maven {
            url = uri(layout.buildDirectory.dir("staging-deploy"))
        }
    }
}

// See https://github.com/jreleaser/jreleaser/discussions/367
jreleaser {

    // See https://github.com/jreleaser/jreleaser/discussions/1483
    // See https://jreleaser.org/guide/latest/faq.html
    gitRootSearch = true

//    // See https://jreleaser.org/guide/latest/reference/environment.html
//    environment {
//    }

//    // See https://jreleaser.org/guide/latest/reference/project.html
//    project {
//
//        name = "Finite $projectName"
//        description = projectDescription()
//
//        java {
//            artifactId = projectName
//        }
//
//        license = MIT.name
//        inceptionYear = "2024"
//
//        authors.addAll(
//            "Paul Cooper"
//        )
//
//        links {
//            homepage = "https://github.com/paul-cooper/Finite"
//            license = "https://github.com/expotential-online/finite/blob/main/LICENSE"
//
//        }
//    }

//    // See https://jreleaser.org/guide/latest/reference/assemble/java-archive.html
//    assemble {
//        javaArchive {
//            create("Finite $projectName") {
//                active = ALWAYS
//                formats.add(ZIP)
//
//                mainJar {
//                    path = File("build/libs/$projectName-$projectVersion.jar")
//                }
//            }
//        }
//    }

    // See https://jreleaser.org/guide/latest/reference/signing.html
    // See https://gnupg.org/download/
    // See https://apps.microsoft.com/detail/9nh716mqk2b5?hl=en-gb&gl=GB
    // JRELEASER_GPG_PASSPHRASE: "blah" (double quotes are needed)
    signing {
        active = ALWAYS
        armored = true
    }

    deploy {
        maven {
            pomchecker {
                version = "1.12.0"
                failOnWarning = true
                failOnError = true
            }

            // See https://jreleaser.org/guide/latest/reference/deploy/maven/maven-central.html
            mavenCentral {
                create("sonatype") {
                    active = ALWAYS
                    url = "https://central.sonatype.com/api/v1/publisher"
                    snapshotSupported = true
                    stagingRepository("build/staging-deploy")
                    verifyPom = true
                    applyMavenCentralRules = true
                }
            }
        }
    }
}
