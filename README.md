# cordova-plugin-geolocation-permission-status

Simple plugin that retrieve the location permission status. (Android and iOS)

## Installation

    $ cordova plugin add cordova-plugin-geolocation-permission-status
    
## Usage

```js
locationPermission.getStatus(function(status) {
    switch(status) {
        case locationPermission.GRANTED: console.log('Granted !'); break;
        case locationPermission.DENIED: console.log('Location permission have been denied or not yet granted...');
    }
});
```