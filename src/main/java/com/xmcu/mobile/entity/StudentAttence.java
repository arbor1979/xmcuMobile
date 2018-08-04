package com.xmcu.mobile.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * 
 * #(c) ruanyun PocketCampus <br/>
 * 
 * 鐗堟湰璇存槑: $id:$ <br/>
 * 
 * 鍔熻兘璇存槑: 瀛︾敓鑰冨嫟缁熻
 * 
 * <br/>
 * 鍒涘缓璇存槑: 2013-11-30 涓嬪崍12:01:14 yanzy 鍒涘缓鏂囦欢<br/>
 * 
 * 淇敼鍘嗗彶:<br/>
 * 
 */
@DatabaseTable(tableName = "StudentAttence")
public class StudentAttence implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@DatabaseField(id = true)
	private String id;
	@DatabaseField
	private String studentID; //瀛﹀彿
	@DatabaseField
	private String attenceTitle; //鑰冨嫟鏍囬
	@DatabaseField
	private String attendance; //鍑哄嫟
	@DatabaseField
	private String absence; //缂哄嫟
	@DatabaseField
	private String late; //杩熷埌
	@DatabaseField
	private String leave; //璇峰亣
	@DatabaseField
	private String attendanceRate; //鍑哄嫟鐜?

	public StudentAttence() {

	}

	public StudentAttence(JSONObject jo) {
		this.studentID = jo.optString("瀛﹀彿");
		this.attenceTitle = jo.optString("鏍囬");
		this.attendance = jo.optString("鍑哄嫟");
		this.absence = jo.optString("缂哄嫟");
		this.late = jo.optString("杩熷埌");
		this.leave = jo.optString("璇峰亣");
		this.attendanceRate = jo.optString("鍑哄嫟鐜?");
	}
	
	public StudentAttence(net.minidev.json.JSONObject jo) {
		this.studentID = String.valueOf(jo.get("瀛﹀彿"));
		this.attenceTitle = String.valueOf(jo.get("鏍囬"));
		this.attendance = String.valueOf(jo.get("鍑哄嫟"));
		this.absence = String.valueOf(jo.get("缂哄嫟"));
		this.late = String.valueOf(jo.get("杩熷埌"));
		this.leave = String.valueOf(jo.get("璇峰亣"));
		this.attendanceRate = String.valueOf(jo.get("鍑哄嫟鐜?"));
	}
	
	public static List<StudentAttence> toList(JSONArray ja) {
		List<StudentAttence> result = new ArrayList<StudentAttence>();
		StudentAttence info = null;
		
		if (ja != null && ja.length() > 0) {
			for (int i = 0; i < ja.length(); i++) {
				JSONObject jo = ja.optJSONObject(i);
				info = new StudentAttence(jo);
				result.add(info);
			}
			return result;
		}else{
			System.out.println("娌℃湁StudentAttence鏁版嵁");
			return null;
		}
	}
	
	public static List<StudentAttence> toList(net.minidev.json.JSONArray ja) {
		List<StudentAttence> result = new ArrayList<StudentAttence>();
		StudentAttence info = null;
		
		if (ja != null && ja.size() > 0) {
			for (int i = 0; i < ja.size(); i++) {
				net.minidev.json.JSONObject jo = (net.minidev.json.JSONObject)ja.get(i);
				info = new StudentAttence(jo);
				result.add(info);
			}
			return result;
		}else{
			System.out.println("娌℃湁StudentAttence鏁版嵁");
			return null;
		}
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStudentID() {
		return studentID;
	}

	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}

	public String getAttenceTitle() {
		return attenceTitle;
	}

	public void setAttenceTitle(String attenceTitle) {
		this.attenceTitle = attenceTitle;
	}

	public String getAttendance() {
		return attendance;
	}

	public void setAttendance(String attendance) {
		this.attendance = attendance;
	}

	public String getAbsence() {
		return absence;
	}

	public void setAbsence(String absence) {
		this.absence = absence;
	}

	public String getLate() {
		return late;
	}

	public void setLate(String late) {
		this.late = late;
	}

	public String getLeave() {
		return leave;
	}

	public void setLeave(String leave) {
		this.leave = leave;
	}

	public String getAttendanceRate() {
		return attendanceRate;
	}

	public void setAttendanceRate(String attendanceRate) {
		this.attendanceRate = attendanceRate;
	}

	
}
