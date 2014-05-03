package com.blogspot.mikelaud;

public class Settings {

	private static final int REQUEST_PERIOD_SEC = 11; 
	private static final String HOST = "";
	private static final int PORT = 7496;
	private static final int CLIENT_ID = 0; 
	private static final String FILE_NAME = "data.nyse"; 
	
	public static int getRequestPeriodSec() {
		return REQUEST_PERIOD_SEC;
	}
	
	public static String getHost() {
		return HOST;
	}
	
	public static int getPort() {
		return PORT;
	}
	
	public static int getClientId() {
		return CLIENT_ID;
	}
	
	public static String getFileName() {
		return FILE_NAME;
	}
	
}
