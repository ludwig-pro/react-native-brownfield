package com.example.reactnative.brownfield

import com.facebook.react.*
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler
import android.app.Activity
import android.os.Bundle
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

        val packages: List<ReactPackage> = PackageList(application).packages
        // Packages that cannot be autolinked yet can be added manually here, for example:
        // packages.add(MyReactNativePackage())
        // Remember to include them in `settings.gradle` and `app/build.gradle` too.

        // Configuration de ReactInstanceManager, il est configuré avec divers paramètres, comme les assets du bundle JS, le module principal JS, les packages natifs, etc.
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

    // Cette méthode est appelée lorsque l'utilisateur appuie sur le bouton "Retour".
    override fun invokeDefaultOnBackPressed() {
        super.onBackPressed()
    }
}