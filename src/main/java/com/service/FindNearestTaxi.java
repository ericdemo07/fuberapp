package com.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.db.H2DatabaseConnection;
import com.pojo.CustomerQueryPOJO;
import com.pojo.TaxiDetailPOJO;

public class FindNearestTaxi {
	public List<TaxiDetailPOJO> searchNearestTaxi(CustomerQueryPOJO customerQueryObject) {
		H2DatabaseConnection connection = new H2DatabaseConnection();
		Map<Double, TaxiDetailPOJO> mapOfNearestTaxi = new HashMap<>();
		List<Double> distanceList = new ArrayList<>();
		try {
			List<TaxiDetailPOJO> taxiDetailObjectList = connection.getAllTaxi();

			for (TaxiDetailPOJO taxiDetailObject : taxiDetailObjectList) {
				if (customerQueryObject.getFlagPinkTaxi().equals(true)) {
					if (taxiDetailObject.getFlag_occupied().equals(false)
							&& taxiDetailObject.getFlag_pink().equals(true)) {
						Double latitudeDiff = Math
								.abs(customerQueryObject.getLatitute() - taxiDetailObject.getLatitude());
						Double longitideDiff = Math
								.abs(customerQueryObject.getLongitude() - taxiDetailObject.getLongitude());
						Double distance = pitagor(latitudeDiff, longitideDiff);
						distanceList.add(distance);
						mapOfNearestTaxi.put(distance, taxiDetailObject);
					}
				} else if (taxiDetailObject.getFlag_occupied().equals(false)) {
					Double latitudeDiff = Math.abs(customerQueryObject.getLatitute() - taxiDetailObject.getLatitude());
					Double longitideDiff = Math
							.abs(customerQueryObject.getLongitude() - taxiDetailObject.getLongitude());
					Double distance = pitagor(latitudeDiff, longitideDiff);
					distanceList.add(distance);
					mapOfNearestTaxi.put(distance, taxiDetailObject);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		List<TaxiDetailPOJO> listOf5NearestTaxi = get5NearestTaxi(distanceList, mapOfNearestTaxi);
		return listOf5NearestTaxi;
	}

	public List<TaxiDetailPOJO> get5NearestTaxi(List<Double> distanceList,
			Map<Double, TaxiDetailPOJO> mapOfNearestTaxi) {
		Collections.sort(distanceList);
		List<TaxiDetailPOJO> listOf5NearestTaxi = new ArrayList<>();
		if (distanceList.size() >= 5) {
			for (int i = 0; i < 5; i++) {
				mapOfNearestTaxi.get(distanceList.get(i)).setDistance(distanceList.get(i));
				listOf5NearestTaxi.add(mapOfNearestTaxi.get(distanceList.get(i)));
			}
		} else {
			for (int i = 0; i < distanceList.size(); i++) {
				mapOfNearestTaxi.get(distanceList.get(i)).setDistance(distanceList.get(i));
				listOf5NearestTaxi.add(mapOfNearestTaxi.get(distanceList.get(i)));
			}
		}
		return listOf5NearestTaxi;
	}

	public Double pitagor(Double latitude, Double longitide) {
		Double distance = Math.sqrt((latitude * latitude) + (latitude * latitude));
		return distance;
	}
}
