package com.xmcu.mobile.service;

import java.io.File;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.xmcu.mobile.db.DownloaderDao;
import com.xmcu.mobile.entity.DownloadInfo;
import com.xmcu.mobile.entity.LoadInfo;
import com.xmcu.mobile.util.AppUtility;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

public class Downloader {
	private String urlstr;// 涓嬭浇鐨勫湴鍧?
	private String localfile;// 淇濆瓨璺緞
	private int threadcount;// 绾跨▼鏁?
	private Handler mHandler;// 娑堟伅澶勭悊鍣?
	private DownloaderDao dao;// 宸ュ叿绫?
	private int fileSize;// 鎵?瑕佷笅杞界殑鏂囦欢鐨勫ぇ灏?
	private List<DownloadInfo> infos;// 瀛樻斁涓嬭浇淇℃伅绫荤殑闆嗗悎
	private static final int INIT = 1;// 瀹氫箟涓夌涓嬭浇鐨勭姸鎬侊細鍒濆鍖栫姸鎬侊紝姝ｅ湪涓嬭浇鐘舵?侊紝鏆傚仠鐘舵??
	private static final int DOWNLOADING = 2;
	private static final int PAUSE = 3;
	private int state = INIT;
	private Context context;

	public Downloader(String urlstr, String localfile, int threadcount,
			Context context, Handler mHandler) {
		this.urlstr = urlstr;
		this.localfile = localfile;
		this.threadcount = threadcount;
		this.mHandler = mHandler;
		this.context = context;
		dao = new DownloaderDao(context);
	}

	/**
	 * 鍒ゆ柇鏄惁姝ｅ湪涓嬭浇
	 */
	public boolean isdownloading() {
		return state == DOWNLOADING;
	}

