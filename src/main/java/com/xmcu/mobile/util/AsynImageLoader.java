package com.xmcu.mobile.util;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

import android.graphics.Bitmap;
import android.os.Handler;
import android.util.Log;
import android.widget.ImageView;

/**
 * 鍒╃敤澶氱嚎绋嬪紓姝ュ姞杞藉浘鐗囧苟鏇存柊瑙嗗浘
 * 
 * @author 
 * 
 */
public final class AsynImageLoader {

	private LoaderThread thread;// 鍔犺浇鍥剧墖骞跺彂娑堟伅閫氱煡鏇存柊鐣岄潰鐨勭嚎绋?
	private HashMap<String, SoftReference<Bitmap>> imageCache;// 鍥剧墖瀵硅薄缂撳瓨锛宬ey:鍥剧墖鐨剈rl
	private Handler handler;// 鐣岄潰Activity鐨凥andler瀵硅薄

	private int size ; //鍥剧墖鍘嬬缉澶у皬 涓?0鍒欎笉鍘嬬缉
	private int roundPx ; //璁剧疆鍥剧墖鍦嗚鐨勫?? 涓?0鍒欎笉璁剧疆鍦嗚
	
	public AsynImageLoader(Handler handler) {
		imageCache = new HashMap<String, SoftReference<Bitmap>>();
		this.handler = handler;
	}

	/**
	 * 鍔犺浇鍥剧墖鍓嶆樉绀哄埌鎸囧畾鐨処mageView涓紝鍥剧墖鐨剈rl淇濆瓨鍦ㄨ鍥惧璞＄殑Tag涓?
	 * 
	 * @param imageView
	 *            瑕佹樉绀哄浘鐗囩殑瑙嗗浘
	 * @param defaultBitmap
	 *            鍔犺浇闇?瑕佹樉绀虹殑鎻愮ず姝ｅ湪鍔犺浇鐨勯粯璁ゅ浘鐗囧璞?
	 */
	public void loadBitmap(ImageView imageView,Bitmap defaultBitmap,int size,int roundPx) {
		this.size = size;
		this.roundPx = roundPx;
		
		// 鍥剧墖鎵?瀵瑰簲鐨剈rl,杩欎釜鍊煎湪鍔犺浇鍥剧墖杩囩▼涓緢鍙兘浼氳鏀瑰彉
		String url = (String) imageView.getTag();
		if (imageCache.containsKey(url)) {// 鍒ゆ柇缂撳瓨涓槸鍚︽湁
			SoftReference<Bitmap> softReference = imageCache.get(url);
			Bitmap bitmap = softReference.get();
			if (bitmap != null) {// 濡傛灉鍥剧墖瀵硅薄涓嶄负绌猴紝鍒欏彲鎸傛帴鏇存柊瑙嗗浘锛屽苟杩斿洖
				imageView.setImageBitmap(bitmap);
				return;
			} else {// 濡傛灉涓虹┖锛岄渶瑕佸皢鍏朵粠缂撳瓨涓垹闄わ紙鍏禸itmap瀵硅薄宸茶鍥炴敹閲婃斁锛岄渶瑕侀噸鏂板姞杞斤級
				Log.e("TAG", "cache bitmap is null");
				imageCache.remove(url);
			}
		}
		//imageView.setImageBitmap(defaultBitmap);// 鍏堟樉绀轰竴涓彁绀烘鍦ㄥ姞杞界殑鍥剧墖
		if (thread == null) {// 鍔犺浇绾跨▼涓嶅瓨鍦紝绾跨▼杩樻湭鍚姩锛岄渶瑕佹柊寤虹嚎绋嬪苟鍚姩
			thread = new LoaderThread(imageView, url);
			thread.start();
		} else {// 濡傛灉瀛樺湪锛屽氨璋冪敤绾跨▼瀵硅薄鍘诲姞杞?
			thread.load(imageView, url);
		}

	}

	/**
	 * 閲婃斁缂撳瓨涓墍鏈夌殑Bitmap瀵硅薄锛屽苟灏嗙紦瀛樻竻绌?
	 */
	public void releaseBitmapCache() {
		if (imageCache != null) {
			for (Entry<String, SoftReference<Bitmap>> entry : imageCache.entrySet()) {
				Bitmap bitmap = entry.getValue().get();
				if (bitmap != null) {
					bitmap.recycle();// 閲婃斁bitmap瀵硅薄
				}
			}
			imageCache.clear();
		}
	}

