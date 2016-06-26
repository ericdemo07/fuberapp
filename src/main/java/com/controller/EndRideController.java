package com.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.pojo.TaxiDetailPOJO;
import com.service.EndRideUtil;

public class EndRideController {
	final static Logger log = LoggerFactory.getLogger(EndRideController.class);

	@RequestMapping(value = "/endride", method = RequestMethod.POST)
	public @ResponseBody Object initialRequest(@RequestBody TaxiDetailPOJO taxiDetailObject) {
		log.info("\n\t[Request successfully received by EndRideController]\n");
		log.info("Request : [" + taxiDetailObject.toString() + "]");
		try {
			EndRideUtil endRideUtil = new EndRideUtil();
			endRideUtil.endCurrentRide(taxiDetailObject);
		} catch (Exception e) {
			log.error("Following error occoured while processing fuberapp :[" + e.getMessage());
			return "erroroccouredwhilebooking";
		}
		return "successfullybooked";
	}

}
