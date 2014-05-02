package com.blogspot.mikelaud;

import java.util.ArrayList;

import com.blogspot.mikelaud.ib.Connection;
import com.blogspot.mikelaud.symbol.Symbol;
import com.blogspot.mikelaud.symbol.Symbols;

public class Program implements Runnable {

	private Connection mConnection = new Connection();
	private ArrayList<Symbol> mFailedSymbols = new ArrayList<Symbol>();
	
	private String getBeginFormat(int aSymbolMaxSize) {
		StringBuilder formatBuilder = new StringBuilder();
		formatBuilder.append("%2dh %2dm [%2d%%] %");
		formatBuilder.append(aSymbolMaxSize);
		formatBuilder.append("s ");
		return formatBuilder.toString();
	}
	
	private String getEndFormat(int aSymbolsCount) {
		StringBuilder formatBuilder = new StringBuilder();
		formatBuilder.append("(%d of ");
		formatBuilder.append(aSymbolsCount);
		formatBuilder.append(") ");
		return formatBuilder.toString();
	}

	private void processSymbols() throws Exception {
		Symbols symbols = new Symbols();
		int symbolsCount = symbols.getCount();
		int symbolMaxSize = symbols.getSymbolMaxSize();
		//
		String beginFormat = getBeginFormat(symbolMaxSize);
		String endFormat = getEndFormat(symbols.getCount());
		//
		int requestPeriodSec = Settings.getRequestPeriodSec();
		mFailedSymbols.clear();
		int globalNo = 0;
		for (Symbol symbol : symbols.getArray()) {
			//
			globalNo++;
			int percent = (globalNo - 1) * 100 / symbolsCount;
			//
			int remainingSec = requestPeriodSec * (symbolsCount - globalNo);
			int totalMin = remainingSec / 60;
			int remainingH = totalMin / 60;
			int remainingMin = totalMin - (remainingH * 60);
			//
			String beginLine = String.format(beginFormat, remainingH, remainingMin, percent, symbol.getName());
			mConnection.printErrors();
			Logger.print(beginLine);
			mConnection.reqHistoricalData(symbol);
			//
			for (int i = 0; i < requestPeriodSec; i++) {
				if (mConnection.hasErrors()) {
					Logger.print("x");
				}
				else {
					Logger.print(".");
				}
				try {
					Thread.sleep(1000);
				}
				catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			//
			String endLine = String.format(endFormat, globalNo);
			if (mConnection.isHistoricalDataDone()) {
				Logger.print(endLine);
				Logger.println("OK (" + mConnection.getHistoricalDataCount() + ")");
			}
			else {
				mFailedSymbols.add(symbol);
				mConnection.cancelHistoricalData();
				Logger.print(endLine);
				Logger.println("FAIL");
			}
			mConnection.printErrors();
		}
	}
	
	private void printFailedSymbols() {
		if (mFailedSymbols.size() <= 0) {
			return;
		}
		//
		Logger.println("Failed symbols list BEGIN:");
		for (Symbol symbol : mFailedSymbols) {
			Logger.println(symbol.getName());
		}
		Logger.println("Failed symbols list END.");
	}

	@Override
	public void run() {
		try {
			mConnection.connect();
			Logger.println("Connected.");
			processSymbols();
		}
		catch(Throwable t) {
			Logger.logError("Fatal error: " + t.getMessage());
		}
		finally {
			mConnection.disconnect();
			Logger.println("Done (failed symbols count: " + mFailedSymbols.size() + ").");
			printFailedSymbols();
		}
	}
	
	public Program() {
		// void
	}
	
}
