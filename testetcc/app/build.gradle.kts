plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.testetcc"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.testetcc"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    viewBinding {
        enable = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

dependencies {
    // Room
    implementation("androidx.room:room-runtime:${libs.versions.room.get()}")
    annotationProcessor("androidx.room:room-compiler:${libs.versions.room.get()}")

    // Use as versões do libs.versions.toml
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.constraintlayout)
    implementation(libs.lifecycle.viewmodel)
    implementation(libs.activity)

    // Testes
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
    configurations.all {
        resolutionStrategy {
            force ("androidx.annotation:annotation:1.6.0")
            force ("androidx.arch.core:core-common:2.2.0")
            force ("androidx.lifecycle:lifecycle-livedata:2.7.0")
            force ("androidx.room:room-runtime:2.6.1")
        }
    }}
