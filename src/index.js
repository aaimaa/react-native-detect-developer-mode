import { NativeModules, Platform } from "react-native";

const { DetectDeveloperMode } = NativeModules;

if (DetectDeveloperMode == null) console.warn("DetectDeveloperMode is not available, check your native dependencies have linked correctly and ensure your app has been rebuilt");

export default {
  isDevelopmentSettingsMode: () => {
    // API only available on Android, return false for all other platforms.
    if (Platform.OS !== "android") return Promise.resolve(false);
    return DetectDeveloperMode.isDevelopmentSettingsMode();
  }
};
