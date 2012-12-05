package org.kiva.service;

import java.util.List;

import org.kiva.domain.JournalEntry;
import org.kiva.domain.Lender;
import org.kiva.domain.Loan;
import org.kiva.domain.LoanUpdate;
import org.kiva.domain.SearchParameters;

public interface KivaClient {
	public List<Loan> getLoans(String[] loanIds);
	public List<JournalEntry> getJournalEntriesForLoan(String loanId);
	public List<Lender> getLendersForLoan(String loanId);
	public List<LoanUpdate> getLoanUpdates(String loanId);
	public List<Loan> getNewestLoans();
	public List<Loan> searchLoans(SearchParameters parameters);
}
