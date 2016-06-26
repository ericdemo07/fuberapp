package com.service;

import java.sql.SQLException;

import com.db.H2DatabaseConnection;

public class BookTaxiUtil {
	public void bookATaxi(String taxiNumber) throws SQLException {
		H2DatabaseConnection connection = new H2DatabaseConnection();
		connection.bookATaxi(taxiNumber);
	}
}
