pluginManagement {
    repositories {
        google()
        jcenter()
        gradlePluginPortal()
        mavenCentral()
        maven("https://kotlin.bintray.com/kotlinx")
    }
}

rootProject.name = "MyTestKMM"
include(":androidApp")
include(":shared")