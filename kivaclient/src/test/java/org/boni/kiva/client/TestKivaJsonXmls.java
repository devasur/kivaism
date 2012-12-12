package org.boni.kiva.client;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.kiva.domain.Borrower;
import org.kiva.domain.Loan;
import org.kiva.service.ApiLevel;
import org.kiva.service.Kiva;
import org.kiva.service.KivaClient;
import org.kiva.service.impl.KivaClientFactory;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.collect.Lists;

public class TestKivaJsonXmls {
	private static final Log logger = LogFactory.getLog(TestKivaJsonXmls.class);
	private static final ObjectMapper mapper = new ObjectMapper();;
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
		ObjectNode root = (ObjectNode )mapper.readTree(loans);
		ArrayNode loansArray = (ArrayNode)root.get("loans");
		Loan loan = mapper.readValue(loansArray.get(0).toString(), Loan.class);
		Borrower b = null;
		assertNotNull(b = loan.getBorrowers().get(0));
		logger.info("Borrower:" + b.getFirstName() + " " + b.getLastName());
	}
	
	@Test
	public void testRestfultemplateForMultipleIds() throws Exception{
		List<String> ids = new ArrayList<String>(){
			{	
				add("2930");
				add("2931");
				add("2932");
				add("2932");
				add("2932");
				add("2932");
				add("2930");
				add("2931");
				add("2932");
				add("2932");
				add("2932");
				add("2932");
				add("2930");
				add("2931");
				add("2932");
				add("2932");
			}
		};
		List<List<String>> partitionedIds = Lists.partition(ids, 10);
		for (List<String> onePartiiton : partitionedIds){
			String idsJoined = StringUtils.join(onePartiiton, ",");
			logger.info("IDS:" + idsJoined + " Chunk Size:" + onePartiiton.size());
			RestTemplate template = new RestTemplate();
			String content = template.getForObject(Kiva.GET_LOANS_FOR_IDS, String.class,idsJoined);
			JsonNode rootNode = mapper.readTree(content);
			ArrayNode loans = (ArrayNode)rootNode.get("loans");
			List<Loan> loansList = (List<Loan>)mapper.readValue(loans.toString(), new TypeReference<List<Loan>>(){});
			for (Loan aLoan : loansList){
				Borrower b = null;
				assertNotNull(b = aLoan.getBorrowers().get(0));
				//logger.info("Borrower:" + b.getFirstName() + " " + b.getLastName());
			}
		}
	}
}
