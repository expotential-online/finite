plugins {
    id("kotlin-conventions")
    scala
}

val scalaLibraryVersion = "2.13.15-M1"

dependencies {
    implementation(project(":core"))
    implementation("org.scala-lang:scala-library:$scalaLibraryVersion")
}
