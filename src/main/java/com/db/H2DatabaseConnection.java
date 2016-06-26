package com.db;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.h2.tools.DeleteDbFiles;
import org.h2.tools.RunScript;
import com.pojo.TaxiDetailPOJO;

public class H2DatabaseConnection {
	private static final String DB_DRIVER = "org.h2.Driver";
	private static final String DB_CONNECTION = "jdbc:h2:~/test";
	private static final String DB_USER = "";
	private static final String DB_PASSWORD = "";

	public List<TaxiDetailPOJO> getAllTaxi() throws SQLException {
		Connection connection = getDBConnection();
		Statement stmt = null;
		stmt = connection.createStatement();
		List<TaxiDetailPOJO> taxiDetailObjectList = new ArrayList<>();
		ResultSet rs = stmt.executeQuery("SELECT * FROM TAXI");
		while (rs.next()) {
			TaxiDetailPOJO taxiDetailObject = new TaxiDetailPOJO();
			taxiDetailObject.setTaxiNumber(rs.getString("taxi_number"));
			taxiDetailObject.setLatitude(rs.getDouble("latitude"));
			taxiDetailObject.setLongitude(rs.getDouble("longitude"));
			taxiDetailObject.setFlag_pink(rs.getBoolean("flag_pink"));
			taxiDetailObject.setFlag_occupied(rs.getBoolean("flag_occupied"));
			taxiDetailObjectList.add(taxiDetailObject);
		}
		stmt.close();
		connection.commit();
		return taxiDetailObjectList;
	}

	public void bookATaxi(String taxiNumber) throws SQLException {
		Connection connection = getDBConnection();
		Statement stmt = null;
		stmt = connection.createStatement();
		stmt.executeUpdate("UPDATE TAXI SET flag_occupied = 1 WHERE taxi_number ='" + taxiNumber + "'");
	}

	public void endUserRide(TaxiDetailPOJO taxiDetailObject) throws SQLException {
		Connection connection = getDBConnection();
		Statement stmt = null;
		stmt = connection.createStatement();
		stmt.executeUpdate("UPDATE TAXI SET flag_occupied = 0, latitude ='" + taxiDetailObject.getLatitude()
				+ "',longitude ='" + taxiDetailObject.getLongitude() + "' WHERE taxi_number ='"
				+ taxiDetailObject.getTaxiNumber() + "'");
	}

	// Preparing Database
	public static void prepareDB() throws SQLException {
		DeleteDbFiles.execute("~", "test", true);
		Connection connection = getDBConnection();
		try {
			RunScript.execute(connection, new FileReader("db.sql"));
			connection.setAutoCommit(false);
			connection.commit();
		} catch (IOException | SQLException e) {
			System.out.println("Exception Message " + e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
	}

	// Database connection
	private static Connection getDBConnection() {
		Connection dbConnection = null;
		try {
			Class.forName(DB_DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		try {
			dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
			return dbConnection;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return dbConnection;
	}
}