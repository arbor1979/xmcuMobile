package com.xmcu.mobile.entity;

import java.util.ArrayList;
import java.util.List;

import android.graphics.Bitmap;
/**
 * 鍙戝姩鎬佷腑鏈湴鍥剧墖淇℃伅
 * @author shengguo
 */
public class ImageInfo {

	public int id;
	public Bitmap icon;//璺緞涓嬬殑涓?寮犲浘鐗?
	public String displayName;//
	public String path;//鏂囦欢璺緞
	public int picturecount;//鍥剧墖鏁伴噺
	public List<String> tag=new ArrayList<String>();//璺緞涓嬪浘鐗囪矾寰勯泦鍚?
}
