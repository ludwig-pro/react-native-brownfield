pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    // repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "React-Native Brownfield"
include(":app")
includeBuild("../node_modules/@react-native/gradle-plugin")


// Enable native modules autolinking
apply(from = "../node_modules/@react-native-community/cli-platform-android/native_modules.gradle")
apply(from = "./nativeModules.gradle")
