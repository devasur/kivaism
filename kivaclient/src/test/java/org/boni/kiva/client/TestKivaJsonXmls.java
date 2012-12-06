package org.boni.kiva.client;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.kiva.domain.Borrower;
import org.kiva.domain.Loan;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class TestKivaJsonXmls {
	private static final Log logger = LogFactory.getLog(TestKivaJsonXmls.class);
	@Test
	public void testGetLoanJsonParsing() throws Exception{
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode root = (ObjectNode )mapper.readTree(Thread.currentThread().getContextClassLoader().getResourceAsStream("loan_50422.json"));
		ArrayNode loans = (ArrayNode)root.get("loans");
		Loan loan = mapper.readValue(loans.get(0).toString(), Loan.class);
		assertTrue(loan.getLoanTerms().getScheduledPayments().get(2).getAmount()==68.75f);
	}
	
	@Test
	public void testGetLoanFromRestAPI() throws Exception{
		final String KIVA_GET_LOAN_API = "http://api.kivaws.org/v1/loans/2930.json";
		RestTemplate rt = new RestTemplate();
		String loans = rt.getForObject(KIVA_GET_LOAN_API, String.class);
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode root = (ObjectNode )mapper.readTree(loans);
		ArrayNode loansArray = (ArrayNode)root.get("loans");
		Loan loan = mapper.readValue(loansArray.get(0).toString(), Loan.class);
		Borrower b = null;
		assertNotNull(b = loan.getBorrowers().get(0));
		logger.info("Borrower:" + b.getFirstName() + " " + b.getLastName());
	}
}
