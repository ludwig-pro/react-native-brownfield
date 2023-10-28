buildscript {
    // a mon avis, je peux supprimer ça
    // extra["compose_version"] = "1.1.0"

    repositories {
        google()
        mavenCentral()
    }
    // a mon avis, je peux supprimer ça
    /*
    dependencies {
        classpath("com.android.tools.build:gradle:7.0.4")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.10")
    }*/
}
// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.1.2" apply false
    id("org.jetbrains.kotlin.android") version "1.8.10" apply false
}
/*
tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}*/

/*
allprojects {
    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
        kotlinOptions {
            freeCompilerArgs += listOf(
                "-Xuse-experimental=kotlin.ExperimentalUnsignedTypes",
                "-Xuse-experimental=kotlinx.coroutines.DelicateCoroutinesApi",
                "-Xuse-experimental=kotlinx.coroutines.ExperimentalCoroutinesApi",
                "-Xuse-experimental=kotlinx.coroutines.FlowPreview",
                "-Xuse-experimental=kotlinx.coroutines.InternalCoroutinesApi",
                "-Xuse-experimental=kotlinx.serialization.ExperimentalSerializationApi",
                "-Xuse-experimental=androidx.compose.animation.ExperimentalAnimationApi",
                "-Xuse-experimental=androidx.compose.ExperimentalComposeApi",
                "-Xuse-experimental=androidx.compose.material.ExperimentalMaterialApi",
                "-Xuse-experimental=androidx.compose.runtime.ExperimentalComposeApi",
                "-Xuse-experimental=androidx.compose.ui.ExperimentalComposeUiApi",
                "-Xuse-experimental=coil.annotation.ExperimentalCoilApi",
                "-Xuse-experimental=com.google.accompanist.pager.ExperimentalPagerApi"
            )
        }
    }
}*/
