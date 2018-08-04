package com.xmcu.mobile.entity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.JSONObject;

/**
 * 
 * #(c) ruanyun PocketCampus <br/>
 * 
 * 鐗堟湰璇存槑: $id:$ <br/>
 * 
 * 鍔熻兘璇存槑: 鏍″唴鑰冨嫟
 * 
 * <br/>
 * 鍒涘缓璇存槑: 2014-4-16 涓嬪崍2:06:15 shengguo 鍒涘缓鏂囦欢<br/>
 * 
 * 淇敼鍘嗗彶:<br/>
 * 
 */
public class WorkAttendanceItem {
	private String selectShortCutType[] = { "鏈?杩戜竴鍛?", "鏈?杩戜竴鏈?" };
	private String selectByWeekType[] = { "寮?濮嬪懆", "缁撴潫鍛?" };

	private String templateName;
	private String userPic;
	private String userName;
	private String sno;// 瀛﹀彿
	private String sClass;// 鐝骇
	private List<WorkAttendance> WorkAttendances;
	private List<SelectShortCut> SelectShortCuts;
	private List<SelectByWeek> SelectByWeeks;
	
	@SuppressWarnings("unchecked")
	public WorkAttendanceItem(JSONObject jo) {
		templateName = jo.optString("閫傜敤妯℃澘");
		userPic = jo.optString("鐢ㄦ埛澶村儚");
		userName = jo.optString("鐢ㄦ埛濮撳悕");
		sno = jo.optString("鐢ㄦ埛濮撳悕涓嬬涓?琛?");// 瀛﹀彿
		sClass = jo.optString("鐢ㄦ埛濮撳悕涓嬬浜岃");// 鐝骇
		String order=jo.optString("椤哄簭");
		String[] keyOrder=order.split(",");
		WorkAttendances = new ArrayList<WorkAttendance>();
		SelectShortCuts = new ArrayList<SelectShortCut>();
		SelectByWeeks = new ArrayList<SelectByWeek>();
		JSONObject jowa = jo.optJSONObject("鑰冨嫟鏁板??");
		
		for(int i=0;i<keyOrder.length;i++)
		{
			WorkAttendance wa = new WorkAttendance(jowa.optJSONObject(keyOrder[i]));
			WorkAttendances.add(wa);
		}
		
		JSONObject jossc = jo.optJSONObject("蹇嵎鏌ヨ");
		for (int i = 0; i < 2; i++) {
			JSONObject josscitem = jossc.optJSONObject(selectShortCutType[i]);
			SelectShortCut ssc = new SelectShortCut(josscitem);
			SelectShortCuts.add(ssc);
		}
		JSONObject josbw = jo.optJSONObject("鎸夊懆鏌ヨ");
		for (int i = 0; i < 2; i++) {
			JSONObject josbwitem = josbw.optJSONObject(selectByWeekType[i]);
			SelectByWeek sbw = new SelectByWeek(josbwitem);
			SelectByWeeks.add(sbw);
		}
	}

	/**
	 * 鑰冨嫟
	 */
	public class WorkAttendance {
		private String value;// 鏁伴噺
		private String name;// 鍚嶇О
		private String background;// 鑳屾櫙鍥剧墖鍦板潃
		private String icon;// 鍥炬爣鍦板潃
		private String contentUrl;// 鍐呭椤瑰湴鍧?

		public WorkAttendance(JSONObject jo) {
			value = jo.optString("鍊?");// 鏁伴噺
			name = jo.optString("鍚嶇О");// 鍚嶇О
			background = jo.optString("鍥剧墖鑳屾櫙");
			icon = jo.optString("鑰冨嫟鍥炬爣");
			contentUrl = jo.optString("鍐呭椤筓RL");
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}


		public String getBackground() {
			return background;
		}

		public void setBackground(String background) {
			this.background = background;
		}

		public String getIcon() {
			return icon;
		}

		public void setIcon(String icon) {
			this.icon = icon;
		}

		public String getContentUrl() {
			return contentUrl;
		}

		public void setContentUrl(String contentUrl) {
			this.contentUrl = contentUrl;
		}
	}

	/**
	 * 蹇嵎鏌ヨ
	 */
	public class SelectShortCut {
		private String name;
		private String contentUrl;// 鍐呭椤瑰湴鍧?

		public SelectShortCut(JSONObject jo) {
			this.name = jo.optString("鍚嶇О");
			this.contentUrl = jo.optString("鍐呭椤筓RL");
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getContentUrl() {
			return contentUrl;
		}

		public void setContentUrl(String contentUrl) {
			this.contentUrl = contentUrl;
		}

	}

	/**
	 * 鎸夊懆鏌ヨ
	 */
	public class SelectByWeek {
		private String name;
		private String defaultValue;// 瀛﹀彿
		private String value;
		private String contentUrl;// 鍐呭椤瑰湴鍧?

		public SelectByWeek(JSONObject jo) {
			name = jo.optString("鍚嶇О");
			defaultValue = jo.optString("榛樿");
			value = jo.optString("鍊?");
			contentUrl = jo.optString("鍐呭椤筓RL");
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getDefaultValue() {
			return defaultValue;
		}

		public void setDefaultValue(String defaultValue) {
			this.defaultValue = defaultValue;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public String getContentUrl() {
			return contentUrl;
		}

		public void setContentUrl(String contentUrl) {
			this.contentUrl = contentUrl;
		}
	}

	public String getTemplateName() {
		return templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	public String getUserPic() {
		return userPic;
	}

	public void setUserPic(String userPic) {
		this.userPic = userPic;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getSno() {
		return sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}

	public String getsClass() {
		return sClass;
	}

	public void setsClass(String sClass) {
		this.sClass = sClass;
	}

	public List<WorkAttendance> getWorkAttendances() {
		return WorkAttendances;
	}

	public void setWorkAttendances(List<WorkAttendance> workAttendances) {
		WorkAttendances = workAttendances;
	}

	public List<SelectShortCut> getSelectShortCuts() {
		return SelectShortCuts;
	}

	public void setSelectShortCuts(List<SelectShortCut> selectShortCuts) {
		SelectShortCuts = selectShortCuts;
	}

	public List<SelectByWeek> getSelectByWeeks() {
		return SelectByWeeks;
	}

	public void setSelectByWeeks(List<SelectByWeek> selectByWeeks) {
		SelectByWeeks = selectByWeeks;
	}

}
