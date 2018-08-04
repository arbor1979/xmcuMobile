package com.xmcu.mobile.entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "DownloadInfo")
public class DownloadInfo {
	@DatabaseField(generatedId=true)
	private int id;
	@DatabaseField
	private int threadId;// 涓嬭浇鍣╥d
	@DatabaseField
	private int startPos;// 寮?濮嬬偣
	@DatabaseField
	private int endPos;// 缁撴潫鐐?
	@DatabaseField
	private int compeleteSize;// 瀹屾垚搴?
	@DatabaseField
	private String url;// 涓嬭浇鍣ㄧ綉缁滄爣璇?
	
	public DownloadInfo(){}
	
	public DownloadInfo(int threadId, int startPos, int endPos,
			int compeleteSize, String url) {
		this.threadId = threadId;
		this.startPos = startPos;
		this.endPos = endPos;
		this.compeleteSize = compeleteSize;
		this.url = url;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getThreadId() {
		return threadId;
	}

	public void setThreadId(int threadId) {
		this.threadId = threadId;
	}

	public int getStartPos() {
		return startPos;
	}

	public void setStartPos(int startPos) {
		this.startPos = startPos;
	}

	public int getEndPos() {
		return endPos;
	}

	public void setEndPos(int endPos) {
		this.endPos = endPos;
	}

	public int getCompeleteSize() {
		return compeleteSize;
	}

	public void setCompeleteSize(int compeleteSize) {
		this.compeleteSize = compeleteSize;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	/*@Override
	     public String toString() {
	         return "DownloadInfo [threadId=" + threadId
	                 + ", startPos=" + startPos + ", endPos=" + endPos
	                 + ", compeleteSize=" + compeleteSize +"]";
     }*/


}
