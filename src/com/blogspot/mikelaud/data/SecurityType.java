package com.blogspot.mikelaud.data;

public enum SecurityType {

	IND("IND", "index"),
	STK("STK", "stock");
	
	private String mName;
	private String mDescription;
	
	private SecurityType(String aName, String aDescription) {
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
