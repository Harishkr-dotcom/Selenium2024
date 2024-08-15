package com.qa.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class Constants {
	public static final String CONFIGPATH = System.getProperty("user.dir")+"\\src\\main\\resources\\Config.properties";
	public static final String TESTDATA_DIR = System.getProperty("user.dir")+"\\src\\main\\resources\\TestData.xlsx";
	public static  int EXPLICIT_WAIT = 10;
	public static final String REPORTDIR = System.getProperty("user.dir")+"\\target\\Reports\\CRMApp\\"+getDateTimeString()+"";

	public static String getDateTimeString(){
	DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
	Date d = new Date();
	return dateFormat.format(d);	
	}

	public static String getDateTimeStringWithMiliSeconds(){
	DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss_sss");
	Date d = new Date();
	return dateFormat.format(d);	
	}
}
