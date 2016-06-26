package com.pojo;

import lombok.Data;

public @Data class TaxiDetailPOJO {
	String taxiNumber;
	Double latitude;
	Double longitude;
	Boolean flag_pink;
	Boolean flag_occupied;
	Double distance;

	public String getTaxiNumber() {
		return taxiNumber;
	}

	public void setTaxiNumber(String taxiNumber) {
		this.taxiNumber = taxiNumber;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Boolean getFlag_pink() {
		return flag_pink;
	}

	public void setFlag_pink(Boolean flag_pink) {
		this.flag_pink = flag_pink;
	}

	public Boolean getFlag_occupied() {
		return flag_occupied;
	}

	public void setFlag_occupied(Boolean flag_occupied) {
		this.flag_occupied = flag_occupied;
	}

	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}

	@Override
	public String toString() {
		return "TaxiDetailPOJO [taxiNumber=" + taxiNumber + ", latitude=" + latitude + ", longitude=" + longitude
				+ ", flag_pink=" + flag_pink + ", flag_occupied=" + flag_occupied + ", distance=" + distance + "]";
	}

}
