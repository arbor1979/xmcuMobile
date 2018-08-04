package com.xmcu.mobile.entity;

import android.graphics.drawable.Drawable;
/**
 * 娌熼?氣?斺?旂彮绾х兢缁勪腑鏁版嵁
 * @author hfthink
 *
 */
public class SortModel {
	/**
	 * 鐝骇鍚嶇О
	 */
	private String name;
	/**
	 * 鐝骇鍚嶇О棣栧瓧姣?
	 */
	private String sortLetters;
	/**
	 * 鐝骇澶村儚
	 */
	private Drawable img;

	public Drawable getImg() {
		return img;
	}

	public void setImg(Drawable img) {
		this.img = img;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSortLetters() {
		return sortLetters;
	}

	public void setSortLetters(String sortLetters) {
		this.sortLetters = sortLetters;
	}
}
