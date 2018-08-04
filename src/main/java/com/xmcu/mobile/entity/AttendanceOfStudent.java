package com.xmcu.mobile.entity;

import org.json.JSONObject;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
@DatabaseTable(tableName = "AttendanceOfStudent")
/**
 * 
 *  #(c) ruanyun PocketCampus <br/>
 *
 *  鐗堟湰璇存槑: $id:$ <br/>
 *
 *  鍔熻兘璇存槑: 瀛︾敓鑰冨嫟缁熻
 * 
 *  <br/>鍒涘缓璇存槑: 2013-11-22 涓嬪崍3:57:30 linrr  鍒涘缓鏂囦欢<br/>
 * 
 *  淇敼鍘嗗彶:<br/>
 *
 */
public class AttendanceOfStudent {
	@DatabaseField
private String data;//鏁版嵁
	@DatabaseField
private String title;//鏍囬
	@DatabaseField
private String attendance;//鍑哄嫟鐜?
	@DatabaseField
	
private String color;//棰滆壊
	public AttendanceOfStudent(){}
	public AttendanceOfStudent(JSONObject jo) {
		data = jo.optString("鏁版嵁");
		title = jo.optString("鏍囬");
		attendance = jo.optString("鍑哄嫟鐜?");
		color= jo.optString("棰滆壊");
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAttendance() {
		return attendance;
	}
	public void setAttendance(String attendance) {
		this.attendance = attendance;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}

}
