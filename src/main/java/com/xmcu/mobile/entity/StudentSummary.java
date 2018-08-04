package com.xmcu.mobile.entity;

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
 *  鍔熻兘璇存槑: 瀛︾敓璇惧爞鎬荤粨
 * 
 *  <br/>鍒涘缓璇存槑: 2014-4-30 涓嬪崍4:18:34 shengguo  鍒涘缓鏂囦欢<br/>
 * 
 *  淇敼鍘嗗彶:<br/>
 *
 */
public class StudentSummary {
	// {
	// "鑰佸笀璇勪环":"3",
	// "璇剧▼璇勪环":"3",
	// "鎴戠殑寤鸿":"",
	// "璇惧爞绗旇":"",
	// "鍞竴鐮丼END":"鐢ㄦ埛_瀛︾敓_1229641397____0________璇剧▼鍙婅?佸笀璇勪环_鎴戠殑寤鸿_璇惧爞绗旇________64013",
	// "璇惧爞绗旇鍥剧墖":{
	// }
	// }
	private String id;
	private String teacherEvaluate;
	private String curriculumEvaluate;
	private String mySuggestion;
	private String classNotes;
	private List<ImageItem> classNoteImages;
	public StudentSummary(JSONObject jo) {
		id = jo.optString("鍞竴鐮丼END");
		teacherEvaluate = jo.optString("鑰佸笀璇勪环");
		curriculumEvaluate = jo.optString("璇剧▼璇勪环");
		mySuggestion = jo.optString("鎴戠殑寤鸿");
		classNotes = jo.optString("璇惧爞绗旇");
		classNoteImages=new ArrayList<ImageItem>();
		JSONArray joii = jo.optJSONArray("璇惧爞绗旇鍥剧墖");
		for (int i = 0; i < joii.length(); i++) {
			ImageItem imageInfo=new ImageItem(joii.optJSONObject(i));
			classNoteImages.add(imageInfo);
		}
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTeacherEvaluate() {
		return teacherEvaluate;
	}

	public void setTeacherEvaluate(String teacherEvaluate) {
		this.teacherEvaluate = teacherEvaluate;
	}

	public String getCurriculumEvaluate() {
		return curriculumEvaluate;
	}

	public void setCurriculumEvaluate(String curriculumEvaluate) {
		this.curriculumEvaluate = curriculumEvaluate;
	}

	public String getMySuggestion() {
		return mySuggestion;
	}

	public void setMySuggestion(String mySuggestion) {
		this.mySuggestion = mySuggestion;
	}

	public String getClassNotes() {
		return classNotes;
	}

	public void setClassNotes(String classNotes) {
		this.classNotes = classNotes;
	}

	public List<ImageItem> getClassNoteImages() {
		return classNoteImages;
	}

	public void setClassNoteImages(List<ImageItem> classNoteImages) {
		this.classNoteImages = classNoteImages;
	}
}
