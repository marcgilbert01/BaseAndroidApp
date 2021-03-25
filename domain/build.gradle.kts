plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("kotlin-android-extensions")
}

kotlin {
    val coroutinesVersion = "1.4.2-native-mt"
    android()
    iosX64 {
        binaries {
            framework()
        }
    }

    sourceSets {
        val commonMain by getting  {
            dependencies {
                api("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion")
            }
        }
        val commonTest by getting
        val androidMain by getting {
            dependencies {
                api("org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutinesVersion")
            }
        }
        val iosX64Main by getting {
            dependencies {
                api("org.jetbrains.kotlinx:kotlinx-coroutines-core-iosx64:$coroutinesVersion")
                implementation("org.jetbrains.kotlinx:kotlinx-datetime-iosx64:0.1.1")
            }
        }
    }
}

android {
    compileSdkVersion(rootProject.property("androidCompileSdkVersion") as Int)
}
