
plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}
//引入上层目录的common.gradle文件内容
apply("../common.gradle")

android {
    namespace = "com.pn.news"

    defaultConfig {
        applicationId = "com.pn.news"
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

    kotlinOptions {
        jvmTarget = "19"
    }
    //开启视图绑定，代替findViewById
    buildFeatures {
        viewBinding= true
    }

    dependencies {
        // https://mvnrepository.com/artifact/me.relex/circleindicator
        implementation("me.relex:circleindicator:2.1.6")

    }
}
