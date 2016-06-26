(function() {
	angular.module('fuberApp').controller('TaxiSearchQueryController',
			TaxiSearchQueryController);
	TaxiSearchQueryController.$inject = [ '$scope', 'QueryService', '$state',
			'$stateParams' ];

	function TaxiSearchQueryController($scope, QueryService, $state,
			$stateParams) {
		var latitudeValue;
		var longitudeValue;
		var pinkFlagValue;
		$scope.getBrandNames = function() {
			latitudeValue = this.vm.latitude.value;
			longitudeValue = this.vm.longitude.value;
			pinkflagValue = this.vm.pinkflag.value;
			QueryService.TaxiSearchQuery(latitudeValue, longitudeValue,
					pinkflagValue).then(function(response) {
				$scope.taxiNumber = "taxiNumber";
				$scope.distance = "distance";
				$scope.flag_pink = "flag_pink";

				$scope.selected = undefined;
				$scope.taxiDetailResponseArray = response;
				console.log("Respone :[" + response);
			});
		}
	}
})();