package org.boni.kiva.client;

import static org.junit.Assert.assertTrue;

import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.kiva.domain.NewestLoan;
import org.kiva.service.ApiLevel;
import org.kiva.service.KivaClient;
import org.kiva.service.impl.KivaClientFactory;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class TestKivaJsonXmlsGetNewestLoans {
	private static final Log logger = LogFactory.getLog(TestKivaJsonXmlsGetNewestLoans.class);
	private static final ObjectMapper mapper = new ObjectMapper();
	KivaClient client = KivaClientFactory.getKivaClient(ApiLevel.V1);
	@Test
	public void testGetLoanJsonParsing() throws Exception{
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode root = (ObjectNode )mapper.readTree(Thread.currentThread().getContextClassLoader().getResourceAsStream("newest_loans.json"));
		ArrayNode loans = (ArrayNode)root.get("loans");
		NewestLoan loan = mapper.readValue(loans.get(0).toString(), NewestLoan.class);
		assertTrue(loan.getLoanAmount() == 375f);
	}
	
	@Test
	public void testGetNewestLoansFromRestAPI() throws Exception{
		final String KIVA_GET_NEWEST_LOAN_API = "http://api.kivaws.org/v1/loans/newest.json?page=1";
		RestTemplate rt = new RestTemplate();
		String loans = rt.getForObject(KIVA_GET_NEWEST_LOAN_API, String.class);
		ObjectNode root = (ObjectNode )mapper.readTree(loans);
		ArrayNode loansArray = (ArrayNode)root.get("loans");
		Iterator<JsonNode> loanIterator = loansArray.iterator();
		while (loanIterator.hasNext()){
			NewestLoan loan = mapper.readValue(loanIterator.next().toString(), NewestLoan.class);
			logger.info("Borrower:" + loan.getName());
		}
	}
	
	@Test
	public void testKivaClient(){
		List<NewestLoan> loans = client.getNewestLoans();
		for (NewestLoan aLoan : loans){
			logger.info("Borrower:" + aLoan.getName());
		}
	}
	
}
