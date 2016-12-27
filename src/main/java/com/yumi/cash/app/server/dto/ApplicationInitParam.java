package com.yumi.cash.app.server.dto;


import org.hibernate.validator.constraints.NotEmpty;

/**
 * 应用初始化接口参数
 */
public class ApplicationInitParam {

	@NotEmpty(message = "平台类型不能为空")
	private String appPlatForm; //平台类型

	@NotEmpty(message = "渠道号不能为空")
	private String appChannel; //渠道号

	@NotEmpty(message = "应用名称不能为空")
	private String appName; //应用名称

	public String getAppPlatForm() {
		return appPlatForm;
	}

	public void setAppPlatForm(String appPlatForm) {
		this.appPlatForm = appPlatForm;
	}

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

}
