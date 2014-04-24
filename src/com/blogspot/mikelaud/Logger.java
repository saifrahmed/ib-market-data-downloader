package com.blogspot.mikelaud;

public class Logger {

	public static void logError(final String aMessage) { System.out.println("ERROR: " + aMessage); }
	public static void logWarning(final String aMessage) { System.out.println("WARNING: " + aMessage); }
	public static void logInfo(final String aMessage) { System.out.println("INFO: " + aMessage); }
	public static void logDebug(final String aMessage) { System.out.println("DEBUG: " + aMessage); }
	//
	public static void print(final String aMessage) { System.out.print(aMessage); }
	public static void println(final String aMessage) { System.out.println(aMessage); }
	
}
