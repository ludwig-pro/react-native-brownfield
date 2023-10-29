package com.example.reactnative.brownfield

import android.app.Application
import com.facebook.react.PackageList
import com.facebook.react.ReactInstanceManager
import com.facebook.react.ReactPackage
import com.facebook.react.common.LifecycleState

object ReactInstanceManagerHolder {
    private var reactInstanceManager: ReactInstanceManager? = null

    fun initialize(application: Application) {
        if (reactInstanceManager == null) {
            // Initialization code, similar to what you have in MyReactActivity
            val packages: List<ReactPackage> = PackageList(application).packages

            reactInstanceManager = ReactInstanceManager.builder()
                .setApplication(application)
                .setBundleAssetName("index.android.bundle")
                .setJSMainModulePath("index")
                .addPackages(packages)
                .setUseDeveloperSupport(BuildConfig.DEBUG)
                .setInitialLifecycleState(LifecycleState.BEFORE_CREATE)
                // .setInitialLifecycleState(LifecycleState.RESUMED)
                .build()
        }
    }

    fun getReactInstanceManager(): ReactInstanceManager {
        return reactInstanceManager ?: throw IllegalStateException("ReactInstanceManager not initialized")
    }

}
