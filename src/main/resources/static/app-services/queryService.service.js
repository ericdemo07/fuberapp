(function() 
	{
		angular.module('fuberApp').factory('QueryService',QueryService);
		QueryService.$inject = ['$http','$location'];
		
		function QueryService($http, $location) 
		{
			var service = {};
			service.TaxiSearchQuery = TaxiSearchQuery;

			return service;
			
			function TaxiSearchQuery(latitudeValue, latitudeValue, pinkflagValue) 
			{
				console.log ("Query :"+pinkflagValue);
				var request = $http(
				{
					method : "post",
					url : "/searchtaxi",
					data : {"latitute":latitudeValue,"longitude":latitudeValue,"flagPinkTaxi":pinkflagValue}
				});
				return request.then(handleSuccess, handleError('Faliure'));
			}
			function handleSuccess(data) 
			{
				response = data.data;
				return response;
			}
			function handleError(error) 
			{
				return function() 
				{
					return 
					{
						success : false
					};
				};
			}
		}
	}
)();