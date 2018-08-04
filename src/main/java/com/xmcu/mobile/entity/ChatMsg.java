package com.xmcu.mobile.entity;

import java.util.Date;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * 娌熼?氳亰澶╃晫闈㈡暟鎹?
 * @author hfthink
 *
 */
@DatabaseTable(tableName="ChatMsg")
public class ChatMsg {
	@DatabaseField(generatedId=true)
	private int id;
	
	/**
	 * 娑堟伅鍙戦?佷汉
	 */
	
	@DatabaseField
	private String hostid; 
	/**
	 * 娑堟伅鎺ユ敹浜?
	 */
	@DatabaseField
	private String toid; 
	
	@DatabaseField
	private String toname; 
	/**
	 * 鑱婂ぉ鍐呭
	 */
	@DatabaseField
	private String content;
	
	/**
	 * 鑱婂ぉ鏃堕棿
	 */
	@DatabaseField
	private Date time;
	
	/**
	 * 鍒ゆ柇娑堟伅鏄惁鏄櫥褰曚汉鍙戦?? 1鎴戝彂閫佺殑 0瀵规柟鍙戦?佺殑
	 */
	@DatabaseField
	private int msgFlag;
	
	@DatabaseField
	private String type;
	
	@DatabaseField
	private String remoteimage;
	
	@DatabaseField
	private String msg_id;
	
	public String getMsg_id() {
		return msg_id;
	}
	public void setMsg_id(String msg_id) {
		this.msg_id = msg_id;
	}
	public String getRemoteimage() {
		return remoteimage;
	}
	public void setRemoteimage(String remoteimage) {
		this.remoteimage = remoteimage;
	}
	public String getSendstate() {
		return sendstate;
	}
	public void setSendstate(String sendstate) {
		this.sendstate = sendstate;
	}
	@DatabaseField
	private String sendstate;
	public ChatMsg(){
		sendstate="";
		remoteimage="";
		msg_id="";
	}
	
//	public static List<ChatMsg> toList(JSONArray ja) {
//		List<ChatMsg> result = new ArrayList<ChatMsg>();
//		ChatMsg info = null;
//		if (ja.length() == 0) {
//			return null;
//		} else {
//			for (int i = 0; i < ja.length(); i++) {
//				JSONObject jo = ja.optJSONObject(i);
//				info = new ChatMsg(jo);
//				result.add(info);
//			}
//			return result;
//		}
//	
//	}
	
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public int getMsgFlag() {
		return msgFlag;
	}
	public void setMsgFlag(int msgFlag) {
		this.msgFlag = msgFlag;
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
