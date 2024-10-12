import java.util.Properties

plugins {
    alias(libs.plugins.android.application)
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "com.example.videogamesapp"
    compileSdk = 34
    android.buildFeatures.buildConfig = true

    defaultConfig {
        applicationId = "com.example.videogamesapp"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        val properties = Properties()
        properties.load(project.rootProject.file("local.properties").inputStream())
        buildConfigField("String", "apiKey", properties.getProperty("apiKey"))
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
}

dependencies {
    // Retrofit

    implementation ("com.squareup.retrofit2:retrofit:2.11.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.11.0")
    // RxJava adapter
    implementation ("com.github.akarnokd:rxjava3-retrofit-adapter:3.0.0")
    // Hilt

    implementation ("com.google.dagger:hilt-android:2.52")
    annotationProcessor ("com.google.dagger:hilt-compiler:2.52")

    // RxJava3

    implementation("io.reactivex.rxjava3:rxjava:3.1.5")
    implementation("io.reactivex.rxjava3:rxandroid:3.0.0")

    // ROOM

    val room_version = "2.6.1"

    implementation("androidx.room:room-runtime:$room_version")
    annotationProcessor("androidx.room:room-compiler:$room_version")

    val fragment_version = "1.8.4"

    // Java language implementation
    implementation("androidx.fragment:fragment:$fragment_version")

    implementation(libs.appcompat)
    implementation(libs.material)
    androidTestImplementation("androidx.test.ext:junit:1.1.5") // Provides AndroidJUnit4
    androidTestImplementation("androidx.test:core:1.5.0")

    // Espresso for UI testing
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    // Hilt Android testing dependencies
    androidTestImplementation("com.google.dagger:hilt-android-testing:2.52")
    annotationProcessor("com.google.dagger:hilt-compiler:2.52")

    // Core libraries for testing
    testImplementation("junit:junit:4.13.2") // JUnit4 for unit testing
}