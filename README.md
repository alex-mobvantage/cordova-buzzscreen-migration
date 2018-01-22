# cordova-buzzscreen-migration

This is a plugin for accessing the BuzzScreen Migration SDK functionality from within your cordova application.

**_Note: Only Android is currently supported_**

# Integration

Check out the <a href="https://github.com/Buzzvil/buzzscreen-sdk-publisher-migration/blob/master/README-EN.md">documentation</a> for installing the SDK.

# Cordova Usage

* To add plugin
```
cordova plugin add https://github.com/alex-mobvantage/cordova-buzzscreen-migration.git
```

* To remove plugin
```
cordova plugin remove cordova-buzzscreen-migration
```

# Supported Methods

* `requestUserProfileSync(successCallback, errorCallback)`
* `requestActivationWithLaunch(successCallback, errorCallback)`
* `requestActivation(successCallback, errorCallback)`
* `requestDeactivation(userId, successCallback, errorCallback)`
* `isLockscreenActivated(successCallback, errorCallback)`
