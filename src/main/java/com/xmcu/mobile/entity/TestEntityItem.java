package com.xmcu.mobile.entity;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * 璇惧爞娴嬭瘯棰樺簱鍒楄〃鏁版嵁
 * 
 * @author hfthink
 * 
 */
public class TestEntityItem {
	private String id;// 缂栧彿
	private String termName;// 瀛︽湡鍚嶇О
	private String subjectId; // 涓婅璁板綍缂栧彿
	private String testName; // 娴嬮獙鍚嶇О
	private String topicName; // 棰樼洰鍚嶇О
	private String answerStatus;// 绛旈鐘舵??
	private String aAnswer;
	private String bAnswer;
	private String cAnswer;
	private String dAnswer;
	private String eAnswer;
	private String fAnswer;
	private String answer; // 姝ｇ‘绛旀
	private String remark; // 澶囨敞
	private String correctRate;// 姝ｇ‘鐜?
	private String errorRate;// 閿欒鐜?
	private String studentAnswerStatus; // 瀛︾敓绛旈鐘舵??
	private String studentAnswerResult; // 瀛︾敓绛旈缁撴灉
	private String CFS;//棰樼洰鍒嗙被缁熻

	public TestEntityItem() {

	}

	private TestEntityItem(JSONObject jo) {
		id = jo.optString("缂栧彿");
		termName = jo.optString("瀛︽湡鍚嶇О");
		subjectId = jo.optString("鑰佸笀涓婅璁板綍缂栧彿");
		testName = jo.optString("娴嬮獙鍚嶇О");
		topicName = jo.optString("棰樼洰鍚嶇О");
		answerStatus = jo.optString("绛旈鐘舵??");
		aAnswer = jo.optString("A");
		bAnswer = jo.optString("B");
		cAnswer = jo.optString("C");
		dAnswer = jo.optString("D");
		eAnswer = jo.optString("E");
		fAnswer = jo.optString("F");
		answer = jo.optString("姝ｇ‘绛旀");
		remark = jo.optString("澶囨敞");
		correctRate = jo.optString("姝ｇ‘鐜?");
		errorRate = jo.optString("閿欒鐜?");
		studentAnswerStatus = jo.optString("瀛︾敓绛旈鐘舵??");
		studentAnswerResult = jo.optString("瀛︾敓绛旈缁撴灉");
		CFS = jo.optString("棰樼洰鍒嗙被缁熻");
	}

	public static List<TestEntityItem> toList(JSONArray ja) {
		List<TestEntityItem> result = new ArrayList<TestEntityItem>();
		TestEntityItem info = null;

		for (int i = 0; i < ja.length(); i++) {
			JSONObject jo = ja.optJSONObject(i);
			info = new TestEntityItem(jo);
			result.add(info);
		}
		return result;
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTermName() {
		return termName;
	}

	public void setTermName(String termName) {
		this.termName = termName;
	}

	public String getaAnswer() {
		return aAnswer;
	}

	public void setaAnswer(String aAnswer) {
		this.aAnswer = aAnswer;
	}

	public String getbAnswer() {
		return bAnswer;
	}

	public void setbAnswer(String bAnswer) {
		this.bAnswer = bAnswer;
	}

	public String getcAnswer() {
		return cAnswer;
	}

	public void setcAnswer(String cAnswer) {
		this.cAnswer = cAnswer;
	}

	public String getdAnswer() {
		return dAnswer;
	}

	public void setdAnswer(String dAnswer) {
		this.dAnswer = dAnswer;
	}

	public String geteAnswer() {
		return eAnswer;
	}

	public void seteAnswer(String eAnswer) {
		this.eAnswer = eAnswer;
	}

	public String getfAnswer() {
		return fAnswer;
	}

	public void setfAnswer(String fAnswer) {
		this.fAnswer = fAnswer;
	}

	public String getCorrectRate() {
		return correctRate;
	}

	public void setCorrectRate(String correctRate) {
		this.correctRate = correctRate;
	}

	public String getErrorRate() {
		return errorRate;
	}

	public void setErrorRate(String errorRate) {
		this.errorRate = errorRate;
	}

	public String getStudentAnswerStatus() {
		return studentAnswerStatus;
	}

	public void setStudentAnswerStatus(String studentAnswerStatus) {
		this.studentAnswerStatus = studentAnswerStatus;
	}

	public String getStudentAnswerResult() {
		return studentAnswerResult;
	}

	public void setStudentAnswerResult(String studentAnswerResult) {
		this.studentAnswerResult = studentAnswerResult;
	}

	public String getCFS() {
		return CFS;
	}

	public void setCFS(String cFS) {
		CFS = cFS;
	}
}
