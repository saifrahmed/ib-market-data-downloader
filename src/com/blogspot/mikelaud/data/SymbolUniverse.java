package com.blogspot.mikelaud.data;

import com.blogspot.mikelaud.symbol.Symbol;

public enum SymbolUniverse {

	INDICES(UniverseIndices.class, "Indices"),
	DOW_JONES(UniverseDowJones.class, "Dow Jones"), // has priority over SP500
	SP500(UniverseSp500.class, "S&P 500"),
	SP400(UniverseSp400.class, "S&P 400");
	
	private Class<? extends Enum<?>> mUniverseClass;
	private String mDescription;
	
	private SymbolUniverse(Class<? extends Enum<?>>  aUniverseClass, String aDescription) {
		mUniverseClass = aUniverseClass;
		mDescription = aDescription;
	}

	public String getDescription() {
		return mDescription;
	}
	
	public Symbol[] getSymbols() {
		return (Symbol[]) mUniverseClass.getEnumConstants();
	}
	
	@Override
	public String toString() {
		return mDescription + " Universe";
	}
	
}
