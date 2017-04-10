/**
 * Controllers and Angular
 */
console.log('in gamestore');
angular.module("gameApp", ["ngRoute"]); // $locationProvider  $routeProvider

/**
 * Configure to use ANgular Routing 
 */
angular.module("gameApp").config(function($locationProvider, $routeProvider){
	$locationProvider.hashPrefix("");
	$routeProvider
		.when("/add", {
			templateUrl: "addGame.html",
			controller: "addGame"
		} )
		.when("/find", {
			template: "findGame.html",
			controller: "findGame"
		})
		.when("/findAll", {
			templateUrl: "allGames.html",
			controller: "allGames"
		})
		.otherwise({
			template: "main.html"
		});
	
});

// $http service -> create XHR objs and communicate with servers
angular.module("gameApp").controller("allGames", 
		function($http, $scope) {
	
	$http({
		url: "http://localhost:8081/games/game/all",
		method: "GET"
	}).then(function(response) {
		// server successfully sends data -- 200 code range
								// .data is response body
		$scope.games = response.data;
	}, function(response) {
		console.log("GET ALL: Failed to fetch games");
	});
	
});

angular.module("gameApp").controller("findGame", 
		function($http, $scope, $timeout) {
	$scope.fetch = function() {
		$http({
			url: "http://localhost:8081/games/game/" + $scope.query,
			method: "GET"
		}).then(function(response) {
			$scope.result = response.data;
			$scope.error = "";
		}, function(response) {
			$scope.result = "";
			$scope.error = response.statusText;
			$timeout(function() {
				$scope.error = "";
			}, 2000);
		});
		$http.get("http://localhost:7001/games/game/" + $scope.query)
			.then(function(response) {
				$scope.result = response.data;
			});
	}
});

angular.module("gameApp").controller("addGame", 
		function($http, $scope) {
	
	$scope.send = function() {
		var formData = {
			title: $scope.title,
			genre: $scope.genre
		};
		
		$http({
			url:"http://localhost:8081/games/game/",
			method: "POST",
			data: formData
		}).then(function(response) {
			// reset form
			$scope.title = "";
			$scope.genre = "";
		}, function(response) {
			console.log("Errors in data you're sending");
		});
	}
});





