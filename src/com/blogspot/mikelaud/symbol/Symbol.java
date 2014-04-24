package com.blogspot.mikelaud.symbol;

import com.blogspot.mikelaud.data.Exchange;
import com.blogspot.mikelaud.data.SecurityType;
import com.blogspot.mikelaud.data.SymbolUniverse;

public interface Symbol {

	SymbolUniverse getUniverse();
	int getId();
	String getName();
	Exchange getExchange();
	SecurityType getSecurityType();
	
}
