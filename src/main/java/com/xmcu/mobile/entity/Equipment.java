package com.xmcu.mobile.entity;

import java.io.Serializable;

import org.json.JSONObject;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
/**
 * 
 *  #(c) ruanyun PocketCampus <br/>
 *
 *  鐗堟湰璇存槑: $id:$ <br/>
 *
 *  鍔熻兘璇存槑: 鐢ㄦ埛鐧诲綍璁惧淇℃伅
 * 
 *  <br/>鍒涘缓璇存槑: 2014-4-22 涓嬪崍4:40:28 shengguo  鍒涘缓鏂囦欢<br/>
 * 
 *  淇敼鍘嗗彶:<br/>
 *
 */
@DatabaseTable(tableName = "equipment")
public class Equipment implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 790471034666598343L;
	/** 
     * foreign = true:璇存槑杩欐槸涓?涓閮ㄥ紩鐢ㄥ叧绯? 
     * foreignAutoRefresh = true锛氬綋瀵硅薄琚煡璇㈡椂锛屽閮ㄥ睘鎬ц嚜鍔ㄥ埛鏂帮紙鏆傛椂鎴戜篃娌＄湅鎳傚叾浣滅敤锛? 
     *  
     */ 
	@DatabaseField (foreign = true, foreignAutoRefresh = true,columnName = "User")
	private User user;
	@DatabaseField
	private String id;
	@DatabaseField
	private String iosDeviceToken;
	@DatabaseField
	private String name;
	@DatabaseField
	private String localModal;
	@DatabaseField
	private String systemName;
	@DatabaseField
	private String systemVersion;
	
	public Equipment() {

	}
	
	public Equipment(JSONObject jo) {
		id = jo.optString("璁惧鍞竴鐮?");
		iosDeviceToken = jo.optString("IosDeviceToken");
		name = jo.optString("璁惧鍚?");
		localModal = jo.optString("鏈湴妯″紡");
		systemName = jo.optString("绯荤粺鍚?");
		systemVersion = jo.optString("绯荤粺鐗堟湰");
	}
	
	public Equipment(net.minidev.json.JSONObject jo) {
		id = String.valueOf(jo.get("璁惧鍞竴鐮?"));
		iosDeviceToken = String.valueOf(jo.get("IosDeviceToken"));
		name = String.valueOf(jo.get("璁惧鍚?"));
		localModal = String.valueOf(jo.get("鏈湴妯″紡"));
		systemName = String.valueOf(jo.get("绯荤粺鍚?"));
		systemVersion = String.valueOf(jo.get("绯荤粺鐗堟湰"));
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public String getIosDeviceToken() {
		return iosDeviceToken;
	}

	public void setIosDeviceToken(String iosDeviceToken) {
		this.iosDeviceToken = iosDeviceToken;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocalModal() {
		return localModal;
	}

	public void setLocalModal(String localModal) {
		this.localModal = localModal;
	}

	public String getSystemName() {
		return systemName;
	}

	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}

	public String getSystemVersion() {
		return systemVersion;
	}

	public void setSystemVersion(String systemVersion) {
		this.systemVersion = systemVersion;
	}
}