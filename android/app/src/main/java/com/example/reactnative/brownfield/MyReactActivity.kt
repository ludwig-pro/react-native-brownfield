package com.example.reactnative.brownfield

import com.facebook.react.*
import com.facebook.react.ReactPackage
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler
import android.app.Activity
import android.os.Bundle
import android.view.KeyEvent
import com.example.reactnative.brownfield.BuildConfig.*
import com.facebook.react.common.LifecycleState
import com.facebook.soloader.SoLoader


class MyReactActivity : Activity(), DefaultHardwareBackBtnHandler {
    private lateinit var reactRootView: ReactRootView
    private lateinit var reactInstanceManager: ReactInstanceManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        SoLoader.init(this, false)
        reactRootView = ReactRootView(this)

        val packages: List<ReactPackage> = PackageList(application).packages.apply {
            add(BrownfieldPackage())
        }

        reactInstanceManager = ReactInstanceManager.builder()
            .setApplication(application)
            .setCurrentActivity(this)
            .setBundleAssetName("index.android.bundle")
            .setJSMainModulePath("index")
            .addPackages(packages)
            .setUseDeveloperSupport(DEBUG)
            .setInitialLifecycleState(LifecycleState.RESUMED)
            .build()

        reactRootView?.startReactApplication(reactInstanceManager, "MyReactNativeApp", null)

        setContentView(reactRootView)
    }


    override fun onPause() {
        super.onPause()
        reactInstanceManager.onHostPause(this)
    }

    override fun onResume() {
        super.onResume()
        reactInstanceManager.onHostResume(this, this)
    }

    override fun onDestroy() {
        super.onDestroy()
        reactInstanceManager.onHostDestroy(this)
        reactRootView.unmountReactApplication()
    }

    override fun onBackPressed() {
        reactInstanceManager.onBackPressed()
        super.onBackPressed()
    }

    override fun onKeyUp(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_MENU && reactInstanceManager != null) {
            reactInstanceManager.showDevOptionsDialog()
            return true
        }
        return super.onKeyUp(keyCode, event)
    }

    override fun invokeDefaultOnBackPressed() {
        super.onBackPressed()
    }


}