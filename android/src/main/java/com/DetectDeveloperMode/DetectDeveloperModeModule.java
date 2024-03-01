package com.DetectDeveloperMode;

import android.content.pm.ApplicationInfo;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Debug;
import android.provider.Settings;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Nullable;

public class DetectDeveloperModeModule extends ReactContextBaseJavaModule {

    ReactApplicationContext reactContext;


    public DetectDeveloperModeModule(ReactApplicationContext reactContext, boolean loadConstantsAsynchronously) {
        super(reactContext);

        this.reactContext = reactContext;

    }

    @Override
    public String getName() {
        return "DetectDeveloperMode";
    }


    @ReactMethod
    public void isDevelopmentSettingsMode(Promise p) {
        boolean isDevelopmentSettingsMode;
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN_MR1) {
            isDevelopmentSettingsMode = Settings.System.getInt(this.reactContext.getContentResolver(), Settings.Secure.DEVELOPMENT_SETTINGS_ENABLED, 0) != 1;
        } else {
            isDevelopmentSettingsMode = Settings.Global.getInt(this.reactContext.getContentResolver(), Settings.Global.DEVELOPMENT_SETTINGS_ENABLED, 0) == 1;
        }
        p.resolve(isDevelopmentSettingsMode);
    }
}
