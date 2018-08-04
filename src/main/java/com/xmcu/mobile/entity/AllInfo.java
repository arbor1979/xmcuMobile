package com.xmcu.mobile.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONObject;

import android.util.Log;

import com.xmcu.mobile.base.Constants;
import com.xmcu.mobile.util.AppUtility;
import com.xmcu.mobile.util.PrefUtility;

public class AllInfo {
	private String TAG = "AllInfo";
	private Schedule schedule; // 璇捐〃瑙勫垯
	private List<TestEntity> testEntitys;// 璇惧爞娴嬮獙

	private List<DownloadSubject> downloadSubjects;// 璇句欢涓嬭浇

	private List<TeacherInfo> teacherInfos; // 鏁欏笀涓婅璁板綍

	private Map<String,List<Student>> studentList; // 瀛︾敓鍒楄〃

	private List<StudentAttence> studentAttenceList; // 瀛︾敓鑰冨嫟缁熻

	private List<Dictionary> studentAttenceColorList; // 鑰冨嫟缁熻棰滆壊

	private List<StudentScore> studentScoreList; // 瀛︾敓鎴愮哗鏌ヨ

	private List<StudentTest> studentTestList; // 瀛︾敓娴嬮獙鏌ヨ

	private List<Dictionary> studentTestColorList; // 娴嬮獙缁熻棰滆壊

	private List<Dictionary> studentInfoList;// 瀛︾敓璇︽儏鏄剧ず

	private Dictionary studentTab; // 瀛︾敓淇℃伅鍗?

	Dictionary dictionary = null;

	private List<TestStartEntity> startTestList;// 娴嬮獙鏃堕棿缁熻

	// List<Map> childList;
	int[] array;

	private String curriculums;// 鎵?甯﹁绋?
	private String classesStr;// 鎵?甯︾彮绾?
	private String companyName;// 鍗曚綅鍚嶇О
	private String workAttendances;// 鑰冨嫟鍚嶇О
	private String workAttendanceValues;// 鑰冨嫟鍒嗗??
	private String allowSchoolrecordkeysStr;// 鍏佽鏁欏笀淇敼鏁欏笀涓婅璁板綍淇℃伅瀛楁
	private String allowSchoolrecordSummaryKeysStr;// "鍏佽鏁欏笀淇敼鏁欏笀涓婅璁板綍淇℃伅瀛楁_鎬荤粨
	private String allowSchoolrecordWorkAttendanceKeysStr;// "鍏佽鏁欏笀淇敼鏁欏笀涓婅璁板綍淇℃伅瀛楁_鑰冨嫟
	private int currentWeek;// 褰撳墠鍛ㄦ锛?
	private int selectedWeek;// 閫夋嫨鍛ㄦ
	private int maxWeek;// "鏈?澶у懆娆?
	private String curXueQi;//褰撳墠瀛︽湡
	private List<WorkAttendanceRule> workAttendanceRules;// 鑰冨嫟瑙勫垯
	private List<AddScoresRule> addScoresRule;// 鍔犲垎瑙勫垯
	private List<ReduceScoresRule> reduceScoresRule;// 鍑忓垎瑙勫垯
	// private List<WorkAttendanceRule> workAttendanceRules;//
	private List<TeacherSchoolRecords> teacherSchoolRecords;// 鏁欏笀涓婅璁板綍
	private List<MyClassSchedule> futureClassSchedule;// 鏈潵涓婅璁板綍
	// private List<StudentPic> studentPicList; //瀛︾敓澶村儚

