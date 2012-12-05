package org.kiva.service.impl;

import java.util.List;

import org.kiva.domain.JournalEntry;
import org.kiva.domain.Lender;
import org.kiva.domain.Loan;
import org.kiva.domain.LoanUpdate;
import org.kiva.domain.SearchParameters;
import org.kiva.service.ApiLevel;
import org.kiva.service.KivaClient;

public class KivaClientFactory {
	public static KivaClient getKivaClient(ApiLevel apiLevel) throws UnSupportedAPilevelException{
		if (apiLevel == ApiLevel.V1)
			return new KivaClientV1();
		throw new UnSupportedAPilevelException();
	}
}

class KivaClientV1 implements KivaClient{

	public List<Loan> getLoans(String[] loanIds) {
		// TODO Auto-generated method stub
		return null;
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

	public List<Loan> getNewestLoans() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Loan> searchLoans(SearchParameters parameters) {
		// TODO Auto-generated method stub
		return null;
	}
	
}