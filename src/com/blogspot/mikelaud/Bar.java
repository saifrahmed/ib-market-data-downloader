package com.blogspot.mikelaud;

public class Bar {

	private double mOpen = 0.0d;
	private double mHigh = 0.0d;
	private double mLow = 0.0d;
	private double mClose = 0.0d;
	private int mVolume = 0;
	private int mCount = 0;

	public double getOpen() { return mOpen; }
	public void setOpen(double aOpen) { mOpen = aOpen; }
		
	public double getHigh() { return mHigh; }
	public void setHigh(double aHigh) { mHigh = aHigh; }

	public double getLow() { return mLow; }
	public void setLow(double aLow) { mLow = aLow; }

	public double getClose() { return mClose; }
	public void setClose(double aClose) { mClose = aClose; }

	public int getVolume() { return mVolume; }
	public void setVolume(int aVolume) { mVolume = aVolume; }

	public int getCount() { return mCount; }
	public void setCount(int aCount) { mCount = aCount; }
	
	public Bar() {
		// void
	}
	
}
