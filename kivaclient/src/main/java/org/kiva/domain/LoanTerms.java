package org.kiva.domain;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LoanTerms{
	Date disbursalDate;
	String disbursalCurrency;
	int disbursalAmount;
	int loanAmount;
	List<PlannedPayment> localPayments;
	List<PlannedPayment> scheduledPayments;
	LossLiability lossLiability;
	@JsonProperty("disbursal_date")
	public Date getDisbursalDate() {
		return disbursalDate;
	}
	@JsonProperty("disbursal_currency")
	public String getDisbursalCurrency() {
		return disbursalCurrency;
	}
	@JsonProperty("disbursal_amount")
	public int getDisbursalAmount() {
		return disbursalAmount;
	}
	@JsonProperty("loan_amount")
	public int getLoanAmount() {
		return loanAmount;
	}
	@JsonProperty("local_payments")
	public List<PlannedPayment> getLocalPayments() {
		return localPayments;
	}
	@JsonProperty("scheduled_payments")
	public List<PlannedPayment> getScheduledPayments() {
		return scheduledPayments;
	}
	@JsonProperty("loss_liability")
	public LossLiability getLossLiability() {
		return lossLiability;
	}
	public void setDisbursalDate(Date disbursalDate) {
		this.disbursalDate = disbursalDate;
	}
	public void setDisbursalCurrency(String disbursalCurrency) {
		this.disbursalCurrency = disbursalCurrency;
	}
	public void setDisbursalAmount(int disbursalAmount) {
		this.disbursalAmount = disbursalAmount;
	}
	public void setLoanAmount(int loanAmount) {
		this.loanAmount = loanAmount;
	}
	public void setLocalPayments(List<PlannedPayment> localPayments) {
		this.localPayments = localPayments;
	}
	public void setScheduledPayments(List<PlannedPayment> scheduledPayments) {
		this.scheduledPayments = scheduledPayments;
	}
	public void setLossLiability(LossLiability lossLiability) {
		this.lossLiability = lossLiability;
	} 
	
}