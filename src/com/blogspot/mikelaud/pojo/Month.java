package com.blogspot.mikelaud.pojo;

public class Month { // 4 x 2 + 15608 x 31 = 483856 ~= 472 KB

	private final int DAYS_COUNT_MAX = 31;
	
	private int mErrorCode = 0;
	private int mDaysCount = 0;
	private Day[] mDays = new Day[DAYS_COUNT_MAX]; 
	
	public int getDaysCountMax() { return DAYS_COUNT_MAX; }
	
	public int getErrorCode() { return mErrorCode; }
	public void setErrorCode(int aErrorCode) { mErrorCode = aErrorCode; }
	
	public int getDaysCount() { return mDaysCount; }
	public void setDaysCount(int aDaysCount) { mDaysCount = aDaysCount; }
	
	public Day[] getDays() { return mDays; }
		
	public Month() {
		// void
	}

}
