package com.yumi.cash.app.server.config.enums;

public enum ResultStatusEnum {
    SUCCESS("000", "成功"),
    PARAM_ERROR("001","参数错误"),
    SYSTEM_ERROR("002","系统错误"),
    SIGN_ERROR("003","签名异常"),
    CHECK_SIGN_ERROR("004","验签失败");


    /**
     * 返回码
     */
    private String code;

    /**
     * 返回结果描述
     */
    private String message;

    ResultStatusEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
