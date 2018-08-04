package com.xmcu.mobile.entity;

import org.json.JSONObject;

/**
 * 
 * #(c) ruanyun PocketCampus <br/>
 * 
 * 鐗堟湰璇存槑: $id:$ <br/>
 * 
 * 鍔熻兘璇存槑: 鏁欏笀涓婅璁板綍
 * 
 * <br/>
 * 鍒涘缓璇存槑: 2014-4-23 涓嬪崍6:21:20 shengguo 鍒涘缓鏂囦欢<br/>
 * 
 * 淇敼鍘嗗彶:<br/>
 * 
 */
public class TeacherSchoolRecords {
	private String id;//
	private String schoolTerm;//
	private String name;//
	private String userName;//
	private String courseDate;
	private String classRoom;//
	private String className;//
	private String curriculum;// 璇剧▼
	private String numberOfWeek;// 鍛ㄦ
	private String weeks;// 鏄熸湡
	private String sections;// 鑺傛
	private String Lectures;// 鎺堣鍐呭
	private String jobLayout;// 浣滀笟甯冪疆
	private String classDetails;// 璇惧爞璇︽儏
	private String classroomDiscipline;// 璇惧爞绾緥
	private String numberOfPeople;// 鐝骇浜烘暟
	private String realToNumberOfPeople;// 瀹炲埌浜烘暟
	private String absenceStatus;// 缂哄嫟鎯呭喌鐧昏
	private String shouldFillTime;// 搴旇濉啓鏃堕棿
	private String latestFillTime;// 鏈?杩熷～鍐欐椂闂?
	private String fillTime;// 濉啓鏃堕棿
	private String quizzesStatus;// 璇惧爞娴嬮獙鐘舵??
	private String remark;//
	private String classStartTime;// 涓婅寮?濮嬫椂闂?
	private String absenceStatusJSON;// 缂哄嫟鎯呭喌鐧昏JSON
	private String compositeScoreText;// 鏈鎺堣缁煎悎璇勫垎_鏂囨湰
	private String compositeScoreValues;// 鏈鎺堣缁煎悎璇勫垎_鍒嗗??
	//private String[] compositeIds;// 璇惧爞娴嬮獙_缂栧彿瀵圭収琛?

	public TeacherSchoolRecords() {

	}

	public TeacherSchoolRecords(JSONObject jo) {
		id =jo.optString("缂栧彿");
		schoolTerm = jo.optString("瀛︽湡");
		name = jo.optString("鏁欏笀濮撳悕");
		userName = jo.optString("鏁欏笀鐢ㄦ埛鍚?");
		courseDate = jo.optString("涓婅鏃ユ湡");
		classRoom = jo.optString("鏁欏");//
		className = jo.optString("鐝骇");//
		curriculum = jo.optString("璇剧▼");//
		numberOfWeek = jo.optString("鍛ㄦ");//
		weeks = jo.optString("鏄熸湡");//
		sections = jo.optString("鑺傛");//
		Lectures = jo.optString("鎺堣鍐呭");//
		jobLayout = jo.optString("浣滀笟甯冪疆");//
		classDetails = jo.optString("璇惧爞璇︽儏");//
		classroomDiscipline = jo.optString("璇惧爞绾緥");//
		numberOfPeople = jo.optString("鐝骇浜烘暟");//
		realToNumberOfPeople = jo.optString("瀹炲埌浜烘暟");//
		absenceStatus = jo.optString("缂哄嫟鎯呭喌鐧昏");//
		shouldFillTime = jo.optString("搴旇濉啓鏃堕棿");//
		latestFillTime = jo.optString("鏈?杩熷～鍐欐椂闂?");//
		fillTime = jo.optString("濉啓鏃堕棿");//
		quizzesStatus = jo.optString("璇惧爞娴嬮獙鐘舵??");//
		remark = jo.optString("澶囨敞");//
		classStartTime = jo.optString("涓婅寮?濮嬫椂闂?");//
		absenceStatusJSON = jo.optString("缂哄嫟鎯呭喌鐧昏JSON");//
		compositeScoreText = jo.optString("鏈鎺堣缁煎悎璇勫垎_鏂囨湰");//
		compositeScoreValues = jo.optString("鏈鎺堣缁煎悎璇勫垎_鍒嗗??");//
		//JSONArray joids = jo.optJSONArray("璇惧爞娴嬮獙_缂栧彿瀵圭収琛?");//
//		compositeIds = new String[joids.length()];
//		for (int i = 0; i < joids.length(); i++) {
//			compositeIds[i] = joids.optString(i);
//		}
	}

