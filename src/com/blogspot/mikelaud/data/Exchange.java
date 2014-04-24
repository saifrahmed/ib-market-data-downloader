package com.blogspot.mikelaud.data;

public enum Exchange {
	
	ARCA("ARCA", "NYSE Arca (ETFs & stocks)"),
	NASDAQ("NASDAQ", "National Association of Securities Dealers Automated Quotations"),
	NYSE("NYSE", "New York Stock Exchange"),
	PSE("PSE", "NYSE Arca (indices and options)"),
	SMART("SMART", "SMART Exchange");
	
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
