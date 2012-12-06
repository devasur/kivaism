package org.boni.kiva.client;

import static org.junit.Assert.*;

import org.junit.Test;
import org.kiva.domain.Loan;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class TestKivaJsonXmls {
	@Test
	public void testGetLoanJsonParsing() throws Exception{
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode root = (ObjectNode )mapper.readTree(Thread.currentThread().getContextClassLoader().getResourceAsStream("loan_50422.json"));
		ArrayNode loans = (ArrayNode)root.get("loans");
		Loan loan = mapper.readValue(loans.get(0).toString(), Loan.class);
		assertTrue(loan.getLoanTerms().getScheduledPayments().get(2).getAmount()==68.75f);
	}
}
