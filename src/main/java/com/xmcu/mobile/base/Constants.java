package com.xmcu.mobile.base;



public class Constants {

	// 鍚戞湇鍔″櫒鎻愪氦鍙傛暟鍚?
	public static final String PARAMS_DATA = "DATA";
	/**
	 * 瀛︽牎鏈嶅姟鍣ㄥ湴鍧?
	 */
	public static final String PREF_SCHOOL_DOMAIN = "pref.school_domain";
	/**
	 * 鐢ㄦ埛
	 */
	public static final String PREF_SITE_URL = "pref.check_site_url";
	public static final String PREF_LOGIN_NAME = "pref.check_login_name";
	public static final String PREF_LOGIN_ID = "pref.check_login_id";
	/**
	 * 瀵嗙爜
	 */
	public static final String PREF_LOGIN_PASS = "pref.check_login_pass";
	/**
	 * 鍒ゆ柇鏄惁鏄厛琛屼綋楠?
	 */
	public static final String PREF_CHECK_TEST = "pref.check_test";

	/**
	 * 鍒ゆ柇杞欢鏄惁杩愯杩?
	 */
	public static final String PREF_CHECK_RUN = "pref.check_run";
	// 淇濆瓨鍙傛暟
	/**
	 * 鐢ㄦ埛鏍￠獙鐮?
	 */
	public static final String PREF_CHECK_CODE = "pref.check_code";
	
	public static final String PREF_CHECK_USERID = "pref.check_userid";
	public static final String PREF_CHECK_SCLASS = "pref.check_sclass";
	public static final String PREF_CHECK_REALNAME = "pref.check_realname";
	/**
	 * 鐢ㄦ埛鍞竴鐮?
	 */
	public static final String PREF_CHECK_HOSTID = "pref.check_hostid";
	/**
	 * 鐢ㄦ埛绫诲瀷
	 */
	public static final String PREF_CHECK_USERTYPE = "pref.check_usertype";
	/**
	 * 鍒濆鍖栧熀纭?鏁版嵁鏍囪
	 */
	public static final String PREF_INIT_BASEDATE_FLAG = "pref.init_basedate_flag";

	/**
	 * 鍒濆鍖栬仈绯讳汉鏍囪
	 */
	public static final String PREF_INIT_CONTACT_FLAG = "pref.init_contact_flag";
	public static final String PREF_INIT_CONTACT_STR = "pref.init_contact_str";
	public static final String PREF_INIT_DATA_STR = "pref.init_data_str";

	/**
	 * 鍒濆鍖栨爣璁?
	 */
	public static final String PREF_BAIDU_USERID = "pref.baidu_userid";
	/**
	 * 琛ㄦ儏鏁伴噺
	 */
	public static final int express_counts = 107;

	/**
	 * 鎵?甯﹁绋?
	 */
	public static final String PREF_CURRICULUMS = "pref.curriculums";
	/**
	 * 鎵?甯︾彮绾?
	 */
	public static final String PREF_CLASSES = "pref.classes";
	/**
	 * 鍗曚綅鍚嶇О
	 */
	public static final String PREF_COMPANY_NAME = "pref.company_name";
	/**
	 * 鑰冨嫟鍚嶇О
	 */
	public static final String PREF_WORK_ATTENDANCES = "pref.work_attendances";
	/**
	 * 鑰冨嫟鍒嗗??
	 */
	public static final String PREF_WORK_ATTENDANCE_VALUES = "pref.work_attendance_values";
	/**
	 * 鍏佽鏁欏笀淇敼鏁欏笀涓婅璁板綍淇℃伅瀛楁
	 */
	public static final String PREF_ALLOW_SCHOOL_RECORDKEYS_STR = "pref.allow_school_recordkeys_str";
	/**
	 * 鍏佽鏁欏笀淇敼鏁欏笀涓婅璁板綍淇℃伅瀛楁_鎬荤粨
	 */
	public static final String PREF_ALLOW_SCHOOL_RECORD_SUMMARYKEYS_STR = "pref.allow_school_record_summarykeys_str";
	/**
	 * 鍏佽鏁欏笀淇敼鏁欏笀涓婅璁板綍淇℃伅瀛楁_鑰冨嫟
	 */
	public static final String PREF_ALLOW_SCHOOL_RECORDWORK_ATTENDANCEKEYS_STR = "pref.allow_school_record_work_attendancekeys_str";
	/**
	 * 褰撳墠鍛ㄦ
	 */
	public static final String PREF_CURRENT_WEEK = "pref.current_week";
	/**
	 * 閫夋嫨鍛ㄦ
	 */
	public static final String PREF_SELECTED_WEEK = "pref.selected_week";
	/**
	 * 鏈?澶у懆娆?
	 */
	public static final String PREF_MAX_WEEK = "pref.max_week";
	/**
	 * 褰撳墠瀛︽湡
	 */
	public static final String PREF_CUR_XUEQI = "pref.cur_xueqi";

	/**
	 * 鑾峰彇鍥剧墖
	 */
	public static final String GET_PICTURE = "get_picture";

	/**
	 * 鏌ョ湅璇﹀浘鎴栧垹闄ゅ浘鐗?
	 */
	public static final String DEL_OR_LOOK_PICTURE = "del_or_look_picture";
	/**
	 * 褰撳墠鍛ㄦ
	 */
	public static int currentWeek = 0;
	/**
	 * 閫夋嫨鍛ㄦ
	 */
	public static int selectedWeek = 0;
	/**
	 * 閫夋嫨鍛ㄦ
	 */
	public static int maxWeek = 0;
	
	//璇句欢鏈?澶ф枃浠跺ぇ灏?
	public static int kejianMaxSize =1024*1024*100;
	// public static int getCurrentWeek() {
	// return currentWeek;
	// }
	// public static void setCurrentWeek(int currentWeek) {
	// System.out.println("Constants.currentWeek:"+Constants.currentWeek);
	// Constants.currentWeek = currentWeek;
	// System.out.println("Constants.currentWeek:"+Constants.currentWeek);
	// }
	// public static int getSelectedWeek() {
	// return selectedWeek;
	// }
	// public static void setSelectedWeek(int selectedWeek) {
	// System.out.println("Constants.selectedWeek:"+Constants.selectedWeek);
	// Constants.selectedWeek = selectedWeek;
	// System.out.println("Constants.selectedWeek:"+Constants.selectedWeek);
	// }
	// public static int getMaxWeek() {
	// return maxWeek;
	// }
	// public static void setMaxWeek(int maxWeek) {
	// System.out.println("Constants.maxWeek:"+Constants.maxWeek);
	// Constants.maxWeek = maxWeek;
	// System.out.println("Constants.maxWeek:"+Constants.maxWeek);
	// }
}