	// private Teacher
	@SuppressWarnings("unchecked")
	public AllInfo(JSONObject jo) {
		curriculums = jo.optString("鎵?甯﹁绋?");
		companyName = jo.optString("鍗曚綅鍚嶇О");
		workAttendances = jo.optString("鑰冨嫟鍚嶇О");
		workAttendanceValues = jo.optString("鑰冨嫟鍒嗗??");
		allowSchoolrecordkeysStr = jo.optString("鍏佽鏁欏笀淇敼鏁欏笀涓婅璁板綍淇℃伅瀛楁");
		allowSchoolrecordSummaryKeysStr = jo.optString("鍏佽鏁欏笀淇敼鏁欏笀涓婅璁板綍淇℃伅瀛楁_鎬荤粨");
		allowSchoolrecordWorkAttendanceKeysStr = jo
				.optString("鍏佽鏁欏笀淇敼鏁欏笀涓婅璁板綍淇℃伅瀛楁_鑰冨嫟");
		currentWeek = jo.optInt("褰撳墠鍛ㄦ");
		selectedWeek = jo.optInt("閫夋嫨鍛ㄦ");
		maxWeek = jo.optInt("鏈?澶у懆娆?");
		curXueQi=jo.optString("褰撳墠瀛︽湡");
		PrefUtility.put(Constants.PREF_CURRICULUMS, curriculums);
		PrefUtility.put(Constants.PREF_CLASSES, classesStr);
		PrefUtility.put(Constants.PREF_COMPANY_NAME, companyName);
		PrefUtility.put(Constants.PREF_WORK_ATTENDANCES, workAttendances);
		PrefUtility.put(Constants.PREF_WORK_ATTENDANCE_VALUES,
				workAttendanceValues);
		PrefUtility.put(Constants.PREF_ALLOW_SCHOOL_RECORDKEYS_STR,
				allowSchoolrecordkeysStr);
		PrefUtility.put(Constants.PREF_ALLOW_SCHOOL_RECORD_SUMMARYKEYS_STR,
				allowSchoolrecordSummaryKeysStr);
		PrefUtility.put(
				Constants.PREF_ALLOW_SCHOOL_RECORDWORK_ATTENDANCEKEYS_STR,
				allowSchoolrecordWorkAttendanceKeysStr);
		 PrefUtility.put(Constants.PREF_CURRENT_WEEK, currentWeek);
		 PrefUtility.put(Constants.PREF_SELECTED_WEEK, selectedWeek);
		 PrefUtility.put(Constants.PREF_MAX_WEEK, maxWeek);
		 PrefUtility.put(Constants.PREF_CUR_XUEQI, curXueQi);
		Log.d(TAG, "currentWeek:" + currentWeek + ",selectedWeek:"
				+ selectedWeek + ",maxWeek:" + maxWeek);
		// Constants.setCurrentWeek(currentWeek);
		// Constants.setMaxWeek(maxWeek);
		// Constants.setSelectedWeek(selectedWeek);
		// TabHostActivity.currentWeek=currentWeek;
		// TabHostActivity.maxWeek=maxWeek;
		// TabHostActivity.selectedWeek=selectedWeek;

		Log.d(TAG, "------------------>jo:" + jo);
		Log.d(TAG, "------------------>寮?濮嬪噯澶囧垵濮嬪寲锛?" + new Date());
		classesStr = jo.optString("鎵?甯︾彮绾?");
		Log.d(TAG, "------------------>鎵?甯︾彮绾э細" + classesStr);
		if (classesStr != null) {
			String[] classes = classesStr.split(",");
			studentList = new HashMap<String,List<Student>>();
			for (int i = 0; i < classes.length; i++) {
				JSONArray stuArray = jo.optJSONArray(classes[i]);
				if (stuArray != null) {
					List<Student> students = Student.toList(stuArray);
					if (students != null && students.size() > 0) {
						studentList.put(classes[i],students);
					}
				}
			}
		}

		JSONObject jowasr = jo.optJSONObject("鑰冨嫟瑙勫垯");
		workAttendanceRules = new ArrayList<WorkAttendanceRule>();
		if (jowasr != null) {
			Log.d(TAG, "------------------>jowasr.length()锛?" + jowasr.length());
			Iterator<String> keys = jowasr.keys();
			Log.d(TAG, "------------------>keys锛?" + keys);
			String name, values;
			while (keys.hasNext()) {
				name = String.valueOf(keys.next());
				values = jowasr.optString(name);
				WorkAttendanceRule wrsr = new WorkAttendanceRule(name, values);
				workAttendanceRules.add(wrsr);
			}
		}
		JSONArray joasr = jo.optJSONArray("鍔犲垎瑙勫垯");
		if (joasr != null) {
			Log.d(TAG, "------------------>joasr.length()锛?" + joasr.length());
			addScoresRule = new ArrayList<AddScoresRule>();
			for (int i = 0; i < joasr.length(); i++) {
				AddScoresRule asr = new AddScoresRule(joasr.optJSONObject(i));
				addScoresRule.add(asr);
			}
		}
		JSONArray jorsr = jo.optJSONArray("鍑忓垎瑙勫垯");

		if (jorsr != null) {
			Log.d(TAG, "------------------>jorsr.length()锛?" + jorsr.length());
			reduceScoresRule = new ArrayList<ReduceScoresRule>();
			for (int i = 0; i < jorsr.length(); i++) {
				ReduceScoresRule rsr = new ReduceScoresRule(
						jorsr.optJSONObject(i));
				reduceScoresRule.add(rsr);
			}
		}
		JSONArray jotsr = jo.optJSONArray("鏁欏笀涓婅璁板綍");
		if (jotsr != null) {
			Log.d(TAG, "------------------>jotsr.length()锛?" + jotsr.length());
			teacherSchoolRecords = new ArrayList<TeacherSchoolRecords>();
			for (int i = 0; i < jotsr.length(); i++) {
				TeacherSchoolRecords tsr = new TeacherSchoolRecords(
						jotsr.optJSONObject(i));
				teacherSchoolRecords.add(tsr);
			}
		}
		// JSONObject jObject = jo.optJSONObject("璇惧爞娴嬮獙_鏀跺嵎");
		// Log.d(TAG, "------------------>璇惧爞娴嬮獙_鏀跺嵎锛?" + jObject);
		// if (jObject != null) {
		// String timeKey;
		// int timeValues;
		// startTestList = new ArrayList<TestStartEntity>();
		// Iterator<Object> keys = jObject.keys();
		// Log.d(TAG, "--------------璇惧爞娴嬮獙_鏀跺嵎--->keys锛?" + keys);
		// while (keys.hasNext()) {
		// timeKey = String.valueOf(keys.next());
		// timeValues = jObject.optInt(timeKey);
		// // map.put("key", timeKey);
		// // map.put("values", timeValues);
		// TestStartEntity testStartEntity = new
		// TestStartEntity(timeKey,timeValues);
		// startTestList.add(testStartEntity);
		// }
		//
		// for (int i = 0; i < startTestList.size() - 1; i++) {
		// for (int j = i + 1; j < startTestList.size(); j++) {
		// if (startTestList.get(i).getTimeValues() > startTestList
		// .get(j).getTimeValues()) {
		// TestStartEntity temp = new TestStartEntity(
		// startTestList.get(i).getTimeKey(),
		// startTestList.get(i).getTimeValues());
		// startTestList.set(i, startTestList.get(j));
		// startTestList.set(j, temp);
		// }
		// }
		// }
		// array = new int[childList.size()];
		// for (int i = 0; i < childList.size(); i++) {
		// array[i] = (Integer) childList.get(i).get("values");
		// }
		//

		// /**
		// * 瀛楃涓叉帓搴?
		// */
		// for (int i = 0; i < array.length - 1; i++) {
		// for (int j = i + 1; j < array.length; j++) {
		// if (array[i].compareTo(array[j]) > 0) {
		// String temp = array[i];
		// array[i] = array[j];
		// array[j] = temp;
		// }
		// }
		// }
		//
		// /**
		// * 鎺掑簭鍚庣殑瑙ｆ瀽鍥炴潵娣诲姞鍒發ist
		// */
		// for(int i = 0; i< array.length; i++){
		// int value = innerJObject.optInt(array[i]);
		// TestStartEntity mTestStartEntity = new TestStartEntity(array[i],
		// value);
		// startTestList.add(mTestStartEntity);
		// }
		// }

		JSONArray jotest = jo.optJSONArray("璇惧爞娴嬮獙_鏀跺嵎2");
		startTestList = new ArrayList<TestStartEntity>();
		if (jotest != null) {
			Log.d(TAG, "------------------>jotest.length()锛?" + jotest.length());
			for (int i = 0; i < jotest.length() - 1; i++) {
				TestStartEntity temp = new TestStartEntity(
						jotest.optJSONObject(i));
				startTestList.add(temp);
			}
		}

		JSONObject sdObj = jo.optJSONObject("璇捐〃瑙勫垯");
		Log.d(TAG, "------------------>璇捐〃瑙勫垯锛?" + sdObj);
		if (sdObj != null) {
			schedule = new Schedule(sdObj);
			Log.d(TAG, "------------------>schedule锛?" + schedule);
		}
		// }
		JSONObject sdObj2 = jo.optJSONObject("璇句欢涓嬭浇");
		Log.d(TAG, "------------------>璇句欢涓嬭浇锛?" + sdObj2);
		// if (sdObj2 != null) {
		// JSONArray jArray = sdObj2.optJSONArray("鏁版嵁");
		// downloadSubjects = DownloadSubject.toList(jArray);
		// }

		JSONArray tiArray = jo.optJSONArray("鏁欏笀涓婅璁板綍");

		if (tiArray != null) {
			Log.d(TAG,
					"------------------>tiArray.length()锛?" + tiArray.length());
			teacherInfos = TeacherInfo.toList(tiArray);
		}

		JSONArray jo1Array = jo.optJSONArray("璇惧爞娴嬮獙_鍐呭");

		if (jo1Array != null) {
			Log.d(TAG,
					"------------------>jo1Array.length()锛?" + jo1Array.length());
			testEntitys = TestEntity.toList(jo1Array);
		}

		JSONObject joStuInfo = jo.optJSONObject("瀛︾敓璇︽儏淇℃伅鍗?");
		Log.d(TAG, "------------------>瀛︾敓璇︽儏淇℃伅鍗★細" + joStuInfo);
		studentTab = new Dictionary();
		studentTab.setParentCode("studentTab");
		studentTab.setParentName("瀛︾敓璇︽儏淇℃伅鍗?");
		studentTab.setItemCode("瀛︾敓璇︽儏淇℃伅鍗?");
		if (joStuInfo != null) {
			String studata = joStuInfo.optString("鏁版嵁");
			if (AppUtility.isNotEmpty(studata)) {
				studentTab.setItemValue(studata);
			}
		}

		/**
		 * 鑰冨嫟缁熻
		 */
		JSONObject joAttence = jo.optJSONObject("瀛︾敓鑰冨嫟缁熻");
		Log.d(TAG, "------------------------->瀛︾敓鑰冨嫟缁熻:" + joAttence);
		// 鑰冨嫟缁熻棰滆壊
		studentAttenceColorList = new ArrayList<Dictionary>();
		dictionary = new Dictionary();
		dictionary.setParentCode("studentColor");
		dictionary.setParentName("瀛︾敓璇︽儏涓敤鍒扮殑棰滆壊");
		dictionary.setItemCode("鑰冨嫟缁熻棰滆壊");
		if (joAttence != null) {
			JSONArray stuArray = joAttence.optJSONArray("鏁版嵁");
			Log.d(TAG, "------------鏁版嵁----------");
			if (stuArray != null) {
				Log.d(TAG, "------------------------->鏁版嵁:" + stuArray.length());
				studentAttenceList = StudentAttence.toList(stuArray);
			}
			dictionary.setItemValue(joAttence.optString("棰滆壊"));
		}
		studentAttenceColorList.add(dictionary);

		/**
		 * 瀛︾敓鎴愮哗鏌ヨ
		 */
		Log.d(TAG, "---------瀛︾敓鎴愮哗鏌ヨ--------");
		JSONObject joScore = jo.optJSONObject("瀛︾敓鎴愮哗鏌ヨ");
		if (joScore != null) {
			JSONArray scoreArray = joScore.optJSONArray("鏁版嵁");
			if (scoreArray != null) {
				Log.d(TAG, "---------------scoreArray.length()--------"
						+ scoreArray.length());
				studentScoreList = StudentScore.toList(scoreArray);
			}
		}

		/**
		 * 瀛︾敓娴嬮獙缁熻
		 */
		JSONObject joTest = jo.optJSONObject("瀛︾敓娴嬮獙缁熻");
		Log.d(TAG, "------------------>瀛︾敓娴嬮獙缁熻锛?" + joTest);
		// 瀛︾敓娴嬮獙缁熻棰滆壊
		studentTestColorList = new ArrayList<Dictionary>();
		dictionary = new Dictionary();
		dictionary.setParentCode("studentColor");
		dictionary.setParentName("瀛︾敓璇︽儏涓敤鍒扮殑棰滆壊");
		dictionary.setItemCode("娴嬮獙缁熻棰滆壊");
		if (joTest != null) {
			JSONArray testArray = joTest.optJSONArray("鏁版嵁");
			Log.d(TAG, "------------鏁版嵁-------------");
			if (testArray != null) {
				Log.d(TAG,
						"------------testArray.length():" + testArray.length());
				studentTestList = StudentTest.toList(testArray);
			}
			dictionary.setItemValue(joTest.optString("棰滆壊"));
		}
		studentTestColorList.add(dictionary);
		
		JSONArray scheduleArray = jo.optJSONArray("鏈潵涓ゅ懆璇剧▼");

		if (scheduleArray != null) {
			Log.d(TAG,
					"------------------>tiArray.length()锛?" + tiArray.length());
			futureClassSchedule = MyClassSchedule.toList(scheduleArray);
		}
		Log.d(TAG, "------------------>缁撴潫鍑嗗鍒濆鍖栵細" + new Date());
	}

