import { NativeModules, Platform } from "react-native";

const LINKING_ERROR =
  `The package 'react-native-detect-developer-mode' doesn't seem to be linked. Make sure: \n\n` +
  Platform.select({ ios: "- You have run 'pod install'\n", default: "" }) +
  "- You rebuilt the app after installing the package\n" +
  "- You are not using Expo Go\n";

const DetectDeveloperMode = NativeModules.DetectDeveloperMode;

if (!DetectDeveloperMode) {
  throw new Error(LINKING_ERROR);
}

export function isDeveloperModeEnabled() {
  if (!DetectDeveloperMode.isDeveloperModeEnabled) {
    throw new Error(LINKING_ERROR);
  }
  return DetectDeveloperMode.isDeveloperModeEnabled();
}
