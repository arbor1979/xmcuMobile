package com.xmcu.mobile.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * 
 *  #(c) ruanyun PocketCampus <br/>
 *
 *  鐗堟湰璇存槑: $id:$ <br/>
 *
 *  鍔熻兘璇存槑: 妫?娴嬪垎鏁?
 * 
 *  <br/>鍒涘缓璇存槑: 2013-11-30 涓嬪崍4:11:38 yanzy  鍒涘缓鏂囦欢<br/>
 * 
 *  淇敼鍘嗗彶:<br/>
 *
 */
//@DatabaseTable(tableName = "StudentTestItem")
public class StudentTestItem implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//	@DatabaseField(id = true)
	private String id;
//	@DatabaseField
	private String studentID; //瀛﹀彿
//	@DatabaseField
	private String name; //娴嬮獙鍚嶇О
//	@DatabaseField
	private String date; //娴嬮獙鏃堕棿
//	@DatabaseField
	private String score; //鍒嗘暟
//	@DatabaseField
	private String avgScore; //骞冲潎鍒?
//	@DatabaseField
	private String highestScore; //鏈?楂樺垎
	
	public StudentTestItem() {
		
	}

	public StudentTestItem(JSONObject jo) {
		this.studentID = jo.optString("瀛﹀彿");
		this.name = jo.optString("娴嬮獙鍚嶇О");
		this.date = jo.optString("娴嬮獙鏃堕棿");
		this.score = jo.optString("娴嬮獙鍒嗗??");
		this.avgScore = jo.optString("骞冲潎鍒?");
		this.highestScore = jo.optString("鏈?楂樺垎");
	}
	
	public static List<StudentTestItem> toList(JSONArray ja) {
		List<StudentTestItem> result = new ArrayList<StudentTestItem>();
		StudentTestItem info = null;
		
		if (ja != null && ja.length() > 0) {
			for (int i = 0; i < ja.length(); i++) {
				JSONObject jo = ja.optJSONObject(i);
				info = new StudentTestItem(jo);
				result.add(info);
			}
			return result;
		}else{
			System.out.println("娌℃湁StudentTestItem鏁版嵁");
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public String getAvgScore() {
		return avgScore;
	}

	public void setAvgScore(String avgScore) {
		this.avgScore = avgScore;
	}

	public String getHighestScore() {
		return highestScore;
	}

	public void setHighestScore(String highestScore) {
		this.highestScore = highestScore;
	}

	
}
