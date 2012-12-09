package org.kiva.service;

public interface Kiva {
	public static String GET_LOANS_FOR_IDS = "http://api.kivaws.org/v1/loans/{ids}.json";
	public static final String GET_NEWEST_LOANS = "http://api.kivaws.org/v1/loans/newest.json?page=1";
}
