package com.yumi.cash.app.server.service;

import com.yumi.cash.app.server.dal.ProductBasicInfoMapper;
import com.yumi.cash.app.server.dao.ProductBasicInfo;
import com.yumi.cash.app.server.dao.ProductBasicInfoExample;
import com.yumi.cash.app.server.dto.ProductAbstractInfoDTO;
import com.yumi.cash.app.server.dto.ProductListDTO;
import com.yumi.cash.app.server.dto.ProductListParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductManageService {

    @Autowired
    private ProductBasicInfoMapper productBasicInfoMapper;

    public ProductListDTO getProductAbstractInfoList(ProductListParam productListParam) {

        ProductListDTO productListDTO = new ProductListDTO();

        //查询产品列表
        ProductBasicInfoExample productExample = new ProductBasicInfoExample();
        productExample.createCriteria().andProdCatgEqualTo(productListParam.getProdCatlog());

        List<ProductBasicInfo> productBasicInfoList = this.productBasicInfoMapper.selectByExample(productExample);

        //遍历查询结果，并转化为摘要信息列表
        List<ProductAbstractInfoDTO> productList = new ArrayList<>();
        for(ProductBasicInfo prod:productBasicInfoList) {

            ProductAbstractInfoDTO productAbstractInfoDTO = new ProductAbstractInfoDTO();

            productAbstractInfoDTO.setProductId(prod.getProductId());
            productAbstractInfoDTO.setProductName(prod.getProdName());
            productAbstractInfoDTO.setLogonUrl(prod.getLogoUrl());
            productAbstractInfoDTO.setDayRate(prod.getDayRate().toString());
            productAbstractInfoDTO.setMaxLoanLimit(prod.getMaxLoanLimit().toString());
            productAbstractInfoDTO.setMinLoanLimit(prod.getMinLoanLimit().toString());

            productList.add(productAbstractInfoDTO);

        }

        productListDTO.setProductList(productList);

        return productListDTO;

    }

}
