package com.blogspot.mikelaud.data;

import com.blogspot.mikelaud.symbol.Symbol;

public enum UniverseIndices implements Symbol {
	
	COMP("COMP", Exchange.NASDAQ, "NASDAQ Composite Index"),
	INDU("INDU", Exchange.NYSE, "Dow Jones Industrial Average"),
	MID("MID", Exchange.PSE, "S&P Midcap 400 Stock Index"),
	NDX("NDX", Exchange.NASDAQ, "NASDAQ 100 Stock Index"),
	SPSUPX("SPSUPX", Exchange.PSE, "S&P Composite 1500 Index");
	
	private String mName;
	private Exchange mExchange;
	private SecurityType mSecurityType;
	private String mDescription;
	
	private UniverseIndices(String aName, Exchange aExchange, String aDescription) {
		mName = aName;
		mExchange = aExchange;
		mSecurityType = SecurityType.IND;
		mDescription = aDescription;
	}

	@Override
	public SymbolUniverse getUniverse() {
		return SymbolUniverse.INDICES;
	}

	@Override
	public int getId() {
		return this.ordinal();
	}
	
	@Override
	public String getName() {
		return mName;
	}
	
	@Override
	public Exchange getExchange() {
		return mExchange;
	}

	@Override
	public SecurityType getSecurityType() {
		return mSecurityType;
	}

	public String getDescription() {
		return mDescription;
	}
	
	@Override
	public String toString() {
		return mName;
	}

}