	/**
	 * 寰楀埌downloader閲岀殑淇℃伅 棣栧厛杩涜鍒ゆ柇鏄惁鏄涓?娆′笅杞斤紝濡傛灉鏄涓?娆″氨瑕佽繘琛屽垵濮嬪寲锛屽苟灏嗕笅杞藉櫒鐨勪俊鎭繚瀛樺埌鏁版嵁搴撲腑
	 * 濡傛灉涓嶆槸绗竴娆′笅杞斤紝閭ｅ氨瑕佷粠鏁版嵁搴撲腑璇诲嚭涔嬪墠涓嬭浇鐨勪俊鎭紙璧峰浣嶇疆锛岀粨鏉熶负姝紝鏂囦欢澶у皬绛夛級锛屽苟灏嗕笅杞戒俊鎭繑鍥炵粰涓嬭浇鍣?
	 */
	public LoadInfo getDownloaderInfors() {
		int totalsize=0;
		int downsize=0;
		boolean isfirst = false;
		int size = 0;
		int compeleteSize = 0;
		if (isFirst(urlstr)) {
			isfirst = true;
			init();
			
			int waittimes=3;
			try {
				while (fileSize == 0 && waittimes > 0) {
					Thread.sleep(1000);
					waittimes--;
				}
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			int range = fileSize / threadcount;
			infos = new ArrayList<DownloadInfo>();
			for (int i = 0; i < threadcount - 1; i++) {
				DownloadInfo info = new DownloadInfo(i, i * range, (i + 1)
						* range - 1, 0, urlstr);
				infos.add(info);
			}
			DownloadInfo info = new DownloadInfo(threadcount - 1,
					(threadcount - 1) * range, fileSize - 1, 0, urlstr);
			infos.add(info);
			// 淇濆瓨infos涓殑鏁版嵁鍒版暟鎹簱
			dao.saveInfos(infos);
			totalsize = fileSize;
			downsize = 0;
//			return new LoadInfo(fileSize, 0, urlstr);
			//return loadInfo;
		} 
		if(!isfirst){

			infos = dao.getInfos(urlstr);
			Log.v("TAG", "not isFirst size=" + infos.size());
			
			for (DownloadInfo info : infos) {
				compeleteSize += info.getCompeleteSize();
				size += info.getEndPos() - info.getStartPos() + 1;
			}
			totalsize = size;
			downsize = compeleteSize;
//			return new LoadInfo(size, compeleteSize, urlstr);
		}
//		if (totalsize == 0) {
//			totalsize = fileSize;
//		}
		System.out.println("------------------>totalsize:"+fileSize);
		System.out.println("------------------>size:"+size);
		LoadInfo loadInfo = new LoadInfo(totalsize, downsize, urlstr);
		return loadInfo;
	}

	/**
      */
	private void init() {
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					URL url = new URL(urlstr);
					HttpURLConnection connection = (HttpURLConnection) url
							.openConnection();
					//connection.setConnectTimeout(5000);
					//connection.setRequestMethod("GET");
					if (connection.getResponseCode() != 200) {
						AppUtility.showToastMsg(context, "无效的下载地址！");
					}else{
						fileSize = connection.getContentLength();
						File file = new File(localfile);
						if (!file.exists()) {
							file.createNewFile();
						}
						// 鏈湴璁块棶鏂囦欢
//						RandomAccessFile accessFile = new RandomAccessFile(file, "rwd");
//						accessFile.setLength(fileSize);
//						accessFile.close();
						connection.disconnect();
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();
			
		
	}

	/**
	 * 鍒ゆ柇鏄惁鏄涓?娆? 涓嬭浇
	 */
	private boolean isFirst(String urlstr) {
		return dao.isHasInfors(urlstr);
	}

	/**
	 * 114 * 鍒╃敤绾跨▼寮?濮嬩笅杞芥暟鎹? 115
	 */
	public void download() {
		if (infos != null) {
			if (state == DOWNLOADING)
				return;
			state = DOWNLOADING;
			for (DownloadInfo info : infos) {
				new MyThread(info.getThreadId(), info.getStartPos(),
						info.getEndPos(), info.getCompeleteSize(),
						info.getUrl()).start();
			}
		}
	}

	public class MyThread extends Thread {
		private int threadId;
		private int startPos;
		private int endPos;
		private int compeleteSize;
		private String urlstr;

		public MyThread(int threadId, int startPos, int endPos,
				int compeleteSize, String urlstr) {
			this.threadId = threadId;
			this.startPos = startPos;
			this.endPos = endPos;
			this.compeleteSize = compeleteSize;
			this.urlstr = urlstr;
		}

		@SuppressWarnings({ "deprecation", "resource" })
		@Override
		public void run() {
			HttpURLConnection connection = null;
			RandomAccessFile randomAccessFile = null;
			InputStream is = null;
			try {
				URL url = new URL(urlstr);
				connection = (HttpURLConnection) url.openConnection();
				//connection.setConnectTimeout(5000);
				//connection.setRequestMethod("GET");
				// 璁剧疆鑼冨洿锛屾牸寮忎负Range锛歜ytes x-y;
				connection.setRequestProperty("Range", "bytes="
						+ (startPos + compeleteSize) + "-" + endPos);

				randomAccessFile = new RandomAccessFile(localfile, "rwd");
				randomAccessFile.seek(startPos + compeleteSize);
				// 灏嗚涓嬭浇鐨勬枃浠跺啓鍒颁繚瀛樺湪淇濆瓨璺緞涓嬬殑鏂囦欢涓?
				is = connection.getInputStream();
				byte[] buffer = new byte[4096];
				int length = -1;
				while ((length = is.read(buffer)) != -1) {
					if (isFirst(urlstr)) { //鍒ゆ柇鏈湴鏁版嵁搴撴槸鍚︽湁涓嬭浇娑堟伅锛屾棤涓嬭浇娑堟伅鍒欏仠姝㈢嚎绋嬶紝璺冲嚭寰幆
						this.stop();
						break;
					}
					randomAccessFile.write(buffer, 0, length);
					compeleteSize += length;
					// 鏇存柊鏁版嵁搴撲腑鐨勪笅杞戒俊鎭?
					dao.updataInfos(threadId, compeleteSize, urlstr);
					
//					int progress = (Double.valueOf((compeleteSize * 1.0 / fileSize * 100))).intValue();
//					System.out.println("---------------------------->progress:"+progress+">>>>>:"+compeleteSize+"============"+fileSize);
					// 鐢ㄦ秷鎭皢涓嬭浇淇℃伅浼犵粰杩涘害鏉★紝瀵硅繘搴︽潯杩涜鏇存柊
					Bundle bundle = new Bundle();
					bundle.putString("urlstr", urlstr);
					bundle.putInt("compeleteSize", compeleteSize);
					bundle.putString("localFile", localfile);
					Message message = Message.obtain();
					message.what = 1;
					message.obj = bundle;
					mHandler.sendMessage(message);
					if (state == PAUSE) {
						return;
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					is.close();
					randomAccessFile.close();
					connection.disconnect();
//					dao.closeDb();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		}
	}

	// 鍒犻櫎鏁版嵁搴撲腑urlstr瀵瑰簲鐨勪笅杞藉櫒淇℃伅
	public void delete(String urlstr) {
		dao.delete(urlstr);
	}

	// 璁剧疆鏆傚仠
	public void pause() {
		state = PAUSE;
	}

	// 閲嶇疆涓嬭浇鐘舵??
	public void reset() {
		state = INIT;
	}
}

