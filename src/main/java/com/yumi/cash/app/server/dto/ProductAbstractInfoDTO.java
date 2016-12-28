package com.yumi.cash.app.server.dto;

/**
 * Created by gavin on 2016/12/28.
 */
public class ProductAbstractInfoDTO {

    private String productId;
    private String productName;
    private String logonUrl;
    private String dayRate;
    private String maxLoanLimit;
    private String minLoanLimit;


    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getLogonUrl() {
        return logonUrl;
    }

    public void setLogonUrl(String logonUrl) {
        this.logonUrl = logonUrl;
    }

    public String getDayRate() {
        return dayRate;
    }

    public void setDayRate(String dayRate) {
        this.dayRate = dayRate;
    }

    public String getMaxLoanLimit() {
        return maxLoanLimit;
    }

    public void setMaxLoanLimit(String maxLoanLimit) {
        this.maxLoanLimit = maxLoanLimit;
    }

    public String getMinLoanLimit() {
        return minLoanLimit;
    }

    public void setMinLoanLimit(String minLoanLimit) {
        this.minLoanLimit = minLoanLimit;
    }
}
