package org.boni.kiva.client;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.kiva.domain.Borrower;
import org.kiva.domain.Loan;
import org.kiva.domain.NewestLoan;
import org.kiva.service.ApiLevel;
import org.kiva.service.KivaClient;
import org.kiva.service.impl.KivaClientFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestKivaClientDefaultImpl {

	private static final Logger logger = LoggerFactory.getLogger(TestKivaClientDefaultImpl.class);
	static KivaClient client = null;
	
	@BeforeClass
	public static void setup() throws Exception{
		client = KivaClientFactory.getKivaClient(ApiLevel.V1);
	}
	
	@Test
	public void testGetNewestLoans(){
		List<NewestLoan> loans = client.getNewestLoans();
		for (NewestLoan aLoan : loans){
			logger.info("Borrower:" + aLoan.getName());
		}
	}
	
	@Test
	public void testGetLoansForMultipleIds() throws Exception{
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
		List<Loan> loandThroughClientApi = client.getLoans(ids);
		for (Loan aLoan : loandThroughClientApi){
			Borrower b = null;
			assertNotNull(b = aLoan.getBorrowers().get(0));
			logger.info("Borrower:" + b.getFirstName() + " " + b.getLastName());
		}
		
		//One Loan
		loandThroughClientApi = client.getLoans(
				new ArrayList<String>(){
					{
						add("2933");
					}
				}
		);
		assertTrue(loandThroughClientApi.size() == 1);
		for (Loan aLoan : loandThroughClientApi){
			Borrower b = null;
			assertNotNull(b = aLoan.getBorrowers().get(0));
			logger.info("Borrower:" + b.getFirstName() + " " + b.getLastName());
		}		

		//Empty parameter List : Should not Crap
		loandThroughClientApi = client.getLoans(
				new ArrayList<String>(){
					{
					}
				}
		);
		assertTrue(loandThroughClientApi.size() == 0);
		for (Loan aLoan : loandThroughClientApi){
			Borrower b = null;
			assertNotNull(b = aLoan.getBorrowers().get(0));
			logger.info("Borrower:" + b.getFirstName() + " " + b.getLastName());
		}		

		//Exactly 10 ids : The split limit.
		loandThroughClientApi = client.getLoans(
				new ArrayList<String>(){
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
						
					}
				}
		);
		assertTrue(loandThroughClientApi.size() == 10);
		for (Loan aLoan : loandThroughClientApi){
			Borrower b = null;
			assertNotNull(b = aLoan.getBorrowers().get(0));
			logger.info("Borrower:" + b.getFirstName() + " " + b.getLastName());
		}		

		//11 ids, 10 + 1.
		loandThroughClientApi = client.getLoans(
				new ArrayList<String>(){
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
						
					}
				}
		);
		assertTrue(loandThroughClientApi.size() == 11);
		for (Loan aLoan : loandThroughClientApi){
			Borrower b = null;
			assertNotNull(b = aLoan.getBorrowers().get(0));
			logger.info("Borrower:" + b.getFirstName() + " " + b.getLastName());
		}		
		
	}
	
	@Test
	public void testGetLoan() throws Exception{
		Loan aLoan = client.getLoan("2930");
		assertNotNull(aLoan);
		Loan fictionalLoan = client.getLoan("FICTIONAL_LOAN_ID");
		assertNull(fictionalLoan);
	}
	
	
}
