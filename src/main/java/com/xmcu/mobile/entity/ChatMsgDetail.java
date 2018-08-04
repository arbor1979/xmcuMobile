package com.xmcu.mobile.entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * 娌熼?氳亰澶╃晫闈㈡暟鎹?
 * @author hfthink
 *
 */
@DatabaseTable(tableName="ChatMsgDetail")
public class ChatMsgDetail {
	@DatabaseField(generatedId=true)
	private int id;
	
	/**
	 * 娑堟伅鍙戦?佷汉
	 */
	@DatabaseField(generatedId=false)
	private int mainid; 
	/**
	 * 娑堟伅鎺ユ敹浜?
	 */
	@DatabaseField
	private String toid; 
	@DatabaseField
	private String msg_id; 
	
	@DatabaseField
	private String sendstate; 
	
	
	public String getMsg_id() {
		return msg_id;
	}
	public void setMsg_id(String msg_id) {
		this.msg_id = msg_id;
	}
	

	public ChatMsgDetail(){
		toid="";
		sendstate="";
		msg_id="";
	}
	public ChatMsgDetail(int mainid,String toid,String msgid,String sendstate){
		this.mainid=mainid;
		this.toid=toid;
		this.msg_id=msgid;
		this.sendstate=sendstate;
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
	public int getMainid() {
		return mainid;
	}
	public void setMainid(int mainid) {
		this.mainid = mainid;
	}
	public String getSendstate() {
		return sendstate;
	}
	public void setSendstate(String sendstate) {
		this.sendstate = sendstate;
	}
	
	
}
