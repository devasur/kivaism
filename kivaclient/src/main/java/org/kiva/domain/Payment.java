package org.kiva.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Payment{
	float amount;
	float localAmount;
	Date processedDate;
	Date settlementDate;
	float roundedLocalAmount;
	float currencyExchangeLossAmount;
	String paymentId;
	String comment;
	@JsonProperty("amount")
	public float getAmount() {
		return amount;
	}
	@JsonProperty("local_amount")
	public float getLocalAmount() {
		return localAmount;
	}
	@JsonProperty("processed_date")
	public Date getProcessedDate() {
		return processedDate;
	}
	@JsonProperty("settlement_date")
	public Date getSettlementDate() {
		return settlementDate;
	}
	@JsonProperty("rounded_local_amount")
	public float getRoundedLocalAmount() {
		return roundedLocalAmount;
	}
	@JsonProperty("currency_exchange_loss_amount")
	public float getCurrencyExchangeLossAmount() {
		return currencyExchangeLossAmount;
	}
	@JsonProperty("payment_id")
	public String getPaymentId() {
		return paymentId;
	}
	@JsonProperty("comment")
	public String getComment() {
		return comment;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public void setLocalAmount(float localAmount) {
		this.localAmount = localAmount;
	}
	public void setProcessedDate(Date processedDate) {
		this.processedDate = processedDate;
	}
	public void setSettlementDate(Date settlementDate) {
		this.settlementDate = settlementDate;
	}
	public void setRoundedLocalAmount(float roundedLocalAmount) {
		this.roundedLocalAmount = roundedLocalAmount;
	}
	public void setCurrencyExchangeLossAmount(float currencyExchangeLossAmount) {
		this.currencyExchangeLossAmount = currencyExchangeLossAmount;
	}
	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
}