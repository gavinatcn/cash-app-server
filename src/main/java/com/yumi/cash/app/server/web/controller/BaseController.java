package com.yumi.cash.app.server.web.controller;

import com.yumi.cash.app.server.config.enums.ResultStatusEnum;
import com.yumi.cash.app.server.dto.BaseDTO;
import com.yumi.cash.app.server.exception.NotifyException;
import com.yumi.cash.app.server.util.Md5Util;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.lang.reflect.Field;
import java.util.*;


public abstract class BaseController {

    public static ResponseEntity<BaseDTO> buildErrorResp(NotifyException notifyException) {
        BaseDTO baseDTO = new BaseDTO();
        baseDTO.setRespCode(notifyException.getErrorCode());
        baseDTO.setRespMsg(notifyException.getErrorMsg());
        ResponseEntity<BaseDTO> responseEntity = new ResponseEntity<BaseDTO>(baseDTO, HttpStatus.OK);
        return responseEntity;
    }

    public static ResponseEntity<BaseDTO> buildSuccessResp(HttpHeaders httpHeaders, Object object) {
        BaseDTO baseDTO = new BaseDTO();
        baseDTO.setRespCode(ResultStatusEnum.SUCCESS.getCode());
        baseDTO.setRespMsg(ResultStatusEnum.SUCCESS.getMessage());
        baseDTO.setResult(object);
        ResponseEntity<BaseDTO> responseEntity = new ResponseEntity<BaseDTO>(baseDTO, httpHeaders,HttpStatus.OK);
        return responseEntity;
    }

    public static void doSignCheck(String sign,Object object) {
        String genSignContent = generateSignContent(object);
        if(!Md5Util.verify(genSignContent,sign,"key","UTF-8")) {
            throw new NotifyException(ResultStatusEnum.CHECK_SIGN_ERROR.getCode(), ResultStatusEnum.CHECK_SIGN_ERROR.getMessage());
        }
    }

    public static String generateSignContent(Object object) {
        StringBuffer signContent = new StringBuffer();
        HashMap<String, String> map = new HashMap<String, String>();
        try {
            Field[] fs = object.getClass().getDeclaredFields();
            for (Field f : fs) {
                if (f.getName().equals("serialVersionUID")) {
                    continue;
                }
                f.setAccessible(true);
                String value = (String) f.get(object);
                if (value == null) {
                    continue;
                }
                String name = f.getName();
                map.put(name, value);
            }
            map.remove("sign");
            List<Map.Entry<String, String>> mappingList = new ArrayList<Map.Entry<String, String>>(map.entrySet());
            Collections.sort(mappingList, new Comparator<Map.Entry<String, String>>() {
                public int compare(Map.Entry<String, String> mapping1, Map.Entry<String, String> mapping2) {
                    return mapping1.getKey().compareTo(mapping2.getKey());
                }
            });
            Map.Entry<String, String> mapping = (Map.Entry<String, String>) mappingList.get(0);
            signContent.append(mapping.getKey().toLowerCase() + "=" + mapping.getValue());
            for (int i = 1; i < mappingList.size(); i++) {
                Map.Entry<String, String> maps = (Map.Entry<String, String>) mappingList.get(i);
                signContent.append("&" + maps.getKey().toLowerCase() + "=" + maps.getValue());
            }
        } catch (Exception e) {
            throw new NotifyException(ResultStatusEnum.SIGN_ERROR.getCode(), ResultStatusEnum.SIGN_ERROR.getCode());
        } finally {
            return signContent.toString();
        }
    }

    protected abstract ResponseEntity<BaseDTO> doBusiness(Object object);


}
