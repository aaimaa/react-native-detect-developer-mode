package com.detectdevelopermode

import android.provider.Settings
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod
import com.facebook.react.bridge.Promise

class DetectDeveloperModeModule(reactContext: ReactApplicationContext) : ReactContextBaseJavaModule(reactContext) {

    override fun getName(): String {
        return "DetectDeveloperModeModule"
    }

    @ReactMethod
    fun isDeveloperModeEnabled(promise: Promise) {
        try {
            val developmentSettingsEnabled = Settings.Global.getInt(
                reactApplicationContext.contentResolver,
                Settings.Global.DEVELOPMENT_SETTINGS_ENABLED
            )
            promise.resolve(developmentSettingsEnabled != 0)
        } catch (e: Settings.SettingNotFoundException) {
            promise.reject("SETTING_NOT_FOUND", e)
        }
    }
}
