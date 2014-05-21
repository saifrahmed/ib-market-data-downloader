package com.blogspot.mikelaud.pojo;

public class Day { // 4 x 2 + 40 x 390 = 15608 ~= 15K

	private final int BARS_COUNT_MAX = 390;
	
	private int mErrorCode = 0;
	private int mBarsCount = 0;
	private Bar[] mBars = new Bar[BARS_COUNT_MAX]; 
	
	public int getBarsCountMax() { return BARS_COUNT_MAX; }
	
	public int getErrorCode() { return mErrorCode; }
	public void setErrorCode(int aErrorCode) { mErrorCode = aErrorCode; }
	
	public int getBarsCount() { return mBarsCount; }
	public void setBarsCount(int aBarsCount) { mBarsCount = aBarsCount; }
	
	public Bar[] getBars() { return mBars; }
		
	public Day() {
		// void
	}
	
}
