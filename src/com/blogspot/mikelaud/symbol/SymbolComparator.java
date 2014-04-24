package com.blogspot.mikelaud.symbol;

import java.util.Comparator;

public class SymbolComparator implements Comparator<Symbol> {

	private String nvl(String aName) {
		return (null == aName ? "" : aName); 
	}
	
	@Override
	public int compare(Symbol aFirst, Symbol aSecond) {
		String name1 = nvl(aFirst.getName());
		String name2 = nvl(aSecond.getName());
		//
		int nameCmp = name1.compareTo(name2);
		int universeCmp = aFirst.getUniverse().compareTo(aSecond.getUniverse());
		//
		if (0 == universeCmp) {
			return nameCmp;
		}
		else {
			return universeCmp;
		}
	}
	
}
