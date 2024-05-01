

plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    id("kotlin-kapt")
    id("com.google.gms.google-services")
}
//plugins {
//    alias(libs.plugins.androidApplication) apply false
//    alias(libs.plugins.jetbrainsKotlinAndroid) apply false
//    id("com.android.library") version "8.1.0" apply false
//    id("com.google.gms.google-services") version "4.4.1" apply false
//    id("com.google.dagger.hilt.android") version "2.47" apply false
//
//}


android {
    namespace = "com.example.sallybeauty"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.sallybeauty"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

//dependencies {
//
//    implementation(libs.androidx.core.ktx)
//    implementation(libs.androidx.lifecycle.runtime.ktx)
//    implementation(libs.androidx.activity.compose)
//    implementation(platform(libs.androidx.compose.bom))
//    implementation(libs.androidx.ui)
//    implementation(libs.androidx.ui.graphics)
//    implementation(libs.androidx.ui.tooling.preview)
//    implementation(libs.androidx.material3)
//    implementation(libs.firebase.auth)
//    implementation(libs.firebase.firestore.ktx)
//    implementation(libs.androidx.navigation.compose)
//    implementation(libs.androidx.navigation.common.ktx)
//    testImplementation(libs.junit)
//    androidTestImplementation(libs.androidx.junit)
//    androidTestImplementation(libs.androidx.espresso.core)
//    androidTestImplementation(platform(libs.androidx.compose.bom))
//    androidTestImplementation(libs.androidx.ui.test.junit4)
//    debugImplementation(libs.androidx.ui.tooling)
//    debugImplementation(libs.androidx.ui.test.manifest)
//}


dependencies {
    implementation(libs.androidx.runtime)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.firebase.auth)
//    implementation(platform(libs.firebase.bom))

    implementation (libs.androidx.navigation.compose)
    implementation (platform(libs.firebase.bom))


    // viewModel
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.compose)
    // LiveData
//    implementation(libs.androidx.lifecycle.livedata.ktx)
//    implementation(libs.androidx.lifecycle.livedata.ktx)
    implementation("androidx.lifecycle:lifecycle-livedata-ktx")
    implementation ("androidx.compose.runtime:runtime-livedata")






    // Lifecycles only (without viewModel or LiveData)
    implementation(libs.androidx.lifecycle.runtime.ktx)
//    implementation(libs.support.annotations)
    // Firebase
    implementation(libs.firebase.messaging.ktx)
    implementation(platform(libs.firebase.bom))
    implementation("com.google.firebase:firebase-analytics-ktx")
    implementation(libs.firebase.crashlytics.ktx)
    implementation(libs.firebase.firestore.ktx)
    implementation(libs.firebase.auth.ktx)

    // WorkManager
    implementation(libs.androidx.work.runtime.ktx)
    implementation(libs.androidx.work.gcm)

    // Retrofit
    implementation(libs.retrofit)

    // Retrofit with Moshi Converter
    implementation(libs.converter.moshi)

    // OkHttp
    implementation(libs.okhttp)

    // Moshi
    implementation(libs.moshi.kotlin)

    // Hilt
    implementation(libs.hilt.android)
//    kapt (libs.hilt.compiler)
//    annotationProcessor(libs.hilt.compiler)

    implementation(libs.androidx.hilt.navigation.compose)


    // Room
    implementation("androidx.room:room-runtime")
    implementation("androidx.room:room-ktx")
    kapt("androidx.room:room-compiler")
    // JWT
    implementation(libs.kjwt.core)
    implementation(libs.kjwt.jwks)
    implementation(libs.arrow.core)

    // Lottie
    implementation(libs.lottie.compose)

    //Coil
    implementation(libs.coil.compose)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)


}

kapt{
        correctErrorTypes;true

    }
