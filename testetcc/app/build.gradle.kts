plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.testetcc"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.testetcc"
        minSdk = 24
        targetSdk = 34
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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}
 dependencies {
        implementation(libs.appcompat)
        implementation(libs.material)
        implementation(libs.activity)
        implementation(libs.constraintlayout)
        testImplementation(libs.junit)
        androidTestImplementation(libs.ext.junit)
        androidTestImplementation(libs.espresso.core)

        // Dependências do Room
        val roomVersion = "2.6.1"

        implementation("androidx.room:room-runtime:$roomVersion")
        annotationProcessor("androidx.room:room-compiler:$roomVersion")

        // Se estiver usando Kotlin KSP (ignorar se for só Java)
        // ksp("androidx.room:room-compiler:$roomVersion")

        // Para suportar RxJava (opcional)
        implementation("androidx.room:room-rxjava3:$roomVersion")
    }
