package org.kiva.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Geo{
	String level;
	String latLongPair;
	String type;
	@JsonProperty("level")
	public String getLevel() {
		return level;
	}
	@JsonProperty("pairs")
	public String getLatLongPair() {
		return latLongPair;
	}
	@JsonProperty("type")
	public String getType() {
		return type;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public void setLatLongPair(String latLongPair) {
		this.latLongPair = latLongPair;
	}
	public void setType(String type) {
		this.type = type;
	}
}