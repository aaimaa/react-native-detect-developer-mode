
#ifdef RCT_NEW_ARCH_ENABLED
#import "RNDetectDeveloperModeSpec.h"

@interface DetectDeveloperMode : NSObject <NativeDetectDeveloperModeSpec>
#else
#import <React/RCTBridgeModule.h>

@interface DetectDeveloperMode : NSObject <RCTBridgeModule>
#endif

@end
