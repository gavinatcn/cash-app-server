package com.yumi.cash.app.server.exception;

/**
 * Created by gavin on 2016/12/26.
 */


public class NotifyException extends RuntimeException {

    String errorCode;
    String errorMsg;

    public NotifyException(String errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
