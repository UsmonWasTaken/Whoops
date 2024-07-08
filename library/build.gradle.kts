plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.compose.compiler)
    `maven-publish`
    alias(libs.plugins.kotlinx.binaryCompatibilityValidator)
}

android {
    namespace = "io.usmon.whoops"
    compileSdk = 34

    defaultConfig {
        minSdk = 21
        multiDexEnabled = true

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
        isCoreLibraryDesugaringEnabled = true
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        buildConfig = false
        compose = true
    }
}

afterEvaluate {
    publishing {
        publications {
            register("mavenRelease", MavenPublication::class) {
                groupId = "com.github.UsmonWasTaken"
                artifactId = "Whoops"
                version = "1.0.0-alpha1"
                from(components["debug"])
            }
        }
    }
}

dependencies {
    coreLibraryDesugaring(libs.desugarJdkLibs)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.iconsExtended)
    implementation(libs.androidx.material3)
    debugImplementation(libs.androidx.ui.tooling.preview)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}