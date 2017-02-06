angular
    .module('myApp')
    .config(function($stateProvider, $urlRouterProvider) {
        $stateProvider
            .state('home', {
                url: '/home',
                templateUrl : 'pages/home.html',
                controller  : 'mainController'
            })
            .state('about', {
                url: '/about',
                templateUrl : 'pages/about.html',
                controller  : 'aboutController'
            })
            .state('vocabulary', {
                url: '/vocabulary',
                templateUrl : 'pages/vocabulary.html',
                controller  : 'vocabularyController'
            })
            .state('exams', {
                url: '/exams',
                templateUrl : 'pages/exams.html',
                controller  : 'examsController'
            })
            .state('resources', {
                url: '/resources',
                templateUrl : 'pages/resources.html',
                controller  : 'resourcesController'
            });
        $urlRouterProvider
            .otherwise('/home');
    })
    .controller('mainController', function($scope) {
        $scope.message = 'Everyone come and see how good I look!';
    })
    .controller('aboutController', function($scope) {
        $scope.message = 'Look! I am an about page.';
    })
    .controller('vocabularyController', function($scope) {
        $scope.message = 'Everyone come and see how good I look!';
    })
    .controller('examsController', function($scope) {
        $scope.message = 'Look! I am an about page.';
    })
    .controller('resourcesController', function($scope) {
        $scope.message = 'Contact us! JK. This is just a demo.';
    });