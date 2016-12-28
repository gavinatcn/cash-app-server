package com.yumi.cash.app.server.web.controller;

import com.yumi.cash.app.server.config.enums.ResultStatusEnum;
import com.yumi.cash.app.server.dto.ApplicationInitDTO;
import com.yumi.cash.app.server.dto.ApplicationInitParam;
import com.yumi.cash.app.server.dto.BaseDTO;
import com.yumi.cash.app.server.exception.NotifyException;
import com.yumi.cash.app.server.service.ApplicationInitService;
import com.yumi.cash.app.server.util.Md5Util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class ApplicationInitController extends BaseController{

	@Autowired
	private ApplicationInitService applicationInitService;

	@RequestMapping(path = "/initapp",method = RequestMethod.POST)
	public ResponseEntity<BaseDTO> applicationInit(@RequestHeader(value = "sign")String sign,
												   @RequestBody @Validated ApplicationInitParam applicationInitParam,
												   BindingResult result){

		ResponseEntity<BaseDTO> responseEntity = null;

		try{
			if(result.hasErrors()){
				throw new NotifyException(ResultStatusEnum.PARAM_ERROR.getCode(),ResultStatusEnum.PARAM_ERROR.getMessage()+"|"+result.getAllErrors().get(0).getDefaultMessage());
			}

			doSignCheck(sign, applicationInitParam);
			responseEntity = doBusiness(applicationInitParam);
		}catch (Exception ex){
			if(ex instanceof NotifyException){
				responseEntity = this.buildErrorResp((NotifyException) ex);
				//TODO:output normally
				ex.printStackTrace();
			}else {
				responseEntity = this.buildErrorResp(new NotifyException(ResultStatusEnum.SYSTEM_ERROR.getCode(), ResultStatusEnum.SYSTEM_ERROR.getMessage()));
				//TODO:output normally
				ex.printStackTrace();
			}
		}

		return responseEntity;

	}

	@Override
	protected ResponseEntity<BaseDTO> doBusiness(Object object) {
		ApplicationInitParam applicationInitParam = (ApplicationInitParam) object;
		ApplicationInitDTO applicationInitDTO = this.applicationInitService.selectApplicationInit(applicationInitParam);

		String sign = Md5Util.sign(generateSignContent(applicationInitDTO),"key","UTF-8");
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("sign",sign);
		return buildSuccessResp(responseHeaders,applicationInitDTO);
	}
}
