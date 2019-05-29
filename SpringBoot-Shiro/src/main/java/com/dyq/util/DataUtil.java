package com.dyq.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DataUtil {

	private SimpleDateFormat sdf;
	
	public String DateToStr(Date date, String pattern) {
		sdf = new SimpleDateFormat(pattern);
		return sdf.format(date);
	}
	
	public Date StrToDate(String pattern, String dateStr) throws ParseException{
		sdf = new SimpleDateFormat(pattern);
		return sdf.parse(dateStr);
	}
	
}
