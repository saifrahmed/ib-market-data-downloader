package com.blogspot.mikelaud.data;

import com.blogspot.mikelaud.symbol.Symbol;

public enum UniverseDowJones implements Symbol {

	AXP(UniverseSp500.AXP),
	BA(UniverseSp500.BA),
	CAT(UniverseSp500.CAT),
	CSCO(UniverseSp500.CSCO),
	CVX(UniverseSp500.CVX),
	DD(UniverseSp500.DD),
	DIS(UniverseSp500.DIS),
	GE(UniverseSp500.GE),
	GS(UniverseSp500.GS),
	HD(UniverseSp500.HD),
	IBM(UniverseSp500.IBM),
	INTC(UniverseSp500.INTC),
	JNJ(UniverseSp500.JNJ),
	JPM(UniverseSp500.JPM),
	KO(UniverseSp500.KO),
	MCD(UniverseSp500.MCD),
	MMM(UniverseSp500.MMM),
	MRK(UniverseSp500.MRK),
	MSFT(UniverseSp500.MSFT),
	NKE(UniverseSp500.NKE),
	PFE(UniverseSp500.PFE),
	PG(UniverseSp500.PG),
	T(UniverseSp500.T),
	TRV(UniverseSp500.TRV),
	UNH(UniverseSp500.UNH),
	UTX(UniverseSp500.UTX),
	V(UniverseSp500.V),
	VZ(UniverseSp500.VZ),
	WMT(UniverseSp500.WMT),
	XOM(UniverseSp500.XOM);

	private UniverseSp500 mSymbol;
	
	private UniverseDowJones(UniverseSp500 aSymbol) {
		mSymbol = aSymbol;
	}
	
	public UniverseSp500 get() {
		return mSymbol;
	}

	@Override
	public SymbolUniverse getUniverse() {
		return SymbolUniverse.DOW_JONES;
	}

	@Override
	public int getId() {
		return this.ordinal();
	}
	
	@Override
	public String getName() {
		return mSymbol.getName();
	}
	
	@Override
	public Exchange getExchange() {
		return mSymbol.getExchange();
	}

	@Override
	public SecurityType getSecurityType() {
		return mSymbol.getSecurityType();
	}
	
	@Override
	public String toString() {
		return mSymbol.toString();
	}
	
}
