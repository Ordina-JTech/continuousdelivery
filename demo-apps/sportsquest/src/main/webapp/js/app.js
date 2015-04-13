'use strict';

var sportsQuest = angular.module('sportsQuest', ['ngRoute', 'ngAnimate', 'ui.bootstrap']);

sportsQuest.config(function ($routeProvider, $locationProvider) {

    $routeProvider.when('/login',
        {
            templateUrl:    'login.html',
            controller:     'LoginController'
        });
    $routeProvider.otherwise(
        {
            redirectTo:     'index.html',
            controller:     'NavController'
        }
    );
});

//Workaround for bug: https://github.com/angular-ui/bootstrap/issues/1350
sportsQuest.directive('disableNgAnimate', ['$animate', function($animate) {
	return {
	    restrict: 'A',
	    link: function(scope, element) {
	      $animate.enabled(false, element);
    	}
    };
}]);




