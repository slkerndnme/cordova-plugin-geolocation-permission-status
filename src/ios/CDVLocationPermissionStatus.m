#import <Cordova/CDV.h>
#import "CDVLocationPermissionStatus.h"

const int PERMISSION_GRANTED = 1;
const int PERMISSION_DENIED = 0;

@implementation CDVLocationPermissionStatus

- (void)getStatus:(CDVInvokedUrlCommand*)command {

    int statusCode = PERMISSION_GRANTED;

    if (![self hasPermission])
        statusCode = PERMISSION_DENIED;

    CDVPluginResult* result = [CDVPluginResult
    resultWithStatus:CDVCommandStatus_OK
    messageAsInt:statusCode];

    [self.commandDelegate sendPluginResult:result callbackId:command.callbackId];
}

- (bool)hasPermission {

    // https://developer.apple.com/documentation/corelocation/clauthorizationstatus
    int statusCode = [CLLocationManager authorizationStatus];

    return statusCode == 3 || statusCode == 4;
}

@end