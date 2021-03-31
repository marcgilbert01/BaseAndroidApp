plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("kotlin-android-extensions")
    kotlin("plugin.serialization") version "1.4.31"
    id("com.squareup.sqldelight")
}

kotlin {
    android()
    iosX64 {
        binaries {
            framework()
        }
    }
    sourceSets {
        val ktorVersion = "1.5.2"
        val sql_delight_version= rootProject.property("sql_delight_version")
        val commonMain by getting {
            dependencies {
                implementation("io.ktor:ktor-client-core:$ktorVersion")
                implementation("io.ktor:ktor-client-serialization:$ktorVersion")
                implementation(project(":domain"))
                implementation("com.squareup.sqldelight:runtime:$sql_delight_version")
            }
        }
        val commonTest by getting
        val androidMain by getting {
            dependencies {
                implementation("io.ktor:ktor-client-android:$ktorVersion")
                implementation("com.squareup.sqldelight:android-driver:$sql_delight_version")
            }
        }
        val iosX64Main by getting {
            dependencies {
                implementation("com.squareup.sqldelight:native-driver:$sql_delight_version")
            }
        }
    }
}

android {
    compileSdkVersion(rootProject.property("androidCompileSdkVersion") as Int)
}

sqldelight {
    database ("BaseAppDb") {
        packageName = "com.example.sql_delight.db"
    }
}