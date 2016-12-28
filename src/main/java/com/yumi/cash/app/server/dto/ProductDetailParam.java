package com.yumi.cash.app.server.dto;

import org.hibernate.validator.constraints.NotEmpty;

public class ProductDetailParam {

    @NotEmpty(message = "产品号不能为空")
    private String productId;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }
}
