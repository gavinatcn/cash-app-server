package com.yumi.cash.app.server.dto;

import java.util.List;

/**
 * Created by gavin on 2016/12/28.
 */
public class ProductListDTO {

    private List<ProductAbstractInfoDTO> productList;

    public List<ProductAbstractInfoDTO> getProductList() {
        return productList;
    }

    public void setProductList(List<ProductAbstractInfoDTO> productList) {
        this.productList = productList;
    }
}
