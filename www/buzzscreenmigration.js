var exec = require('cordova/exec');

var BuzzScreenMigration = {
  requestUserProfileSync: function(successCallback, errorCallback){
    cordova.exec(successCallback, errorCallback, 'BuzzScreenMigration', 'requestUserProfileSync', []);
  },

  requestActivationWithLaunch: function(successCallback, errorCallback){
    cordova.exec(successCallback, errorCallback, 'BuzzScreenMigration', 'requestActivationWithLaunch', []);
  },

  requestActivation: function(successCallback, errorCallback){
    cordova.exec(successCallback, errorCallback, 'BuzzScreenMigration', 'requestActivation', []);
  },

  requestDeactivation: function(userId, successCallback, errorCallback){
    cordova.exec(successCallback, errorCallback, 'BuzzScreenMigration', 'requestDeactivation', []);
  }
} 

module.exports = BuzzScreenMigration;