	public TeacherSchoolRecords(net.minidev.json.JSONObject jo) {
		id = String.valueOf(jo.get("缂栧彿"));
		schoolTerm =  String.valueOf(jo.get("瀛︽湡"));
		name =  String.valueOf(jo.get("鏁欏笀濮撳悕"));
		userName =  String.valueOf(jo.get("鏁欏笀鐢ㄦ埛鍚?"));
		courseDate =  String.valueOf(jo.get("涓婅鏃ユ湡"));
		classRoom =  String.valueOf(jo.get("鏁欏"));//
		className =  String.valueOf(jo.get("鐝骇"));//
		curriculum =  String.valueOf(jo.get("璇剧▼"));//
		numberOfWeek =  String.valueOf(jo.get("鍛ㄦ"));//
		weeks =  String.valueOf(jo.get("鏄熸湡"));//
		sections =  String.valueOf(jo.get("鑺傛"));//
		Lectures =  String.valueOf(jo.get("鎺堣鍐呭"));//
		jobLayout =  String.valueOf(jo.get("浣滀笟甯冪疆"));//
		classDetails =  String.valueOf(jo.get("璇惧爞璇︽儏"));//
		classroomDiscipline =  String.valueOf(jo.get("璇惧爞绾緥"));//
		numberOfPeople =  String.valueOf(jo.get("鐝骇浜烘暟"));//
		realToNumberOfPeople =  String.valueOf(jo.get("瀹炲埌浜烘暟"));//
		absenceStatus =  String.valueOf(jo.get("缂哄嫟鎯呭喌鐧昏"));//
		shouldFillTime =  String.valueOf(jo.get("搴旇濉啓鏃堕棿"));//
		latestFillTime =  String.valueOf(jo.get("鏈?杩熷～鍐欐椂闂?"));//
		fillTime =  String.valueOf(jo.get("濉啓鏃堕棿"));//
		quizzesStatus =  String.valueOf(jo.get("璇惧爞娴嬮獙鐘舵??"));//
		remark = String.valueOf( jo.get("澶囨敞"));//
		classStartTime =  String.valueOf(jo.get("涓婅寮?濮嬫椂闂?"));//
		absenceStatusJSON = String.valueOf(jo.get("缂哄嫟鎯呭喌鐧昏JSON"));//
		compositeScoreText =String.valueOf( jo.get("鏈鎺堣缁煎悎璇勫垎_鏂囨湰"));//
		compositeScoreValues = String.valueOf(jo.get("鏈鎺堣缁煎悎璇勫垎_鍒嗗??"));//
		
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSchoolTerm() {
		return schoolTerm;
	}

	public void setSchoolTerm(String schoolTerm) {
		this.schoolTerm = schoolTerm;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCourseDate() {
		return courseDate;
	}

	public void setCourseDate(String courseDate) {
		this.courseDate = courseDate;
	}

	public String getClassRoom() {
		return classRoom;
	}

	public void setClassRoom(String classRoom) {
		this.classRoom = classRoom;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getCurriculum() {
		return curriculum;
	}

	public void setCurriculum(String curriculum) {
		this.curriculum = curriculum;
	}

	public String getNumberOfWeek() {
		return numberOfWeek;
	}

	public void setNumberOfWeek(String numberOfWeek) {
		this.numberOfWeek = numberOfWeek;
	}

	public String getWeeks() {
		return weeks;
	}

	public void setWeeks(String weeks) {
		this.weeks = weeks;
	}

	public String getSections() {
		return sections;
	}

	public void setSections(String sections) {
		this.sections = sections;
	}

	public String getLectures() {
		return Lectures;
	}

	public void setLectures(String lectures) {
		Lectures = lectures;
	}

	public String getJobLayout() {
		return jobLayout;
	}

	public void setJobLayout(String jobLayout) {
		this.jobLayout = jobLayout;
	}

	public String getClassDetails() {
		return classDetails;
	}

	public void setClassDetails(String classDetails) {
		this.classDetails = classDetails;
	}

	public String getClassroomDiscipline() {
		return classroomDiscipline;
	}

	public void setClassroomDiscipline(String classroomDiscipline) {
		this.classroomDiscipline = classroomDiscipline;
	}

	public String getNumberOfPeople() {
		return numberOfPeople;
	}

	public void setNumberOfPeople(String numberOfPeople) {
		this.numberOfPeople = numberOfPeople;
	}

	public String getRealToNumberOfPeople() {
		return realToNumberOfPeople;
	}

	public void setRealToNumberOfPeople(String realToNumberOfPeople) {
		this.realToNumberOfPeople = realToNumberOfPeople;
	}

	public String getAbsenceStatus() {
		return absenceStatus;
	}

	public void setAbsenceStatus(String absenceStatus) {
		this.absenceStatus = absenceStatus;
	}

	public String getShouldFillTime() {
		return shouldFillTime;
	}

	public void setShouldFillTime(String shouldFillTime) {
		this.shouldFillTime = shouldFillTime;
	}

	public String getLatestFillTime() {
		return latestFillTime;
	}

	public void setLatestFillTime(String latestFillTime) {
		this.latestFillTime = latestFillTime;
	}

	public String getFillTime() {
		return fillTime;
	}

	public void setFillTime(String fillTime) {
		this.fillTime = fillTime;
	}

	public String getQuizzesStatus() {
		return quizzesStatus;
	}

	public void setQuizzesStatus(String quizzesStatus) {
		this.quizzesStatus = quizzesStatus;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getClassStartTime() {
		return classStartTime;
	}

	public void setClassStartTime(String classStartTime) {
		this.classStartTime = classStartTime;
	}

	public String getAbsenceStatusJSON() {
		return absenceStatusJSON;
	}

	public void setAbsenceStatusJSON(String absenceStatusJSON) {
		this.absenceStatusJSON = absenceStatusJSON;
	}

	public String getCompositeScoreText() {
		return compositeScoreText;
	}

	public void setCompositeScoreText(String compositeScoreText) {
		this.compositeScoreText = compositeScoreText;
	}

	public String getCompositeScoreValues() {
		return compositeScoreValues;
	}

	public void setCompositeScoreValues(String compositeScoreValues) {
		this.compositeScoreValues = compositeScoreValues;
	}

//	public String[] getCompositeIds() {
//		return compositeIds;
//	}
//
//	public void setCompositeIds(String[] compositeIds) {
//		this.compositeIds = compositeIds;
//	}
}
