package com.controller;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.pojo.CustomerQueryPOJO;
import com.pojo.TaxiDetailPOJO;
import com.service.FindNearestTaxi;

@RestController
public class TaxiSearchController {
	final static Logger log = LoggerFactory.getLogger(TaxiSearchController.class);

	@RequestMapping(value = "/searchtaxi", method = RequestMethod.POST)
	public @ResponseBody Object initialRequest(@RequestBody CustomerQueryPOJO customerQueryObject) {
		List<TaxiDetailPOJO> listOf5NearestTaxi = new ArrayList<>();
		log.info("\n\t[Request successfully received by SearchQueryController]\n");
		log.info("Request : [" + customerQueryObject.toString() + "]");
		try {
			FindNearestTaxi findNearestTaxi = new FindNearestTaxi();
			listOf5NearestTaxi = findNearestTaxi.searchNearestTaxi(customerQueryObject);
		} catch (Exception e) {
			log.error("Following error occoured while processing fuberapp :[" + e.getMessage());
		}

		if (listOf5NearestTaxi.size() == 0) {
			return "noavailability";
		}
		return listOf5NearestTaxi.toArray();
	}
}
