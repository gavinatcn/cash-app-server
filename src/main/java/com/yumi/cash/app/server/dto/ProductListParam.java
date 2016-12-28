package com.yumi.cash.app.server.dto;


import org.hibernate.validator.constraints.NotEmpty;

public class ProductListParam {

    @NotEmpty(message = "产品类型不能为空")
    private String prodCatlog;


    public String getProdCatlog() {
        return prodCatlog;
    }

    public void setProdCatlog(String prodCatlog) {
        this.prodCatlog = prodCatlog;
    }

}
