package com.slkerndnme.cordova.locationpermissionstatus;

import org.apache.cordova.*;
import org.json.JSONArray;
import org.json.JSONException;

import android.Manifest;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class LocationPermissionStatus extends CordovaPlugin {

    private static final String [] PERMISSIONS = { Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION };
    private static final int PERMISSION_GRANTED = 1;
    private static final int PERMISSION_DENIED = 0;

    @Override
    public boolean execute(String action, JSONArray data, CallbackContext callbackContext) throws JSONException {

        if (action.equals("getStatus")) {

            int statusCode = PERMISSION_GRANTED;

            if (!this.hasPermission())
                statusCode = PERMISSION_DENIED;

            callbackContext.success(statusCode);

            return true;

        } else {
            
            return false;
        }
    }

    public boolean hasPermission() {

        for (String permission : PERMISSIONS) {
            if (!PermissionHelper.hasPermission(this, permission))
                return false;
        }

        return true;
    }
}
