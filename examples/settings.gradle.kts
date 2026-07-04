rootProject.name = "javacard-gradle-extensions"

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
