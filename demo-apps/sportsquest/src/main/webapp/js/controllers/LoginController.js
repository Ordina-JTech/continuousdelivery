'use strict';

angular.module('sportsQuest').controller('LoginController',
    function LoginController($scope){

        insertGoogleSignInButton();

        $scope.hideGoogleSigninButton = true;

        $scope.login = {
            name: "Login of registreer",
            credentials: {
                username: "<username>",
                password: "<password>"
            },
            oauthlogins: [
                {
                    name: 'twitter',
                    link: 'http://twitter.com'
                },
                {
                    name: 'facebook',
                    link: 'http://facebook.com'
                },
                {
                    name: 'google',
                    link: 'http://google.com'
                }
            ]
        }
    }

);

var loginFinished = function(authResult) {
    if (authResult) {
        console.log(authResult);

        if (authResult['status']['signed_in']) {
            gapi.auth.setToken(authResult);
            // Hide the sign-in button now that the user is authorized
            document.getElementById('google-signin-button').setAttribute('class', 'hide');
        } else {
            document.getElementById('google-signin-button').setAttribute('class', 'show');
            console.log('Access denied: ' + authResult['error']);
        }
    } else {
        document.getElementById('google-signin-button').setAttribute('class', 'show');
        document.getElementById('oauth2-results').innerHTML = 'Empty authResult';
    }
};

var options = {
    'callback' : loginFinished,
    'approvalprompt' : 'auto',
    'clientid' : '<TODO complete clientid>.apps.googleusercontent.com',
    'requestvisibleactions' : 'http://schemas.google.com/AddActivity',
    'cookiepolicy' : 'single_host_origin',
    'google-signin-scope' : 'https://www.googleapis.com/auth/plus.login'
};

function insertGoogleSignInButton(){
    gapi.signin.render('renderMe', options);
}
