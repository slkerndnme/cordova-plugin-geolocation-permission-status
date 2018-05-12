#import <Cordova/CDV.h>
#import <CoreLocation/CoreLocation.h>

@interface CDVLocationPermissionStatus : CDVPlugin

- (void) getStatus:(CDVInvokedUrlCommand*)command;
- (bool) hasPermission;

@end