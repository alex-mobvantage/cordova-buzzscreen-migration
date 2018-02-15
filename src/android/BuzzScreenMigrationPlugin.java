package com.buzzvil.buzzscreen.migration.cordova;

import android.util.Log;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.buzzvil.buzzscreen.migration.MigrationHost;

public class BuzzScreenMigrationPlugin extends CordovaPlugin {
    private static final String TAG = "BuzzScreenMigration";

    private static final String REQUEST_USER_PROFILE_SYNC = "requestUserProfileSync";
    private static final String REQUEST_ACTIVATION_WITH_LAUNCH = "requestActivationWithLaunch";
    private static final String REQUEST_ACTIVATION = "requestActivation";
    private static final String REQUEST_DEACTIVATION = "requestDeactivation";
    private static final String IS_LOCKSCREEN_ACTIVATED = "isLockscreenActivated";

    @Override
    public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
        if (action.equals(REQUEST_USER_PROFILE_SYNC)){
            MigrationHost.requestUserProfileSync();

            Log.d(TAG, "Requested user profile sync");
            callbackContext.success();
            return true;
        } else if (action.equals(REQUEST_ACTIVATION_WITH_LAUNCH)){
            MigrationHost.requestActivationWithLaunch();

            Log.d(TAG, "Requested activation with launch");
            callbackContext.success();
            return true;
        } else if (action.equals(REQUEST_ACTIVATION)){
            MigrationHost.requestActivation(new MigrationHost.OnRequestActivateResponseListener() {
                @Override
                public void onAlreadyActivated() {
                    Log.i(TAG, "Lockscreen app is already activated");
                }

                @Override
                public void onActivated() {
                    Log.i(TAG, "Lockscreen app is activated");
                }

                @Override
                public void onError(MigrationHost.RequestActivationError error){
                    Log.w(TAG, "Lockscreen activation error");
                }
            });

            Log.d(TAG, "Requested activation");
            callbackContext.success();
            return true;
        } else if (action.equals(REQUEST_DEACTIVATION)){
            MigrationHost.requestDeactivation();
            
            Log.d(TAG, "Requested deactivation");
            callbackContext.success();
            return true;
        } else if (action.equals(IS_LOCKSCREEN_ACTIVATED)){
            JSONObject result = new JSONObject();
            boolean isActivated = MigrationHost.isLockScreenAppActivated();
            result.put("is_activated", isActivated);
    
            Log.i(TAG, "Get is lockscreen activated: " + isActivated);
            callbackContext.success(result);
        } else {
            Log.e(TAG, "Unknown/unsupported action: " + action);
            callbackContext.error("Unknown/unsupported action");
        }

        return false;
    }
}