package org.kiva.domain;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Loan {
	private String id;
	private String name;
	private Description description;
	private String status;
	private int fundedAmount;
	private int paidAmount;
	private Image image;
	private String activity;
	private String sector;
	private String use;
	private Location location;
	private String partnerId;
	private Date postedDate;
	private int loanAmount;
	private List<Borrower> borrowers;
	private LoanTerms loanTerms;
	private List<Payment> payments;
	private Date fundedDate;
	private Date paidDate;
	private JournalTotals journalTotals;
	@JsonProperty("id")
	public String getId() {
		return id;
	}
	@JsonProperty("name")
	public String getName() {
		return name;
	}
	@JsonProperty("description")
	public Description getDescription() {
		return description;
	}
	@JsonProperty("status")
	public String getStatus() {
		return status;
	}
	@JsonProperty("funded_amount")
	public int getFundedAmount() {
		return fundedAmount;
	}
	@JsonProperty("paid_amount")
	public int getPaidAmount() {
		return paidAmount;
	}
	@JsonProperty("image")
	public Image getImage() {
		return image;
	}
	@JsonProperty("activity")
	public String getActivity() {
		return activity;
	}
	@JsonProperty("sector")
	public String getSector() {
		return sector;
	}
	@JsonProperty("use")
	public String getUse() {
		return use;
	}
	@JsonProperty("location")
	public Location getLocation() {
		return location;
	}
	@JsonProperty("partner_id")
	public String getPartnerId() {
		return partnerId;
	}
	@JsonProperty("posted_date")
	public Date getPostedDate() {
		return postedDate;
	}
	@JsonProperty("loan_amount")
	public int getLoanAmount() {
		return loanAmount;
	}
	@JsonProperty("borrowers")
	public List<Borrower> getBorrowers() {
		return borrowers;
	}
	@JsonProperty("terms")
	public LoanTerms getLoanTerms() {
		return loanTerms;
	}
	@JsonProperty("payments")
	public List<Payment> getPayments() {
		return payments;
	}
	@JsonProperty("funded_date")
	public Date getFundedDate() {
		return fundedDate;
	}
	@JsonProperty("paid_date")
	public Date getPaidDate() {
		return paidDate;
	}
	@JsonProperty("journal_totals")
	public JournalTotals getJournalTotals() {
		return journalTotals;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setDescription(Description description) {
		this.description = description;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setFundedAmount(int fundedAmount) {
		this.fundedAmount = fundedAmount;
	}
	public void setPaidAmount(int paidAmount) {
		this.paidAmount = paidAmount;
	}
	public void setImage(Image image) {
		this.image = image;
	}
	public void setActivity(String activity) {
		this.activity = activity;
	}
	public void setSector(String sector) {
		this.sector = sector;
	}
	public void setUse(String use) {
		this.use = use;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public void setPartnerId(String partnerId) {
		this.partnerId = partnerId;
	}
	public void setPostedDate(Date postedDate) {
		this.postedDate = postedDate;
	}
	public void setLoanAmount(int loanAmount) {
		this.loanAmount = loanAmount;
	}
	public void setBorrowers(List<Borrower> borrowers) {
		this.borrowers = borrowers;
	}
	public void setLoanTerms(LoanTerms loanTerms) {
		this.loanTerms = loanTerms;
	}
	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}
	public void setFundedDate(Date fundedDate) {
		this.fundedDate = fundedDate;
	}
	public void setPaidDate(Date paidDate) {
		this.paidDate = paidDate;
	}
	public void setJournalTotals(JournalTotals journalTotals) {
		this.journalTotals = journalTotals;
	}
}