package com.yumi.cash.app.server.dal;

import com.yumi.cash.app.server.dao.ProductBasicInfo;
import com.yumi.cash.app.server.dao.ProductBasicInfoExample;
import com.yumi.cash.app.server.dao.ProductBasicInfoWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductBasicInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PRODUCT_BASIC_INFO
     *
     * @mbggenerated
     */
    int countByExample(ProductBasicInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PRODUCT_BASIC_INFO
     *
     * @mbggenerated
     */
    int deleteByExample(ProductBasicInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PRODUCT_BASIC_INFO
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String productId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PRODUCT_BASIC_INFO
     *
     * @mbggenerated
     */
    int insert(ProductBasicInfoWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PRODUCT_BASIC_INFO
     *
     * @mbggenerated
     */
    int insertSelective(ProductBasicInfoWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PRODUCT_BASIC_INFO
     *
     * @mbggenerated
     */
    List<ProductBasicInfoWithBLOBs> selectByExampleWithBLOBs(ProductBasicInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PRODUCT_BASIC_INFO
     *
     * @mbggenerated
     */
    List<ProductBasicInfo> selectByExample(ProductBasicInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PRODUCT_BASIC_INFO
     *
     * @mbggenerated
     */
    ProductBasicInfoWithBLOBs selectByPrimaryKey(String productId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PRODUCT_BASIC_INFO
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") ProductBasicInfoWithBLOBs record, @Param("example") ProductBasicInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PRODUCT_BASIC_INFO
     *
     * @mbggenerated
     */
    int updateByExampleWithBLOBs(@Param("record") ProductBasicInfoWithBLOBs record, @Param("example") ProductBasicInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PRODUCT_BASIC_INFO
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") ProductBasicInfo record, @Param("example") ProductBasicInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PRODUCT_BASIC_INFO
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(ProductBasicInfoWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PRODUCT_BASIC_INFO
     *
     * @mbggenerated
     */
    int updateByPrimaryKeyWithBLOBs(ProductBasicInfoWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PRODUCT_BASIC_INFO
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(ProductBasicInfo record);
}