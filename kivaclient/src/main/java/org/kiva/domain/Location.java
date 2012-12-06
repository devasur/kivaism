package org.kiva.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Location {
	String countryCode;
	String country;
	String town;
	Geo geo;
	@JsonProperty("geo")
	public Geo getGeo() {
		return geo;
	}
	public void setGeo(Geo geo) {
		this.geo = geo;
	}
	@JsonProperty("country_code")
	public String getCountryCode() {
		return countryCode;
	}
	@JsonProperty("country")
	public String getCountry() {
		return country;
	}
	@JsonProperty("town")
	public String getTown() {
		return town;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public void setTown(String town) {
		this.town = town;
	}
}
