package org.kiva.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Borrower {
	String firstName;
	String lastName;
	String gender;
	boolean pictured;
	@JsonProperty("first_name")
	public String getFirstName() {
		return firstName;
	}
	@JsonProperty("last_name")
	public String getLastName() {
		return lastName;
	}
	@JsonProperty("gender")
	public String getGender() {
		return gender;
	}
	@JsonProperty("pictured")
	public boolean isPictured() {
		return pictured;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public void setPictured(boolean pictured) {
		this.pictured = pictured;
	}
}