	public AllInfo(net.minidev.json.JSONObject jo) {
		curriculums = (jo.get("鎵?甯﹁绋?")==null?"":jo.get("鎵?甯﹁绋?").toString());
		companyName = jo.get("鍗曚綅鍚嶇О").toString();
		workAttendances = jo.get("鑰冨嫟鍚嶇О").toString();
		workAttendanceValues = jo.get("鑰冨嫟鍒嗗??").toString();
		allowSchoolrecordkeysStr = jo.get("鍏佽鏁欏笀淇敼鏁欏笀涓婅璁板綍淇℃伅瀛楁").toString();
		allowSchoolrecordSummaryKeysStr = jo.get("鍏佽鏁欏笀淇敼鏁欏笀涓婅璁板綍淇℃伅瀛楁_鎬荤粨").toString();
		allowSchoolrecordWorkAttendanceKeysStr = jo
				.get("鍏佽鏁欏笀淇敼鏁欏笀涓婅璁板綍淇℃伅瀛楁_鑰冨嫟").toString();
		currentWeek = Integer.parseInt(jo.get("褰撳墠鍛ㄦ").toString());
		selectedWeek = Integer.parseInt(jo.get("閫夋嫨鍛ㄦ").toString());
		maxWeek = Integer.parseInt(jo.get("鏈?澶у懆娆?").toString());
		curXueQi=jo.get("褰撳墠瀛︽湡").toString();
		PrefUtility.put(Constants.PREF_CURRICULUMS, curriculums);
		PrefUtility.put(Constants.PREF_CLASSES, classesStr);
		PrefUtility.put(Constants.PREF_COMPANY_NAME, companyName);
		PrefUtility.put(Constants.PREF_WORK_ATTENDANCES, workAttendances);
		PrefUtility.put(Constants.PREF_WORK_ATTENDANCE_VALUES,
				workAttendanceValues);
		PrefUtility.put(Constants.PREF_ALLOW_SCHOOL_RECORDKEYS_STR,
				allowSchoolrecordkeysStr);
		PrefUtility.put(Constants.PREF_ALLOW_SCHOOL_RECORD_SUMMARYKEYS_STR,
				allowSchoolrecordSummaryKeysStr);
		PrefUtility.put(
				Constants.PREF_ALLOW_SCHOOL_RECORDWORK_ATTENDANCEKEYS_STR,
				allowSchoolrecordWorkAttendanceKeysStr);
		 PrefUtility.put(Constants.PREF_CURRENT_WEEK, currentWeek);
		 PrefUtility.put(Constants.PREF_SELECTED_WEEK, selectedWeek);
		 PrefUtility.put(Constants.PREF_MAX_WEEK, maxWeek);
		 PrefUtility.put(Constants.PREF_CUR_XUEQI, curXueQi);
		classesStr = (jo.get("鎵?甯︾彮绾?")==null?"":jo.get("鎵?甯︾彮绾?").toString());
		Log.d(TAG, "------------------>鎵?甯︾彮绾э細" + classesStr);
		if (classesStr != null) {
			String[] classes = classesStr.split(",");
			studentList = new HashMap<String,List<Student>>();
			for (int i = 0; i < classes.length; i++) {
				net.minidev.json.JSONArray stuArray = (net.minidev.json.JSONArray) jo.get(classes[i]);
				if (stuArray != null) {
					List<Student> students = Student.toList(stuArray);
					if (students != null && students.size() > 0) {
						studentList.put(classes[i],students);
					}
				}
			}
		}

		net.minidev.json.JSONObject jowasr = (net.minidev.json.JSONObject) jo.get("鑰冨嫟瑙勫垯");
		
		workAttendanceRules = new ArrayList<WorkAttendanceRule>();
		
		if (jowasr != null) {
			Log.d(TAG, "------------------>jowasr.length()锛?" + jowasr.size());
			
			Set<String> keys = jowasr.keySet();
			Iterator<String> it=keys.iterator();
			String name, values;
			for (; it.hasNext();) {
				 
				name = String.valueOf(it.next());
				values =  String.valueOf(jowasr.get(name));
				WorkAttendanceRule wrsr = new WorkAttendanceRule(name, values);
				workAttendanceRules.add(wrsr);
			}
		}
		net.minidev.json.JSONObject joasr = (net.minidev.json.JSONObject)jo.get("鍔犲垎瑙勫垯");
		if (joasr != null) {
			Log.d(TAG, "------------------>joasr.length()锛?" + joasr.size());
			addScoresRule = new ArrayList<AddScoresRule>();
			
			Set<String> keys = jowasr.keySet();
			Iterator<String> it=keys.iterator();
			String name, values;
			for (; it.hasNext();) {
				 
				name = String.valueOf(it.next());
				values =  String.valueOf(jowasr.get(name));
				AddScoresRule wrsr = new AddScoresRule(name, values);
				addScoresRule.add(wrsr);
			}
			
			
		}
		net.minidev.json.JSONObject jorsr = (net.minidev.json.JSONObject)jo.get("鍑忓垎瑙勫垯");

		if (jorsr != null) {
			Log.d(TAG, "------------------>jorsr.length()锛?" + jorsr.size());
			reduceScoresRule = new ArrayList<ReduceScoresRule>();
			
			Set<String> keys = jowasr.keySet();
			Iterator<String> it=keys.iterator();
			String name, values;
			for (; it.hasNext();) {
				 
				name = String.valueOf(it.next());
				values =  String.valueOf(jowasr.get(name));
				ReduceScoresRule wrsr = new ReduceScoresRule(name, values);
				reduceScoresRule.add(wrsr);
			}
			
		}
		net.minidev.json.JSONArray jotsr =(net.minidev.json.JSONArray) jo.get("鏁欏笀涓婅璁板綍");
		if (jotsr != null) {
			Log.d(TAG, "------------------>jotsr.length()锛?" + jotsr.size());
			teacherSchoolRecords = new ArrayList<TeacherSchoolRecords>();
			for (int i = 0; i < jotsr.size(); i++) {
				TeacherSchoolRecords tsr = new TeacherSchoolRecords((net.minidev.json.JSONObject)jotsr.get(i));
				teacherSchoolRecords.add(tsr);
			}
		}
		

		net.minidev.json.JSONArray jotest = (net.minidev.json.JSONArray)jo.get("璇惧爞娴嬮獙_鏀跺嵎2");
		startTestList = new ArrayList<TestStartEntity>();
		if (jotest != null) {
			Log.d(TAG, "------------------>jotest.length()锛?" + jotest.size());
			
			for (int i = 0; i < jotest.size(); i++) {
				net.minidev.json.JSONObject item=(net.minidev.json.JSONObject)jotest.get(i);
				
				TestStartEntity temp = new TestStartEntity(item.get("鍚嶇О").toString(),Integer.parseInt(item.get("鍊?").toString()));
				startTestList.add(temp);
			}
		}

		net.minidev.json.JSONObject sdObj = (net.minidev.json.JSONObject)jo.get("璇捐〃瑙勫垯");
		Log.d(TAG, "------------------>璇捐〃瑙勫垯锛?" + sdObj);
		if (sdObj != null) {
			schedule = new Schedule(sdObj);
			Log.d(TAG, "------------------>schedule锛?" + schedule);
		}
		// }
		net.minidev.json.JSONObject sdObj2 = (net.minidev.json.JSONObject)jo.get("璇句欢涓嬭浇");
		Log.d(TAG, "------------------>璇句欢涓嬭浇锛?" + sdObj2);
		if (sdObj2 != null) {
			net.minidev.json.JSONArray jArray = (net.minidev.json.JSONArray)sdObj2.get("鏁版嵁");
			downloadSubjects = DownloadSubject.toList(jArray);
		}

		net.minidev.json.JSONArray tiArray = (net.minidev.json.JSONArray)jo.get("鏁欏笀涓婅璁板綍");

		if (tiArray != null) {
			Log.d(TAG,
					"------------------>tiArray.length()锛?" + tiArray.size());
			teacherInfos = TeacherInfo.toList(tiArray);
		}

		net.minidev.json.JSONArray jo1Array = (net.minidev.json.JSONArray)jo.get("璇惧爞娴嬮獙_鍐呭");

		if (jo1Array != null) {
			Log.d(TAG,
					"------------------>jo1Array.length()锛?" + jo1Array.size());
			testEntitys = TestEntity.toList(jo1Array);
		}

		net.minidev.json.JSONObject joStuInfo = (net.minidev.json.JSONObject)jo.get("瀛︾敓璇︽儏淇℃伅鍗?");
		Log.d(TAG, "------------------>瀛︾敓璇︽儏淇℃伅鍗★細" + joStuInfo);
		studentTab = new Dictionary();
		studentTab.setParentCode("studentTab");
		studentTab.setParentName("瀛︾敓璇︽儏淇℃伅鍗?");
		studentTab.setItemCode("瀛︾敓璇︽儏淇℃伅鍗?");
		if (joStuInfo != null) {
			String studata = String.valueOf(joStuInfo.get("鏁版嵁"));
			if (AppUtility.isNotEmpty(studata)) {
				studentTab.setItemValue(studata);
			}
		}

		/**
		 * 鑰冨嫟缁熻
		 */
		net.minidev.json.JSONObject joAttence =(net.minidev.json.JSONObject) jo.get("瀛︾敓鑰冨嫟缁熻");
		Log.d(TAG, "------------------------->瀛︾敓鑰冨嫟缁熻:" + joAttence);
		// 鑰冨嫟缁熻棰滆壊
		studentAttenceColorList = new ArrayList<Dictionary>();
		dictionary = new Dictionary();
		dictionary.setParentCode("studentColor");
		dictionary.setParentName("瀛︾敓璇︽儏涓敤鍒扮殑棰滆壊");
		dictionary.setItemCode("鑰冨嫟缁熻棰滆壊");
		if (joAttence != null) {
			net.minidev.json.JSONArray stuArray = (net.minidev.json.JSONArray)joAttence.get("鏁版嵁");
			Log.d(TAG, "------------鏁版嵁----------");
			if (stuArray != null) {
				Log.d(TAG, "------------------------->鏁版嵁:" + stuArray.size());
				studentAttenceList = StudentAttence.toList(stuArray);
			}
			dictionary.setItemValue(String.valueOf(joAttence.get("棰滆壊")));
		}
		studentAttenceColorList.add(dictionary);

		/**
		 * 瀛︾敓鎴愮哗鏌ヨ
		 */
		Log.d(TAG, "---------瀛︾敓鎴愮哗鏌ヨ--------");
		net.minidev.json.JSONObject joScore = (net.minidev.json.JSONObject)jo.get("瀛︾敓鎴愮哗鏌ヨ");
		if (joScore != null) {
			net.minidev.json.JSONArray scoreArray = (net.minidev.json.JSONArray)joScore.get("鏁版嵁");
			if (scoreArray != null) {
				Log.d(TAG, "---------------scoreArray.length()--------"
						+ scoreArray.size());
				studentScoreList = StudentScore.toList(scoreArray);
			}
		}

		/**
		 * 瀛︾敓娴嬮獙缁熻
		 */
		net.minidev.json.JSONObject joTest = (net.minidev.json.JSONObject)jo.get("瀛︾敓娴嬮獙缁熻");
		Log.d(TAG, "------------------>瀛︾敓娴嬮獙缁熻锛?" + joTest);
		// 瀛︾敓娴嬮獙缁熻棰滆壊
		studentTestColorList = new ArrayList<Dictionary>();
		dictionary = new Dictionary();
		dictionary.setParentCode("studentColor");
		dictionary.setParentName("瀛︾敓璇︽儏涓敤鍒扮殑棰滆壊");
		dictionary.setItemCode("娴嬮獙缁熻棰滆壊");
		if (joTest != null) {
			net.minidev.json.JSONArray testArray = (net.minidev.json.JSONArray)joTest.get("鏁版嵁");
			Log.d(TAG, "------------鏁版嵁-------------");
			if (testArray != null) {
				Log.d(TAG,
						"------------testArray.length():" + testArray.size());
				studentTestList = StudentTest.toList(testArray);
			}
			dictionary.setItemValue(String.valueOf(joTest.get("棰滆壊")));
		}
		studentTestColorList.add(dictionary);
		
		net.minidev.json.JSONArray joSchedule = (net.minidev.json.JSONArray)jo.get("鏈潵涓ゅ懆璇剧▼");
		if (joSchedule != null) {
			Log.d(TAG,
					"------------------>tiArray.length()锛?" + tiArray.size());
			futureClassSchedule = MyClassSchedule.toList(joSchedule);
		}
		Log.d(TAG, "------------------>缁撴潫鍑嗗鍒濆鍖栵細" + new Date());
	}
	public List<MyClassSchedule> getFutureClassSchedule() {
		return futureClassSchedule;
	}

