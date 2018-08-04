package com.xmcu.mobile.entity;

import org.json.JSONObject;

/**
 * 
 *  #(c) ruanyun PocketCampus <br/>
 *
 *  鐗堟湰璇存槑: $id:$ <br/>
 *
 *  鍔熻兘璇存槑: 鑾峰彇娴嬮獙鐘舵??
 * 
 *  <br/>鍒涘缓璇存槑: 2014-4-29 涓婂崍10:00:34 shengguo  鍒涘缓鏂囦欢<br/>
 * 
 *  淇敼鍘嗗彶:<br/>
 *
 */
public class TestStatus {
	private String id;
	private String testStatus;
	private long TotalTime;
	private long remainingTime;
	private long expiryTime;
	
	public TestStatus() {
	}
	
	public TestStatus(JSONObject jo) {
		id = jo.optString("鍞竴鐮丼END");
		//remainingTime = jo.optLong("鍓╀綑鏃堕棿");
		JSONObject joarr = jo.optJSONObject("GET_ARRAY2");
		testStatus = joarr.optString("绛旈鐘舵??");
		remainingTime= joarr.optLong("鍓╀綑鏃堕棿");
		expiryTime = joarr.optLong("鍒版湡鏃堕棿");
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTestStatus() {
		return testStatus;
	}

	public void setTestStatus(String testStatus) {
		this.testStatus = testStatus;
	}
	/**
	 * @return 鍓╀綑鏃堕棿(/s)
	 */
	public long getRemainingTime() {
		return remainingTime;
	}

	public void setRemainingTime(long remainingTime) {
		this.remainingTime = remainingTime;
	}

	public long getExpiryTime() {
		return expiryTime;
	}

	public void setExpiryTime(long expiryTime) {
		this.expiryTime = expiryTime;
	}

	/**
	 * @return 鎬绘椂闂?(/s)
	 */
	public long getTotalTime() {
		return TotalTime;
	}

	public void setTotalTime(long totalTime) {
		TotalTime = totalTime;
	}
	
}
