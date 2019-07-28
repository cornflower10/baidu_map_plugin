#import "BaiduMapPlugin.h"
#import <baidu_map_plugin/baidu_map_plugin-Swift.h>

@implementation BaiduMapPlugin
+ (void)registerWithRegistrar:(NSObject<FlutterPluginRegistrar>*)registrar {
  [SwiftBaiduMapPlugin registerWithRegistrar:registrar];
}
@end
