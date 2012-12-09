package org.kiva.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class NewestLoan {
	String id;
	String name;
	String status;
	float fundedAmount;
	float basketAmount;
	Image image;
	String activity;
	String use;
	Location location;
	String parterId;
	Date postedDate;
	Date plannedExpirationDate;
	float loanAmount;
	int borrowerCount;
	@JsonProperty("id")
	public String getId() {
		return id;
	}
	@JsonProperty("name")
	public String getName() {
		return name;
	}
	@JsonProperty("status")
	public String getStatus() {
		return status;
	}
	@JsonProperty("funded_amount")
	public float getFundedAmount() {
		return fundedAmount;
	}
	@JsonProperty("basket_amount")
	public float getBasketAmount() {
		return basketAmount;
	}
	@JsonProperty("image")
	public Image getImage() {
		return image;
	}
	@JsonProperty("activity")
	public String getActivity() {
		return activity;
	}
	@JsonProperty("use")
	public String getUse() {
		return use;
	}
	@JsonProperty("location")
	public Location getLocation() {
		return location;
	}
	@JsonProperty("partner_id")
	public String getParterId() {
		return parterId;
	}
	@JsonProperty("posted_date")
	public Date getPostedDate() {
		return postedDate;
	}
	@JsonProperty("planned_expiration_date")
	public Date getPlannedExpirationDate() {
		return plannedExpirationDate;
	}
	@JsonProperty("loan_amount")
	public float getLoanAmount() {
		return loanAmount;
	}
	@JsonProperty("borrower_count")
	public int getBorrowerCount() {
		return borrowerCount;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setFundedAmount(float fundedAmount) {
		this.fundedAmount = fundedAmount;
	}
	public void setBasketAmount(float basketAmount) {
		this.basketAmount = basketAmount;
	}
	public void setImage(Image image) {
		this.image = image;
	}
	public void setActivity(String activity) {
		this.activity = activity;
	}
	public void setUse(String use) {
		this.use = use;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public void setParterId(String parterId) {
		this.parterId = parterId;
	}
	public void setPostedDate(Date postedDate) {
		this.postedDate = postedDate;
	}
	public void setPlannedExpirationDate(Date plannedExpirationDate) {
		this.plannedExpirationDate = plannedExpirationDate;
	}
	public void setLoanAmount(float loanAmount) {
		this.loanAmount = loanAmount;
	}
	public void setBorrowerCount(int borrowerCount) {
		this.borrowerCount = borrowerCount;
	}
}
