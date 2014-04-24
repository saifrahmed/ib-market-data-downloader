package com.blogspot.mikelaud.data;

import com.blogspot.mikelaud.symbol.Symbol;

public enum UniverseMisc implements Symbol {
	
	GDX("GDX", Exchange.ARCA),
	GLD("GLD", Exchange.ARCA),
	SPY("SPY", Exchange.ARCA);
		
	private String mName;
	private Exchange mExchange;
	private SecurityType mSecurityType;
	
	private UniverseMisc(String aName, Exchange aExchange) {
		mName = aName;
		mExchange = aExchange;
		mSecurityType = SecurityType.STK;
	}
	
	@Override
	public SymbolUniverse getUniverse() {
		return SymbolUniverse.MISC;
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
	
	@Override
	public String toString() {
		return mName;
	}

}
