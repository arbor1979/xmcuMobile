package com.xmcu.mobile.entity;

import org.json.JSONObject;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
@DatabaseTable(tableName="QueryTheMarkOfStudent")
/**
 * 
 *  #(c) ruanyun PocketCampus <br/>
 *
 *  鐗堟湰璇存槑: $id:$ <br/>
 *
 *  鍔熻兘璇存槑: 瀛︾敓鎴愮哗鏌ヨ
 * 
 *  <br/>鍒涘缓璇存槑: 2013-11-22 涓嬪崍3:58:11 linrr  鍒涘缓鏂囦欢<br/>
 * 
 *  淇敼鍘嗗彶:<br/>
 *
 */
public class QueryTheMarkOfStudent {
	@DatabaseField
	private String data;//鏁版嵁
		@DatabaseField
	private String title;//鏍囬
		@DatabaseField
	private String average;//骞冲潎鍒?
		@DatabaseField
	private String totalscore;//鎬诲垎
		public QueryTheMarkOfStudent(){}
		public QueryTheMarkOfStudent(JSONObject jo) {
			data = jo.optString("鏁版嵁");
			title = jo.optString("鏍囬");
			average = jo.optString("骞冲潎鍒?");
			totalscore= jo.optString("鎬诲垎");
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
		public String getAverage() {
			return average;
		}
		public void setAverage(String average) {
			this.average = average;
		}
		public String getTotalscore() {
			return totalscore;
		}
		public void setTotalscore(String totalscore) {
			this.totalscore = totalscore;
		}
	
}
