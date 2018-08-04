package com.xmcu.mobile.entity;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * 
 * #(c) ruanyun PocketCampus <br/>
 * 
 * 鐗堟湰璇存槑: $id:$ <br/>
 * 
 * 鍔熻兘璇存槑: classdetail涓殑璇剧▼
 * 
 * <br/>
 * 鍒涘缓璇存槑: 2014-4-26 涓婂崍11:06:31 shengguo 鍒涘缓鏂囦欢<br/>
 * 
 * 淇敼鍘嗗彶:<br/>
 * 
 */
public class Curriculum {
	private String teacherRank;
	private String courseRating;
	private String summaryContent;
	private String homeWork;
	private String attendanceValues;
	private String curriculums;
	private String classes;
	private ArrayList<DownloadSubject> imagePaths;

	public Curriculum() {
	}

	public Curriculum(JSONObject jo) throws JSONException {
		teacherRank = jo.optString("鑰佸笀璇勫垎");
		courseRating = jo.optString("璇剧▼璇勫垎");
		summaryContent = jo.optString("鎺堣鍐呭");
		homeWork = jo.optString("璇惧悗浣滀笟");
		attendanceValues = jo.optString("涓汉鍑哄嫟");
		curriculums = jo.optString("鎵?甯﹁绋?");
		classes = jo.optString("鎵?甯︾彮绾?");
		JSONArray joimg = jo.optJSONArray("璇惧爞绗旇鍥剧墖");
		imagePaths = new ArrayList<DownloadSubject>();
		for (int i = 0; i < joimg.length(); i++) {
			DownloadSubject downsub=new DownloadSubject(joimg.getJSONObject(i));
			imagePaths.add(downsub);
			
		}
	}

	public String getTeacherRank() {
		return teacherRank;
	}

	public void setTeacherRank(String teacherRank) {
		this.teacherRank = teacherRank;
	}

	public String getCourseRating() {
		return courseRating;
	}

	public void setCourseRating(String courseRating) {
		this.courseRating = courseRating;
	}

	public String getSummaryContent() {
		return summaryContent;
	}

	public void setSummaryContent(String summaryContent) {
		this.summaryContent = summaryContent;
	}

	public String getHomeWork() {
		return homeWork;
	}

	public void setHomeWork(String homeWork) {
		this.homeWork = homeWork;
	}

	public String getAttendanceValues() {
		return attendanceValues;
	}

	public void setAttendanceValues(String attendanceValues) {
		this.attendanceValues = attendanceValues;
	}

	public String getCurriculums() {
		return curriculums;
	}

	public void setCurriculums(String curriculums) {
		this.curriculums = curriculums;
	}

	public String getClasses() {
		return classes;
	}

	public void setClasses(String classes) {
		this.classes = classes;
	}

	public ArrayList<DownloadSubject> getImagePaths() {
		return imagePaths;
	}

	public void setImagePaths(ArrayList<DownloadSubject> imagePaths) {
		this.imagePaths = imagePaths;
	}

	
}
