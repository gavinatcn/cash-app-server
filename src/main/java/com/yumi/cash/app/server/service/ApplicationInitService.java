package com.yumi.cash.app.server.service;

import com.yumi.cash.app.server.dto.AppVersionDTO;
import com.yumi.cash.app.server.dto.ApplicationInitDTO;
import com.yumi.cash.app.server.dto.ApplicationInitParam;
import org.springframework.stereotype.Service;

@Service
public class ApplicationInitService {

	//查询应用初始化需要返回的数据
	public ApplicationInitDTO selectApplicationInit(ApplicationInitParam applicationInitParam){


		ApplicationInitDTO applicationInitDTO = new ApplicationInitDTO();

		//设置版本信息
		AppVersionDTO appVersionDTO = new AppVersionDTO();
        appVersionDTO.setAppChannel(applicationInitParam.getAppChannel());
        appVersionDTO.setAppName(applicationInitParam.getAppName());
        appVersionDTO.setCurrentVersion("V1.0.0");
        appVersionDTO.setForceUpdate("1");
		appVersionDTO.setDetectionUpdate("1");
		appVersionDTO.setDownloadURl("http://localhost/download/cash-app");

		applicationInitDTO.setAppVersionDTO(appVersionDTO);

		return applicationInitDTO;
	}
}

