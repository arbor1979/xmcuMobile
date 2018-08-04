package com.xmcu.mobile.entity;

import org.json.JSONObject;

/**
 * 
 * #(c) ruanyun PocketCampus <br/>
 * 
 * 鐗堟湰璇存槑: $id:$ <br/>
 * 
 * 鍔熻兘璇存槑: 鍔犲垎瑙勫垯
 * 
 * <br/>
 * 鍒涘缓璇存槑: 2014-4-16 涓嬪崍2:06:15 shengguo 鍒涘缓鏂囦欢<br/>
 * 
 * 淇敼鍘嗗彶:<br/>
 * 
 */
public class AddScoresRule {
	private String value;// 鍒嗗??
	private String name;// 鍚嶇О

	public AddScoresRule() {
	}

	public AddScoresRule(String value, String name) {
		this.value = value;
		this.name = name;
	}

	public AddScoresRule(JSONObject jo) {
		value = jo.optString("鍊?");// 鏁伴噺
		name = jo.optString("鍚嶇О");// 鍚嶇О
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

}
