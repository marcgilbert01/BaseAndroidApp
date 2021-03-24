plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("kotlin-android-extensions")
}

kotlin {
    android()

    sourceSets {
        val commonMain by getting {
            dependencies {
                api(project(":domain"))
                api(project(":data"))
                api(project(":presentation"))
            }
        }
        val commonTest by getting
        val androidMain by getting
        val androidTest by getting
    }
}

android {
    compileSdkVersion(rootProject.property("androidCompileSdkVersion") as Int)
}
