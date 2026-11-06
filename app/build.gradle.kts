plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    signingConfigs {
        create("appforge") {
            storeFile = rootProject.file("appforge.jks")
            storePassword = System.getenv("KEYSTORE_PASS") ?: ""
            keyAlias = "appforge"
            keyPassword = System.getenv("KEYSTORE_PASS") ?: ""
        }
    }

    namespace = "com.example.aabcheck"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.aabcheck"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        release {
            signingConfig = signingConfigs.getByName("appforge")
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("com.google.android.material:material:1.12.0")
}
