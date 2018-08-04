package com.xmcu.mobile.entity;

import org.json.JSONObject;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * 
 * #(c) ruanyun PocketCampus <br/>
 * 
 * 鐗堟湰璇存槑: $id:$ <br/>
 * 
 * 鍔熻兘璇存槑: 鏀跺嵎鏃堕棿
 * 
 * <br/>
 * 鍒涘缓璇存槑: 2013-11-29 涓嬪崍4:35:31 zhuliang 鍒涘缓鏂囦欢<br/>
 * 
 * 淇敼鍘嗗彶:<br/>
 * 
 */
@DatabaseTable(tableName = "TestStartEntity")
public class TestStartEntity {
	@DatabaseField(generatedId = true)
	private int id;
	@DatabaseField
	private String timeKey;
	@DatabaseField
	private int timeValue;

	public TestStartEntity(){
		
	}
	public TestStartEntity(JSONObject jo){
		timeKey=jo.optString("鍚嶇О");
		timeValue = jo.optInt("鍊?");
	}
	public TestStartEntity(String timeKey,int timeValue){
		this.timeKey = timeKey;
		this.timeValue = timeValue;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTimeKey() {
		return timeKey;
	}

	public void setTimeKey(String timeKey) {
		this.timeKey = timeKey;
	}

	public int getTimeValues() {
		return timeValue;
	}

	public void setTimeValues(int timeValue) {
		this.timeValue = timeValue;
	}

}
