package com.apps.org.util;

public class CommonUtils {

	public static String cleanUpCommas(String string) {

		return string.replaceAll(", $", ".");
	}
	
	public static boolean isYOrN(String value) {

		boolean isYOrN = false;
		if (AppConstants.Y.stringValue.equalsIgnoreCase(value) 
				|| AppConstants.N.stringValue.equalsIgnoreCase(value)) {
			isYOrN = true;
		}
		return isYOrN;
	}

}
