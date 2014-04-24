package com.blogspot.mikelaud.symbol;

import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import com.blogspot.mikelaud.data.SymbolUniverse;

public class Symbols {

	private Symbol[] mSymbols;
	private int mSymbolMaxSize = 0;
	
	private int calcSymbolMaxSize(Symbol[] aSymbols) {
		int symbolMaxSize = 0;
		for (Symbol symbol : aSymbols) {
			int symbolSize = symbol.getName().length(); 
			if (symbolSize > symbolMaxSize) {
				symbolMaxSize = symbolSize; 
			}
		}
		return symbolMaxSize;
	}
	
	public Symbol[] getArray() {
		return mSymbols;
	}

	public int getCount() {
		return mSymbols.length;
	}
	
	public int getSymbolMaxSize() {
		return mSymbolMaxSize;
	}
	
	public Symbols() {
		SymbolComparator symbolComparator = new SymbolComparator();
		SortedSet<Symbol> symbolsSet = new TreeSet<Symbol>(symbolComparator);
		Set<String> namesSet = new HashSet<String>();
		//
		for (SymbolUniverse universe: SymbolUniverse.values()) {
			for (Symbol symbol : universe.getSymbols()) {
				if (namesSet.add(symbol.getName())) {
					symbolsSet.add(symbol);
				}
			}
		}
		int symbolsCount = symbolsSet.size();
		mSymbols = symbolsSet.toArray(new Symbol[symbolsCount]);
		mSymbolMaxSize = calcSymbolMaxSize(mSymbols);
	}
	
}
