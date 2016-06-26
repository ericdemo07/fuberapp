(function() {
	angular.module('fuberApp', [ 'ui.router', 'ui.bootstrap' ]).config(config);
	config.$inject = [ '$stateProvider', '$urlRouterProvider' ];
//using angular ui router can be expanded for additional states
	function config($stateProvider, $urlRouterProvider) {
		$urlRouterProvider.otherwise("/taxisearchquery");
		$stateProvider.state('taxiSearchQuery', {
			url : '/taxisearchquery',
			controller : 'TaxiSearchQueryController',
			templateUrl : 'taxiSearchQuery/taxiSearchQuery.view.html',
			controllerAs : 'vm'
		});
	}
})();