package com.blogspot.mikelaud.data;

public enum Exchange {
	
	SMART("SMART", "SMART Exchange"),
	NASDAQ("NASDAQ", "National Association of Securities Dealers Automated Quotations"),
	NYSE("NYSE", "New York Stock Exchange"),
	PSE("PSE", "NYSE Arca");
	
	private String mName;
	private String mDescription;
	
	private Exchange(String aName, String aDescription) {
		mName = aName;
		mDescription = aDescription;
	}
	
	public String getName() {
		return mName;
	}
	
	public String getDescription() {
		return mDescription;
	}
	
	@Override
	public String toString() {
		return mName;
	}

}