	public void setFutureClassSchedule(List<MyClassSchedule> futureClassSchedule) {
		this.futureClassSchedule = futureClassSchedule;
	}

	/**
	 * 
	 * 瀛︾敓淇℃伅
	 */

	public List<TestStartEntity> getStartTestList() {
		return startTestList;
	}

	public List<TeacherInfo> getTeacherInfos() {
		return teacherInfos;
	}

	public void setTeacherInfos(List<TeacherInfo> teacherInfos) {
		this.teacherInfos = teacherInfos;
	}

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	public List<TestEntity> getTestEntitys() {
		return testEntitys;
	}

	public void setTestEntitys(List<TestEntity> testEntitys) {
		this.testEntitys = testEntitys;
	}

	public Map<String,List<Student>> getStudentList() {
		return studentList;
	}

	public void setStudentList(Map<String,List<Student>> studentList) {
		this.studentList = studentList;
	}

	public List<DownloadSubject> getDownloadSubjects() {
		return downloadSubjects;
	}

	public void setDownloadSubjects(List<DownloadSubject> downloadSubjects) {
		this.downloadSubjects = downloadSubjects;
	}

	public List<StudentAttence> getStudentAttenceList() {
		return studentAttenceList;
	}

	public void setStudentAttenceList(List<StudentAttence> studentAttenceList) {
		this.studentAttenceList = studentAttenceList;
	}

