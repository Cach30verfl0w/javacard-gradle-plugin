rootProject.name = "javacard-gradle-plugin"
include(":javacard-gradle-plugin")
includeBuild("examples")

dependencyResolutionManagement {
    @Suppress("UnstableApiUsage")
    repositories {
        mavenCentral()
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}
