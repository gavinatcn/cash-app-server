package com.yumi.cash.app.server.dto;


public class AppVersionDTO {

	private String appChannel; //渠道号

	private String appName; //应用名称

	private String currentVersion; //当前版本

	private String forceUpdate; //是否强制更新

	private String detectionUpdate; //是否检测更新

	private String downloadURl; //下载URL

	public String getAppChannel() {
		return appChannel;
	}

	public void setAppChannel(String appChannel) {
		this.appChannel = appChannel;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getCurrentVersion() {
		return currentVersion;
	}

	public void setCurrentVersion(String currentVersion) {
		this.currentVersion = currentVersion;
	}

	public String getForceUpdate() {
		return forceUpdate;
	}

	public void setForceUpdate(String forceUpdate) {
		this.forceUpdate = forceUpdate;
	}

	public String getDetectionUpdate() {
		return detectionUpdate;
	}

	public void setDetectionUpdate(String detectionUpdate) {
		this.detectionUpdate = detectionUpdate;
	}

	public String getDownloadURl() {
		return downloadURl;
	}

	public void setDownloadURl(String downloadURl) {
		this.downloadURl = downloadURl;
	}
}
