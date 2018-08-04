package com.xmcu.mobile.entity;

public class LoadInfo {

	public int fileSize;// 鏂囦欢澶у皬
	private int complete;// 瀹屾垚搴?
	private String urlstring;// 涓嬭浇鍣ㄦ爣璇?
	public LoadInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LoadInfo(int fileSize, int complete, String urlstring) {
		super();
		this.fileSize = fileSize;
		this.complete = complete;
		this.urlstring = urlstring;
	}
	public int getFileSize() {
		return fileSize;
	}
	public void setFileSize(int fileSize) {
		this.fileSize = fileSize;
	}
	public int getComplete() {
		return complete;
	}
	public void setComplete(int complete) {
		this.complete = complete;
	}
	public String getUrlstring() {
		return urlstring;
	}
	public void setUrlstring(String urlstring) {
		this.urlstring = urlstring;
	}
	@Override
	    public String toString() {
         return "LoadInfo [fileSize=" + fileSize + ", complete=" + complete
	                 + ", urlstring=" + urlstring + "]";
     }


}
