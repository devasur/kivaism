package org.kiva.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LossLiability{
	String nonPaymentLiability;
	String currencyExchangeLossLiability;
	@JsonProperty("nonpayment")
	public String getNonPaymentLiability() {
		return nonPaymentLiability;
	}
	@JsonProperty("currency_exchange")
	public String getCurrencyExchangeLossLiability() {
		return currencyExchangeLossLiability;
	}
	public void setNonPaymentLiability(String nonPaymentLiability) {
		this.nonPaymentLiability = nonPaymentLiability;
	}
	public void setCurrencyExchangeLossLiability(
			String currencyExchangeLossLiability) {
		this.currencyExchangeLossLiability = currencyExchangeLossLiability;
	}
}