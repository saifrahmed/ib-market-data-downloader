package com.blogspot.mikelaud.ib;

import java.util.concurrent.atomic.AtomicLong;

public class ConnectionState {

	private final int IB_CONNECTIVITY_LOSTED = 1100;
	private final int IB_CONNECTIVITY_RESTORED_data_lost = 1101;
	private final int IB_CONNECTIVITY_RESTORED_data_maintained = 1102;
	//
	private final int MARKET_DATA_FARM_IS_DISCONNECTED = 2103;
	private final int MARKET_DATA_FARM_IS_CONNECTED = 2104;
	private final int HISTORICAL_DATA_FARM_IS_DISCONNECTED = 2105;
	private final int HISTORICAL_DATA_FARM_IS_CONNECTED = 2106;
	//
	private volatile boolean mIbConnectivityOk = true;
	private volatile boolean mMarketDataFarmOk = true;
	private volatile boolean mHistoricalDataFarmOk = true;
	//
	private AtomicLong mStateSequence = new AtomicLong(0);
	
	private void setIbConnectivityLosted(int aId, int aErrorCode, String aErrorMsg) {
		mStateSequence.incrementAndGet();
		mIbConnectivityOk = false;
	}
	
	private void setIbConnectivityRestored(int aId, int aErrorCode, String aErrorMsg) {
		mStateSequence.incrementAndGet();
		mIbConnectivityOk = true;
	}
	
	private void setMarketDataFarmIsDisconnected(int aId, int aErrorCode, String aErrorMsg) {
		mStateSequence.incrementAndGet();
		mMarketDataFarmOk = false;
	}
	
	private void setMarketDataFarmIsConnected(int aId, int aErrorCode, String aErrorMsg) {
		mStateSequence.incrementAndGet();
		mMarketDataFarmOk = true;
	}
	
	private void setHistoricalDataFarmIsDisconnected(int aId, int aErrorCode, String aErrorMsg) {
		mStateSequence.incrementAndGet();
		mHistoricalDataFarmOk = false;
	}
	
	private void setHistoricalDataFarmIsConnected(int aId, int aErrorCode, String aErrorMsg) {
		mStateSequence.incrementAndGet();
		mHistoricalDataFarmOk = true;
	}
	
	public long getStateSequence() {
		return mStateSequence.get();
	}
	
	public void addError(int aId, int aErrorCode, String aErrorMsg) {
		switch (aErrorCode) {
		case IB_CONNECTIVITY_LOSTED:
			setIbConnectivityLosted(aId, aErrorCode, aErrorMsg);
			break;
		case IB_CONNECTIVITY_RESTORED_data_lost:
			setIbConnectivityRestored(aId, aErrorCode, aErrorMsg);
			break;
		case IB_CONNECTIVITY_RESTORED_data_maintained:
			setIbConnectivityRestored(aId, aErrorCode, aErrorMsg);
			break;
		case MARKET_DATA_FARM_IS_DISCONNECTED:
			setMarketDataFarmIsDisconnected(aId, aErrorCode, aErrorMsg);
			break;
		case MARKET_DATA_FARM_IS_CONNECTED:
			setMarketDataFarmIsConnected(aId, aErrorCode, aErrorMsg);
			break;
		case HISTORICAL_DATA_FARM_IS_DISCONNECTED:
			setHistoricalDataFarmIsDisconnected(aId, aErrorCode, aErrorMsg);
			break;
		case HISTORICAL_DATA_FARM_IS_CONNECTED:
			setHistoricalDataFarmIsConnected(aId, aErrorCode, aErrorMsg);
			break;
		}
	}
	
	public boolean isIbConnectivityOk() {
		return mIbConnectivityOk;
	}

	public boolean isMarketDataFarmOk() {
		return mMarketDataFarmOk;
	}
	
	public boolean isHistoricalDataFarmOk() {
		return mHistoricalDataFarmOk;
	}
		
	public boolean isOk() {
		return
			isIbConnectivityOk()
			&&
			isMarketDataFarmOk()
			&&
			isHistoricalDataFarmOk();
	}
	
	public boolean isNotOk() {
		return ! isOk();
	}
	
}
