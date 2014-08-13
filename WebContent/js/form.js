

var app = angular.module('myApp', ['ngGrid']);

app.controller('MyCtrl', function($scope, $http) {

	$scope.createUser = function() {
		if ($scope.person.id != null) {
			console.log('alter');
			console.log($scope.person);
			$scope.alterUser();
		} else {
			console.log('create');
			console.log($scope.person);
			$http({
						method : 'POST',
						url : 'resources/persons',
						headers : {
							'Content-Type' : 'application/json'
						},

						data : $scope.person
					}).success(function(data) {
						$scope.status = data;
						$('#addUser').modal('hide');
						$scope.person = {
							id : null,
							nome : "",
							idade : ""
						};
						$scope.refreshGrid();

					});
		}
	};

	$scope.alterUser = function() {
		console.log($scope.person), $http({
					method : 'POST',
					url : 'resources/persons/alter',
					headers : {
						'Content-Type' : 'application/json'
					},

					data : $scope.person
				}).success(function(data) {
					$scope.status = data;
					$('#addUser').modal('hide');
					$scope.person = {
						id : null,
						nome : "",
						idade : ""
					};
					$scope.refreshGrid();

				});
	};
	$scope.delUser = function() {
		console.log('del')
		console.log($scope.person), $http({
					method : 'POST',
					url : 'resources/persons/del',
					headers : {
						'Content-Type' : 'application/json'
					},

					data : $scope.person
				}).success(function(data) {
					$scope.status = data;
					$('#delUser').modal('hide');
					$scope.refreshGrid();

				});
	};

	$scope.refreshGrid = function(page) {
		$http({
					url : 'resources/persons',
					method : 'GET'

				}).success(function(data) {
					$scope.persons = data;
				});
	};

	// Do something when the grid is sorted.
	// The grid throws the ngGridEventSorted that gets picked up here and
	// assigns the sortInfo to the scope.
	// This will allow to watch the sortInfo in the scope for changed and
	// refresh the grid.
	$scope.$on('ngGridEventSorted', function(event, sortInfo) {
				$scope.sortInfo = sortInfo;
			});

	// Watch the sortInfo variable. If changes are detected than we need to
	// refresh the grid.
	// This also works for the first page access, since we assign the initial
	// sorting in the initialize section.
	$scope.$watch('sortInfo', function() {
				$scope.refreshGrid($scope.persons.currentPage);
			}, true);

	// Initialize required information: sorting, the first page to show and the
	// grid options.

	$scope.persons = {
		currentPage : 1
	};
	$scope.select = function(user, type) {
		$scope.person = user;
		if (type == 'edit') {

			$('#addUser').modal('show');
		} else {
			$('#delUser').modal('show');
		}

	};

	$scope.mySelections = [];
	$scope.gridOptions = {
		data : 'persons',
		selectedItems : $scope.mySelections,
		multiSelect : false

	};

		//   
		// $scope.myData = [{name: "Moroni", age: 50},
		// {name: "Tiancum", age: 43},
		// {name: "Jacob", age: 27},
		// {name: "Nephi", age: 29},
		// {name: "Enos", age: 34}];
		// $scope.gridOptions = { data: 'myData' };
	});