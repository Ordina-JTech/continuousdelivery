'use strict';

angular.module('sportsQuest').controller('CarouselDemoCtrl',
    function CarouselDemoCtrl($scope) {
        $scope.myInterval = 15000;
        var slides = $scope.slides = [];
        $scope.addSlide = function() {
	        var newWidth = 1 + slides.length;
	        slides.push({
	            image: 'img/sports' + newWidth + '.jpg',
	            text: ['Slide0','Slide1','Slide2','Slide3'][slides.length % 4] + ' ' +
	            ['Sports', 'Sports', 'Sports', 'Sports'][slides.length % 4]
	        });
        };
        for (var i=0; i<4; i++) {
            $scope.addSlide();
        }
   }
);