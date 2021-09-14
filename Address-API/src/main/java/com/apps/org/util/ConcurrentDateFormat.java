package com.apps.org.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

public class ConcurrentDateFormat {

	private static String logdatePattern = "dd.MM.yyyy|HH:mm:ss|SSS";
	private static ThreadLocal<SimpleDateFormat> sdfLocal = new  ThreadLocal<SimpleDateFormat>() {
		
		@Override
		public SimpleDateFormat get() {
			return super.get();
		}
		
		@Override
		public SimpleDateFormat initialValue() {
			return new SimpleDateFormat(logdatePattern);
		}
		
		@Override
		public void remove() {
			super.remove();
		}
		
		@Override
		public void set(SimpleDateFormat simpleDateFormat) {
			super.set(simpleDateFormat);
		}
	};
	
	public static SimpleDateFormat getThreadLocalSimpleDateFormat(String logdatePattern) {
		ConcurrentDateFormat.logdatePattern =
				(StringUtils.isNotBlank(logdatePattern)
						? logdatePattern : ConcurrentDateFormat.logdatePattern);
		SimpleDateFormat sdf = sdfLocal.get(); 
		if(null == sdf) {
			sdf = new SimpleDateFormat(ConcurrentDateFormat.logdatePattern);
			sdfLocal.set(sdf);
		}
		sdfLocal.get().applyPattern(ConcurrentDateFormat.logdatePattern);
		return sdfLocal.get();
	}
	
	public static Date convertStringToDate (String dateString) {
		Date utilDate = null;
		try {
			utilDate = sdfLocal.get().parse(dateString);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return utilDate;
	}

}
