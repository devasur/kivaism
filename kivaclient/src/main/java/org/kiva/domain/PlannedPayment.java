package org.kiva.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PlannedPayment{
	Date dueDate;
	float amount;
	@JsonProperty("due_date")
	public Date getDueDate() {
		return dueDate;
	}
	@JsonProperty("amount")
	public float getAmount() {
		return amount;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
}