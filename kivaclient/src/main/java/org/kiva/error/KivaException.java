package org.kiva.error;

public class KivaException extends Exception {
	public KivaException(String message, Exception e){
		super(message,e);
	}
}
