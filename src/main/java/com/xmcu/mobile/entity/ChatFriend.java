package com.xmcu.mobile.entity;

import java.util.Date;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * 娑堟伅鍒楄〃
 * @author hfthink
 *
 */
@DatabaseTable(tableName="ChatFriend")
public class ChatFriend {
	@DatabaseField(generatedId=true)
	private int id;
	/**
	 * 娑堟伅鎺ユ敹浜?
	 */
	@DatabaseField
	private String hostid; 
	
	/**
	 * 娑堟伅鎺ユ敹浜?
	 */
	@DatabaseField
	private String toid; 
	/**
	 * 缇ゅ悕绉?
	 */
	@DatabaseField
	private String toname;
	/**
	 * 鐢ㄦ埛澶村儚
	 */
	@DatabaseField
	private String userImage;
	/**
	 * 鑱婂ぉ鍐呭
	 */
	@DatabaseField
	private String lastContent;
	/**
	 * 鑱婂ぉ鏃堕棿
	 */
	@DatabaseField
	private Date lastTime;
	
	@DatabaseField
	private String type;
	/**
	 * 鏈娑堟伅鏁伴噺
	 */
	@DatabaseField
	private int unreadCnt=0;
	@DatabaseField
	private String msgType;
	
	
	public String getMsgType() {
		return msgType;
	}
	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getToid() {
		return toid;
	}
	public void setToid(String toid) {
		this.toid = toid;
	}
	
	public String getToname() {
		return toname;
	}
	public void setToname(String toname) {
		this.toname = toname;
	}
	public String getUserImage() {
		return userImage;
	}
	public void setUserImage(String userImage) {
		this.userImage = userImage;
	}
	public String getLastContent() {
		return lastContent;
	}
	public void setLastContent(String lastContent) {
		this.lastContent = lastContent;
	}
	public Date getLastTime() {
		return lastTime;
	}
	public void setLastTime(Date lastTime) {
		this.lastTime = lastTime;
	}
	public int getUnreadCnt() {
		return unreadCnt;
	}
	public void setUnreadCnt(int unreadCnt) {
		this.unreadCnt = unreadCnt;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getHostid() {
		return hostid;
	}
	public void setHostid(String hostid) {
		this.hostid = hostid;
	}
	
}