	public List<Dictionary> getStudentAttenceColorList() {
		return studentAttenceColorList;
	}

	public void setStudentAttenceColorList(
			List<Dictionary> studentAttenceColorList) {
		this.studentAttenceColorList = studentAttenceColorList;
	}

	public List<StudentScore> getStudentScoreList() {
		return studentScoreList;
	}

	public void setStudentScoreList(List<StudentScore> studentScoreList) {
		this.studentScoreList = studentScoreList;
	}

	public List<StudentTest> getStudentTestList() {
		return studentTestList;
	}

	public void setStudentTestList(List<StudentTest> studentTestList) {
		this.studentTestList = studentTestList;
	}

	public List<Dictionary> getStudentTestColorList() {
		return studentTestColorList;
	}

	public void setStudentTestColorList(List<Dictionary> studentTestColorList) {
		this.studentTestColorList = studentTestColorList;
	}

	public List<Dictionary> getStudentInfoList() {
		return studentInfoList;
	}

	public void setStudentInfoList(List<Dictionary> studentInfoList) {
		this.studentInfoList = studentInfoList;
	}

	public Dictionary getStudentTab() {
		return studentTab;
	}

	public void setStudentTab(Dictionary studentTab) {
		this.studentTab = studentTab;
	}

	public int getCurrentWeek() {
		return currentWeek;
	}

	public void setCurrentWeek(int currentWeek) {
		this.currentWeek = currentWeek;
	}

	public int getSelectedWeek() {
		return selectedWeek;
	}

	public void setSelectedWeek(int selectedWeek) {
		this.selectedWeek = selectedWeek;
	}

	public int getMaxWeek() {
		return maxWeek;
	}

	public void setMaxWeek(int maxWeek) {
		this.maxWeek = maxWeek;
	}

	// public List<StudentPic> getStudentPicList() {
	// return studentPicList;
	// }
	//
	// public void setStudentPicList(List<StudentPic> studentPicList) {
	// this.studentPicList = studentPicList;
	// }

}
