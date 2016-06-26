package com.service;

import java.sql.SQLException;

import com.db.H2DatabaseConnection;
import com.pojo.TaxiDetailPOJO;

public class EndRideUtil {
	public void endCurrentRide(TaxiDetailPOJO taxiDetailObject) throws SQLException {
		H2DatabaseConnection connection = new H2DatabaseConnection();
		connection.endUserRide(taxiDetailObject);
	}
}
