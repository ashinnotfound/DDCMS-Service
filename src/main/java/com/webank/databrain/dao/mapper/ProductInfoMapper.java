package com.webank.databrain.dao.mapper;

import com.webank.databrain.bo.HotProductBO;
import com.webank.databrain.dao.entity.ProductInfoEntity;
import com.webank.databrain.bo.ProductInfoBO;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProductInfoMapper {

    @Select("SELECT a.pk_id as productId,a.product_gid, a.product_name,a.product_desc,a.status,a.review_time,a.create_time,b.did,c.company_name" +
            " FROM t_product_info a JOIN t_account_info b ON a.provider_id = b.pk_id" +
            " JOIN t_company_info c ON a.provider_id = c.account_id" +
            " ORDER BY a.create_time DESC LIMIT #{start}, #{pageSize}")
    @ResultType(ProductInfoBO.class)
    List<ProductInfoBO> pageQueryProduct(@Param("start") long start, @Param("pageSize")int pageSize);

    @Select("SELECT a.product_gid as productGid, c.company_name as productName, a.pk_id as productId FROM t_product_info a " +
            "JOIN t_account_info b ON a.provider_id = b.pk_id " +
            "JOIN t_company_info c ON a.provider_id = c.account_id " +
            "ORDER BY a.create_time DESC LIMIT 1, #{topN}")
    @ResultType(HotProductBO.class)
    List<HotProductBO> getHotProduct(@Param("topN") int topN);

    @Select("SELECT a.pk_id as productId, a.product_gid, a.product_name,a.product_desc,a.status,a.review_time,a.create_time,b.did,c.company_name" +
            " FROM t_product_info a" +
            " left JOIN t_account_info b ON a.provider_id = b.pk_id" +
            " left JOIN t_company_info c ON a.provider_id = c.account_id" +
            " where a.product_gid = #{productId}")
    @ResultType(ProductInfoBO.class)
    ProductInfoBO getProductByGId(@Param("productId") String productId);


    @Select("SELECT * FROM t_product_info where pk_id IN (#{ids})")
    List<ProductInfoEntity> getProductNameByIds(@Param("ids") List<Long> ids);


    @Insert("INSERT INTO t_product_info(" +
            "product_gid," +
            "product_name," +
            "provider_id, " +
            "product_desc," +
            "status," +
            "review_time," +
            "create_time" +
            ") " +
            "VALUES(" +
            "#{productGid}, " +
            "#{productName}, " +
            "#{providerId}," +
            "#{productDesc}," +
            "#{status}," +
            "#{reviewTime}," +
            "#{createTime}" +
            ")")
    @Options(useGeneratedKeys = true, keyProperty = "pkId", keyColumn = "pk_id")
    void insertProductInfo(ProductInfoEntity productInfoEntity);


    @Update("UPDATE t_product_info SET " +
            "product_name=#{productName}, " +
            "review_time=#{reviewTime}, " +
            "status=#{status}, " +
            "update_time=#{updateTime} " +
            "WHERE pk_id=#{pkId}")
    void updateProductInfo(ProductInfoEntity productInfoEntity);

    @Update("UPDATE t_product_info SET " +
            "review_time=#{reviewTime}, " +
            "status=#{status}, " +
            "update_time=#{updateTime} " +
            "WHERE pk_id=#{pkId} or product_gid = #{productGid}")
    void updateProductInfoState(ProductInfoEntity productInfoEntity);

    @Select("SELECT COUNT(*) FROM t_product_info")
    int count();

}
