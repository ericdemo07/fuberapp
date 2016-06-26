package com.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.pojo.TaxiDetailPOJO;
import com.service.BookTaxiUtil;

public class BookTaxiController {
	final static Logger log = LoggerFactory.getLogger(BookTaxiController.class);

	@RequestMapping(value = "/booktaxi", method = RequestMethod.POST)
	public @ResponseBody Object initialRequest(@RequestBody TaxiDetailPOJO taxiDetailObject) {
		log.info("\n\t[Request successfully received by BookTaxiController]\n");
		log.info("Request : [" + taxiDetailObject.toString() + "]");
		try {
			BookTaxiUtil bookTaxiUtil = new BookTaxiUtil();
			bookTaxiUtil.bookATaxi(taxiDetailObject.getTaxiNumber());
		} catch (Exception e) {
			log.error("Following error occoured while processing fuberapp :[" + e.getMessage());
			return "erroroccouredwhilebooking";
		}
		return "successfullybooked";
	}
}
