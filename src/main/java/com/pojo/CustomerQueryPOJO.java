package com.pojo;

import lombok.Data;

public @Data class CustomerQueryPOJO {
	Double latitute;
	Double longitude;
	Boolean flagPinkTaxi;

	public Double getLatitute() {
		return latitute;
	}

	public void setLatitute(Double latitute) {
		this.latitute = latitute;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Boolean getFlagPinkTaxi() {
		return flagPinkTaxi;
	}

	public void setFlagPinkTaxi(Boolean flagPinkTaxi) {
		this.flagPinkTaxi = flagPinkTaxi;
	}

	@Override
	public String toString() {
		return "CustomerQueryPOJO [latitute=" + latitute + ", longitude=" + longitude + ", flagPinkTaxi=" + flagPinkTaxi
				+ "]";
	}

}
