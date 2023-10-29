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
        // Dans onCreate, j'initialisez SoLoader. C'est une bibliothèque native qui permet de charger du code natif depuis des fichiers APK.
        SoLoader.init(this, false)
        // créez une nouvelle instance de ReactRootView qui servira de conteneur pour vos composants React Native.
        reactRootView = ReactRootView(this)

        // Avant on configurer l'instance ici, mais si l'on souhaite utiliser React Native dans plusieurs activités ou fragments, il faut être capable de partager l'instance via un singleton
        // donc on a bougé la configuration dans le singleton
        // Configuration de ReactInstanceManager, il est configuré avec divers paramètres, comme les assets du bundle JS, le module principal JS, les packages natifs, etc.
        // Packages that cannot be autolinked yet can be added manually here, for example:
        // packages.add(MyReactNativePackage())
        // Remember to include them in `settings.gradle` and `app/build.gradle` too.

        val packages: List<ReactPackage> = PackageList(application).packages

        reactInstanceManager = ReactInstanceManager.builder()
            .setApplication(application)
            .setCurrentActivity(this)
            .setBundleAssetName("index.android.bundle")
            .setJSMainModulePath("index")
            .addPackages(packages)
            .setUseDeveloperSupport(DEBUG)
            .setInitialLifecycleState(LifecycleState.RESUMED)
            .build()




        // The string here (e.g. "MyReactNativeApp") has to match
        // the string in AppRegistry.registerComponent() in index.js
        // Ici, vous liez votre ReactRootView avec ReactInstanceManager et indiquez quel composant React Native doit être chargé.
        reactRootView?.startReactApplication(reactInstanceManager, "MyReactNativeApp", null)

        // vous définissez ReactRootView comme vue principale de l'Activity
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


    // Cette méthode est appelée lorsque l'utilisateur appuie sur le bouton "Retour".
    override fun invokeDefaultOnBackPressed() {
        super.onBackPressed()
    }


}