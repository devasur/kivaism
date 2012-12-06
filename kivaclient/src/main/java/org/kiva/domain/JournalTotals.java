package org.kiva.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JournalTotals{
	@JsonProperty("entries")
	public int getEntries() {
		return entries;
	}
	@JsonProperty("bulkEntries")
	public int getBulkEntries() {
		return bulkEntries;
	}
	public void setEntries(int entries) {
		this.entries = entries;
	}
	public void setBulkEntries(int bulkEntries) {
		this.bulkEntries = bulkEntries;
	}
	int entries;
	int bulkEntries;
}