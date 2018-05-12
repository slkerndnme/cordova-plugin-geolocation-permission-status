"use strict";

module.exports = {

    GRANTED: 1,
    DENIED: 0,

    getStatus: function (callback) {
        cordova.exec(callback, function () {
        }, "LocationPermissionStatus", "getStatus", []);
    }
};