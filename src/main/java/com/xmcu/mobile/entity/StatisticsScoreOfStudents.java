package com.xmcu.mobile.entity;

import org.json.JSONObject;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
@DatabaseTable(tableName="StatisticsScoreOfStudents")
/**
 * 
 *  #(c) ruanyun PocketCampus <br/>
 *
 *  鐗堟湰璇存槑: $id:$ <br/>
 *
 *  鍔熻兘璇存槑: 瀛︾敓娴嬮獙缁熻
 * 
 *  <br/>鍒涘缓璇存槑: 2013-11-22 涓嬪崍3:55:46 linrr  鍒涘缓鏂囦欢<br/>
 * 
 *  淇敼鍘嗗彶:<br/>
 *
 */
public class StatisticsScoreOfStudents {
	@DatabaseField
	private String data;//鏁版嵁
		@DatabaseField
	private String title;//鏍囬
		@DatabaseField
	private String averageScore;//骞冲潎鍒?
		@DatabaseField
		private String test;//娴嬮獙
		@DatabaseField
	private String highestScore;//鏈?楂樺垎
		public StatisticsScoreOfStudents(){}
		public StatisticsScoreOfStudents(JSONObject jo) {
			data = jo.optString("鏁版嵁");
			title = jo.optString("鏍囬");
			averageScore = jo.optString("骞冲潎鍒?");
			highestScore= jo.optString("鏈?楂樺垎");
			test=jo.optString("娴嬮獙");
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
		public String getAverageScore() {
			return averageScore;
		}
		public void setAverageScore(String averageScore) {
			this.averageScore = averageScore;
		}
		public String getTest() {
			return test;
		}
		public void setTest(String test) {
			this.test = test;
		}
		public String getHighestScore() {
			return highestScore;
		}
		public void setHighestScore(String highestScore) {
			this.highestScore = highestScore;
		}
}
