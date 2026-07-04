rootProject.name = "javacard-gradle-examples"

pluginManagement {
    includeBuild("../")
}

dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            from(files("../gradle/libs.versions.toml"))
        }
    }
}
