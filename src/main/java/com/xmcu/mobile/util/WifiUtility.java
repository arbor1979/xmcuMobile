package com.xmcu.mobile.util;

import java.util.List;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.net.wifi.WifiManager.WifiLock;

/**
 * Java utils Wifi宸ュ叿
 * 
 * @author once
 */
public class WifiUtility {

	// 瀹氫箟WifiManager瀵硅薄
	private WifiManager mWifiManager;
	// 瀹氫箟WifiInfo瀵硅薄
	private WifiInfo mWifiInfo;
	// 鎵弿鍑虹殑缃戠粶杩炴帴鍒楄〃
	private List<ScanResult> mWifiList;
	// 缃戠粶杩炴帴鍒楄〃
	private List<WifiConfiguration> mWifiConfiguration;
	// 瀹氫箟涓?涓猈ifiLock
	WifiLock mWifiLock;

	// 鏋勯?犲櫒
	public WifiUtility(Context context) {
		// 鍙栧緱WifiManager瀵硅薄
		mWifiManager = (WifiManager) context
				.getSystemService(Context.WIFI_SERVICE);
		// 鍙栧緱WifiInfo瀵硅薄
		mWifiInfo = mWifiManager.getConnectionInfo();
	}

	// 鎵撳紑WIFI
	public void openWifi() {
		if (!mWifiManager.isWifiEnabled()) {
			mWifiManager.setWifiEnabled(true);
		}
	}

	// 鍏抽棴WIFI
	public void closeWifi() {
		if (mWifiManager.isWifiEnabled()) {
			mWifiManager.setWifiEnabled(false);
		}
	}

	// 妫?鏌ュ綋鍓峎IFI鐘舵??
	public int checkState() {
		return mWifiManager.getWifiState();
	}

	// 閿佸畾WifiLock
	public void acquireWifiLock() {
		mWifiLock.acquire();
	}

	// 瑙ｉ攣WifiLock
	public void releaseWifiLock() {
		// 鍒ゆ柇鏃跺?欓攣瀹?
		if (mWifiLock.isHeld()) {
			mWifiLock.acquire();
		}
	}

	// 鍒涘缓涓?涓猈ifiLock
	public void creatWifiLock() {
		mWifiLock = mWifiManager.createWifiLock("Test");
	}

	// 寰楀埌閰嶇疆濂界殑缃戠粶
	public List<WifiConfiguration> getConfiguration() {
		return mWifiConfiguration;
	}

	// 鎸囧畾閰嶇疆濂界殑缃戠粶杩涜杩炴帴
	public void connectConfiguration(int index) {
		// 绱㈠紩澶т簬閰嶇疆濂界殑缃戠粶绱㈠紩杩斿洖
		if (index > mWifiConfiguration.size()) {
			return;
		}
		// 杩炴帴閰嶇疆濂界殑鎸囧畾ID鐨勭綉缁?
		mWifiManager.enableNetwork(mWifiConfiguration.get(index).networkId,
				true);
	}

	public void startScan() {
		mWifiManager.startScan();
		// 寰楀埌鎵弿缁撴灉
		mWifiList = mWifiManager.getScanResults();
		// 寰楀埌閰嶇疆濂界殑缃戠粶杩炴帴
		mWifiConfiguration = mWifiManager.getConfiguredNetworks();
	}

	// 寰楀埌缃戠粶鍒楄〃
	public List<ScanResult> getWifiList() {
		return mWifiList;
	}

	// 鏌ョ湅鎵弿缁撴灉
	public StringBuilder lookUpScan() {
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < mWifiList.size(); i++) {
			stringBuilder
					.append("Index_" + new Integer(i + 1).toString() + ":");
			// 灏哠canResult淇℃伅杞崲鎴愪竴涓瓧绗︿覆鍖?
			// 鍏朵腑鎶婂寘鎷細BSSID銆丼SID銆乧apabilities銆乫requency銆乴evel
			stringBuilder.append((mWifiList.get(i)).toString());
			stringBuilder.append("/n");
		}
		return stringBuilder;
	}

	// 寰楀埌MAC鍦板潃
	public String getMacAddress() {
		return (mWifiInfo == null) ? "NULL" : mWifiInfo.getMacAddress();
	}

	// 寰楀埌鎺ュ叆鐐圭殑BSSID
	public String getBSSID() {
		return (mWifiInfo == null) ? "NULL" : mWifiInfo.getBSSID();
	}

	// 寰楀埌IP鍦板潃
	public int getIPAddress() {
		return (mWifiInfo == null) ? 0 : mWifiInfo.getIpAddress();
	}

	// 寰楀埌杩炴帴鐨処D
	public int getNetworkId() {
		return (mWifiInfo == null) ? 0 : mWifiInfo.getNetworkId();
	}

	// 寰楀埌WifiInfo鐨勬墍鏈変俊鎭寘
	public String getWifiInfo() {
		return (mWifiInfo == null) ? "NULL" : mWifiInfo.toString();
	}

	// 娣诲姞涓?涓綉缁滃苟杩炴帴
	public void addNetwork(WifiConfiguration wcg) {
		int wcgID = mWifiManager.addNetwork(wcg);
		boolean b = mWifiManager.enableNetwork(wcgID, true);
		System.out.println("a--" + wcgID);
		System.out.println("b--" + b);
	}

	// 鏂紑鎸囧畾ID鐨勭綉缁?
	public void disconnectWifi(int netId) {
		mWifiManager.disableNetwork(netId);
		mWifiManager.disconnect();
	}
}