@file:Suppress("UnstableApiUsage")

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

android {
    namespace = "com.githubusers"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.githubusers"
        minSdk = 29
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        vectorDrawables {
            useSupportLibrary = true
        }
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.0"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(libs.coreKtx)
    implementation(libs.lifecycleRuntimeKtx)
    implementation(libs.activityCompose)
    implementation(libs.composeUI)
    implementation(libs.composeUIToolingPreview)
    implementation(libs.composeMaterial)
    implementation(libs.koinAndroid)
    implementation(libs.koinAndroidxCompose)
    implementation(libs.navigationCompose)
    implementation(libs.navigationDynamicFeaturesFragment)
    implementation(libs.retrofit2)
    implementation(libs.moshi)
    implementation(libs.moshiConverter)
    implementation(libs.moshiKotlin)
    implementation(libs.coil)
    implementation(libs.room)
    implementation(libs.roomKtx)
    kapt(libs.roomCompiler)
}