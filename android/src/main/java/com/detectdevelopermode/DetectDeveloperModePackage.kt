package com.detectdevelopermode

import android.provider.Settings
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod

class DetectDeveloperModeModule(reactContext: ReactApplicationContext) : ReactContextBaseJavaModule(reactContext) {

    override fun getName(): String {
        return "DetectDeveloperModeModule"
    }

    @ReactMethod
    fun isDeveloperModeEnabled(): Boolean {
        val developmentSettingsEnabled = Settings.Global.getInt(
            reactApplicationContext.contentResolver,
            Settings.Global.DEVELOPMENT_SETTINGS_ENABLED,
            0
        )
        return developmentSettingsEnabled != 0
    }
}
