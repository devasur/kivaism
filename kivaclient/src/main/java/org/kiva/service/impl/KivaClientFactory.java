package org.kiva.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.kiva.domain.JournalEntry;
import org.kiva.domain.Lender;
import org.kiva.domain.Loan;
import org.kiva.domain.LoanUpdate;
import org.kiva.domain.NewestLoan;
import org.kiva.domain.SearchParameters;
import org.kiva.error.KivaException;
import org.kiva.service.ApiLevel;
import org.kiva.service.Kiva;
import org.kiva.service.KivaClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.collect.Lists;

public class KivaClientFactory {
	public static KivaClient getKivaClient(ApiLevel apiLevel){
		if (apiLevel == ApiLevel.V1)
			return new KivaClientV1();
		return null;
	}
}

class KivaClientV1 implements KivaClient{
	private static final Logger logger = LoggerFactory.getLogger(KivaClientV1.class);
	private static final ObjectMapper mapper = new ObjectMapper();
	public List<Loan> getLoans(List<String> ids) throws KivaException {
		List<Loan> returnValue = new ArrayList<Loan>();
		try {
			List<List<String>> partitionedIds = Lists.partition(ids, 10);
			for (List<String> onePartiiton : partitionedIds){
				String idsJoined = StringUtils.join(onePartiiton, ",");
				logger.debug("IDS:" + idsJoined + " Chunk Size:" + onePartiiton.size());
				RestTemplate template = new RestTemplate();
				String content = template.getForObject(Kiva.GET_LOANS_FOR_IDS, String.class,idsJoined);
				JsonNode rootNode = mapper.readTree(content);
				ArrayNode loans = (ArrayNode)rootNode.get("loans");
				List<Loan> loansList = (List<Loan>)mapper.readValue(loans.toString(), new TypeReference<List<Loan>>(){});
				returnValue.addAll(loansList);
			}
		} catch (Exception e) {
			throw new KivaException(e.getMessage(), e);
		}
		return returnValue;
	}

	public List<JournalEntry> getJournalEntriesForLoan(String loanId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Lender> getLendersForLoan(String loanId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<LoanUpdate> getLoanUpdates(String loanId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<NewestLoan> getNewestLoans() {
		logger.debug("Invoked:getNewestLoans()");
		try{
			RestTemplate template = new RestTemplate();
			String newestLoansContent = template.getForObject(Kiva.GET_NEWEST_LOANS, String.class);
			logger.debug(newestLoansContent);
			ObjectNode root = (ObjectNode )mapper.readTree(newestLoansContent);
			ArrayNode loansArray = (ArrayNode)root.get("loans");
			List<NewestLoan> loansList = (List<NewestLoan>)mapper.readValue(loansArray.toString(), new TypeReference<List<NewestLoan>>(){});
			return loansList;
		}
		catch(Exception e){
			logger.error(e.getMessage(), e);
		}
		return new ArrayList<NewestLoan>();
	}

	public List<Loan> searchLoans(SearchParameters parameters) {
		// TODO Auto-generated method stub
		return null;
	}
	
}