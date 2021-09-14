package com.apps.org.util;


public enum AppConstants {

	Y ("Y"),
	N ("N"),
	ONE (1);

	public final String stringValue;
	
	public final Integer integerValue;
	
	private AppConstants(String stringValue) {
        this.stringValue = stringValue;
		this.integerValue = null;
    }
	
	private AppConstants(Integer integerValue) {
        this.stringValue = String.valueOf(integerValue);
		this.integerValue = integerValue;
    }
	
}
