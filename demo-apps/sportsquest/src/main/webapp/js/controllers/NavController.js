'use strict';

angular.module('sportsQuest').controller('NavController',
    ['$scope', '$location', function ($scope, $location) {

        $scope.navClass = function (page) {
            var currentRoute = $location.path().substring(1) || 'home';
            return page === currentRoute ? 'active' : '';
        };

        $scope.loadHome = function () {
            $location.url('/home');
        };

        $scope.loadLogin = function () {
            $location.url('/login');
        };

    }]);