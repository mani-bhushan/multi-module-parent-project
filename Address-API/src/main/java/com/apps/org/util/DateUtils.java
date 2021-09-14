package com.apps.org.util;

import java.util.Date;

public class DateUtils {
	
//	private static SimpleDateFormat logDateFormat;
//	private static Date logDate;
//	private String logdatePattern = "dd.MM.yyyy|HH:mm:ss|SSS";
	
	public static Date convertStringToUtilDate (String dateString) {
		/*
		 * logDateFormat=
		 * ConcurrentDateFormat.getThreadLocalSimpleDateFormat("dd.MM.yyyy|HH:mm:ss|SSS"
		 * ); logDate = logDateFormat.parse("24.4.2021|21:21:21|000Z");
		 */
		Date utilDate = ConcurrentDateFormat.convertStringToDate(dateString);
		return utilDate;
	}

	public static String convertUtilDateToString (Date date){
		return date.toString();
	}

	

}
