package com.tests;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import com.db.H2DatabaseConnection;
import com.pojo.CustomerQueryPOJO;
import com.pojo.TaxiDetailPOJO;
import com.service.BookTaxiUtil;
import com.service.EndRideUtil;
import com.service.FindNearestTaxi;

public class TaxiBookingTests {
	// Initialize sample db
	@Before
	public void initObjects() {
		try {
			H2DatabaseConnection.prepareDB();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// test count of taxi available for given request
	@Test
	public void provideTaxiByLocation() {
		CustomerQueryPOJO customerPOJO = new CustomerQueryPOJO();
		customerPOJO.setLatitute(12.2);
		customerPOJO.setLongitude(72.2);
		customerPOJO.setFlagPinkTaxi(false);
		FindNearestTaxi findNearestTaxi = new FindNearestTaxi();

		assertEquals(5, findNearestTaxi.searchNearestTaxi(customerPOJO).size());
	}

	// test count of pink taxi available for given request
	@Test
	public void providePinkTaxiByLocation() {
		CustomerQueryPOJO customerPOJO = new CustomerQueryPOJO();
		customerPOJO.setLatitute(12.2);
		customerPOJO.setLongitude(72.2);
		customerPOJO.setFlagPinkTaxi(true);
		FindNearestTaxi findNearestTaxi = new FindNearestTaxi();

		assertEquals(3, findNearestTaxi.searchNearestTaxi(customerPOJO).size());
	}

	// test to book a taxi by taxi number
	@Test
	public void bookATaxi() {
		BookTaxiUtil bookTaxiUtil = new BookTaxiUtil();
		try {
			bookTaxiUtil.bookATaxi("KA02HR5021");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// end user ride
	@Test
	public void endUserRide() {
		EndRideUtil endRideUtil = new EndRideUtil();
		try {
			TaxiDetailPOJO taxiDetailObject = new TaxiDetailPOJO();
			taxiDetailObject.setLatitude(23.44);
			taxiDetailObject.setLongitude(75.44);
			taxiDetailObject.setTaxiNumber("KA02HR5021");
			endRideUtil.endCurrentRide(taxiDetailObject);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
