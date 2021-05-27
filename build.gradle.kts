buildscript {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
        jcenter()

    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.10")
        classpath("com.android.tools.build:gradle:7.1.0-alpha01")
        classpath("org.jetbrains.kotlin:kotlin-serialization:1.5.10")
        classpath ("com.squareup.sqldelight:gradle-plugin:1.5.0")

    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
        jcenter()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}