package com.yumi.cash.app.server.web.controller;

import com.yumi.cash.app.server.config.enums.ResultStatusEnum;
import com.yumi.cash.app.server.dto.BaseDTO;
import com.yumi.cash.app.server.dto.ProductListDTO;
import com.yumi.cash.app.server.dto.ProductListParam;
import com.yumi.cash.app.server.exception.NotifyException;
import com.yumi.cash.app.server.service.ProductManageService;
import com.yumi.cash.app.server.util.Md5Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class ProductListController  extends BaseController{

    private static final Logger logger = LoggerFactory.getLogger(ProductListController.class);

    @Autowired
    private ProductManageService productManageService;

    @RequestMapping(path = "/prodlist",method = RequestMethod.POST)
    public ResponseEntity<BaseDTO> prodQueryList(@RequestHeader(value = "sign")String sign,
                                                   @RequestBody @Validated ProductListParam productListParam,
                                                   BindingResult result){
        ResponseEntity<BaseDTO> responseEntity = null;

        try{
            if(result.hasErrors()){
                throw new NotifyException(ResultStatusEnum.PARAM_ERROR.getCode(),ResultStatusEnum.PARAM_ERROR.getMessage()+"|"+result.getAllErrors().get(0).getDefaultMessage());
            }

            doSignCheck(sign, productListParam);
            responseEntity = doBusiness(productListParam);

        }catch (Exception ex){
            if(ex instanceof NotifyException){
                responseEntity = this.buildErrorResp((NotifyException) ex);

                logger.error(((NotifyException) ex).getErrorMsg());

            }else {
                responseEntity = this.buildErrorResp(new NotifyException(ResultStatusEnum.SYSTEM_ERROR.getCode(), ResultStatusEnum.SYSTEM_ERROR.getMessage()));
            }

            logger.error(ex.getMessage(), ex);

        }

        return responseEntity;

    }

    @Override
    protected ResponseEntity<BaseDTO> doBusiness(Object object) {
        ProductListParam productListParam = (ProductListParam) object;
        ProductListDTO productListDTO = this.productManageService.getProductAbstractInfoList(productListParam);

        String sign = Md5Util.sign(generateSignContent(productListDTO),"key","UTF-8");
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("sign",sign);
        return buildSuccessResp(responseHeaders,productListDTO);
    }


}
