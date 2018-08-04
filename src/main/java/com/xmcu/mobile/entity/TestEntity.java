package com.xmcu.mobile.entity;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * 璇惧爞娴嬭瘯棰樺簱鍒楄〃鏁版嵁
 * 
 * @author hfthink
 * 
 */
@DatabaseTable(tableName = "TestEntity")
public class TestEntity {

	@DatabaseField(generatedId = true)
	private int id;
	@DatabaseField
	private String subjectId; //涓婅璁板綍缂栧彿
	@DatabaseField
	private String testName; //娴嬮獙鍚嶇О
	@DatabaseField
	private String topicName; //棰樼洰鍚嶇О
	@DatabaseField
	private String answerStatus;//绛旈鐘舵?? 
	@DatabaseField
	private String answer; //绛旀
	@DatabaseField
	private String remark; //澶囨敞
	@DatabaseField
	private String studentAnswer; //瀛︾敓绛旈
	@DatabaseField
	private String testOption;
	
	public TestEntity() {
		
	}

	private TestEntity(JSONObject jo) {
		this.subjectId = jo.optString("鑰佸笀涓婅璁板綍缂栧彿");
		this.testName = jo.optString("娴嬮獙鍚嶇О");
		this.topicName = jo.optString("棰樼洰鍚嶇О");
		this.answerStatus = jo.optString("绛旈鐘舵??");
		this.answer = jo.optString("姝ｇ‘绛旀");
		this.remark = jo.optString("澶囨敞");
		this.studentAnswer = jo.optString("瀛︾敓绛旈");
		this.testOption = jo.optString("棰樼洰");
	}
	private TestEntity(net.minidev.json.JSONObject jo) {
		this.subjectId = String.valueOf(jo.get("鑰佸笀涓婅璁板綍缂栧彿"));
		this.testName = String.valueOf(jo.get("娴嬮獙鍚嶇О"));
		this.topicName = String.valueOf(jo.get("棰樼洰鍚嶇О"));
		this.answerStatus = String.valueOf(jo.get("绛旈鐘舵??"));
		this.answer = String.valueOf(jo.get("姝ｇ‘绛旀"));
		this.remark = String.valueOf(jo.get("澶囨敞"));
		this.studentAnswer = String.valueOf(jo.get("瀛︾敓绛旈"));
		this.testOption = String.valueOf(jo.get("棰樼洰"));
	}

	public static List<TestEntity> toList(JSONArray ja) {
		List<TestEntity> result = new ArrayList<TestEntity>();
		TestEntity info = null;

		for (int i = 0; i < ja.length(); i++) {
			JSONObject jo = ja.optJSONObject(i);
			info = new TestEntity(jo);
			result.add(info);
		}

		return result;

	}
	public static List<TestEntity> toList(net.minidev.json.JSONArray ja) {
		List<TestEntity> result = new ArrayList<TestEntity>();
		TestEntity info = null;

		for (int i = 0; i < ja.size(); i++) {
			net.minidev.json.JSONObject jo = (net.minidev.json.JSONObject)ja.get(i);
			info = new TestEntity(jo);
			result.add(info);
		}

		return result;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public String getTopicName() {
		return topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

	public String getAnswerStatus() {
		return answerStatus;
	}

	public void setAnswerStatus(String answerStatus) {
		this.answerStatus = answerStatus;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getStudentAnswer() {
		return studentAnswer;
	}

	public void setStudentAnswer(String studentAnswer) {
		this.studentAnswer = studentAnswer;
	}

	public String getTestOption() {
		return testOption;
	}

	public void setTestOption(String testOption) {
		this.testOption = testOption;
	}

	
}
