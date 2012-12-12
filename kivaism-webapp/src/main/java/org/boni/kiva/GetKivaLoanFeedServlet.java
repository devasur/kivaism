package org.boni.kiva;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kiva.domain.NewestLoan;
import org.kiva.service.ApiLevel;
import org.kiva.service.KivaClient;
import org.kiva.service.impl.KivaClientFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("serial")
public class GetKivaLoanFeedServlet extends HttpServlet {
	
	private static final Logger logger = LoggerFactory.getLogger(GetKivaLoanFeedServlet.class);
	
	private KivaClient client = KivaClientFactory.getKivaClient(ApiLevel.V1);
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		List<NewestLoan> loans = client.getNewestLoans();
		PrintWriter out = resp.getWriter();
		for (NewestLoan aLoan : loans){
			out.println("<p>");
			out.println("Borrower:" + aLoan.getName() + " to do " + aLoan.getActivity() + " Requesting :" + aLoan.getLoanAmount());
			out.println("</p>");
		}
	}
		
}