	/**
	 * 鍔犺浇鍥剧墖骞舵樉绀虹殑绾跨▼
	 */
	private class LoaderThread extends Thread {

		LinkedHashMap<String, ImageView> mTaskMap;// 闇?瑕佸姞杞藉浘鐗囧苟鏄剧ず鐨勫浘鐗囪鍥惧璞′换鍔￠摼
		private boolean mIsWait;// 鏍囪瘑鏄嚎绋嬫槸鍚﹀浜庣瓑寰呯姸鎬?

		public LoaderThread(ImageView imageView, String url) {
			mTaskMap = new LinkedHashMap<String, ImageView>();
			mTaskMap.put(url, imageView);
		}

		/**
		 * 澶勭悊鏌愪釜瑙嗗浘鐨勬洿鏂版樉绀?
		 * 
		 * @param imageView
		 */
		public void load(ImageView imageView, String url) {
			mTaskMap.remove(imageView);// 浠诲姟閾句腑鍙兘鏈夛紝寰楀厛鍒犻櫎
			mTaskMap.put(url, imageView);// 灏嗗叾娣诲姞鍒颁换鍔′腑
			if (mIsWait) {// 濡傛灉绾跨▼姝ゆ椂澶勪簬绛夊緟寰楀敜閱掔嚎绋嬪幓澶勭悊浠诲姟闃熷垪涓緟澶勭悊鐨勪换鍔?
				synchronized (this) {// 璋冪敤瀵硅薄鐨刵otify()鏃跺繀椤诲悓姝?
					this.notify();
				}
			}
		}

		@Override
		public void run() {
			while (mTaskMap.size() > 0) {// 褰撻槦鍒椾腑鏈夋暟鎹椂绾跨▼灏辫涓?鐩磋繍琛?,涓?鏃﹁繘鍏ュ氨瑕佷繚璇佸叾涓嶄細璺冲嚭寰幆
				mIsWait = false;
				final String url  = mTaskMap.keySet().iterator().next();
				final ImageView imageView = mTaskMap.remove(url);
				if (imageView.getTag() == url) {// 鍒ゆ柇瑙嗗浘鏈夋病鏈夊鐢紙涓?鏃mageView琚鐢紝鍏秚ag鍊煎氨浼氫慨鏀瑰彉锛?
					final Bitmap bitmap = ImageUtility.getbitmap(url);// 姝ゆ柟娉曞簲璇ユ槸浠庣綉缁滄垨sd鍗′腑鍔犺浇
					try {
						Thread.sleep(100);// 妯℃嫙缃戠粶鍔犺浇鏁版嵁鏃堕棿
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
					// 灏嗗姞杞界殑鍥剧墖鏀惧叆缂撳瓨map涓?
					imageCache.put(url, new SoftReference<Bitmap>(bitmap));
					if (url == imageView.getTag()) {// 鍐嶆鍒ゆ柇瑙嗗浘鏈夋病鏈夊鐢?
						handler.post(new Runnable() {// 閫氳繃娑堟伅鏈哄埗鍦ㄤ富绾跨▼涓洿鏂癠I
							@Override
							public void run() {
								imageView.setImageBitmap(getBitmap(bitmap));
							}
						});
					}
				}
				if (mTaskMap.isEmpty()) {// 褰撲换鍔￠槦鍒椾腑娌℃湁寰呭鐞嗙殑浠诲姟鏃讹紝绾跨▼杩涘叆绛夊緟鐘舵??
					try {
						mIsWait = true;// 鏍囪瘑绾跨▼鐨勭姸鎬侊紝蹇呴』鍦╳ait()鏂规硶涔嬪墠
						synchronized (this) {
							this.wait();// 淇濈敤绾跨▼杩涘叆绛夊緟鐘舵?侊紝鐩村埌鏈夋柊鐨勪换鍔¤鍔犲叆鏃堕?氱煡鍞ら啋
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	public Bitmap getBitmap (Bitmap bitmap){
		if (size > 0) {
			bitmap = ImageUtility.zoomBitmap(bitmap, size, size); //灏嗗浘鐗囧帇缂?
		}
		if (roundPx > 0) {
			bitmap = ImageUtility.getRoundedCornerBitmap(bitmap, roundPx); //灏嗗浘鐗囧帇缂?
		}
		return bitmap;
	}
	
	
	
}