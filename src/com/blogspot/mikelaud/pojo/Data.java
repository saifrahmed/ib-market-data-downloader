package com.blogspot.mikelaud.pojo;

public class Data { // 4 x 2 + 483856 x 1024 ~= 472 MB

	private final int STOCKS_COUNT_MAX = 1024;
	
	private int mErrorCode = 0;
	private int mStocksCount = 0;
	private Month[] mStocks = new Month[STOCKS_COUNT_MAX]; 
	
	public int getStocksCountMax() { return STOCKS_COUNT_MAX; }
	
	public int getErrorCode() { return mErrorCode; }
	public void setErrorCode(int aErrorCode) { mErrorCode = aErrorCode; }
	
	public int getStocksCount() { return mStocksCount; }
	public void setStocksCount(int aStocksCount) { mStocksCount = aStocksCount; }
	
	public Month[] getStocks() { return mStocks; }
		
	public Data() {
		// void
	}

}

