// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
}

buildscript {
    dependencies {
        // Other classpaths
        classpath ("com.google.dagger:hilt-android-gradle-plugin:2.44") // Ensure this is added
    }
}

