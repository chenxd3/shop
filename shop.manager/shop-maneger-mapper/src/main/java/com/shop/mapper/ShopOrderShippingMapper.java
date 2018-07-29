package com.shop.mapper;

import com.shop.pojo.ShopOrderShipping;
import com.shop.pojo.ShopOrderShippingExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShopOrderShippingMapper {
    int countByExample(ShopOrderShippingExample example);

    int deleteByExample(ShopOrderShippingExample example);

    int deleteByPrimaryKey(String orderId);

    int insert(ShopOrderShipping record);

    int insertSelective(ShopOrderShipping record);

    List<ShopOrderShipping> selectByExample(ShopOrderShippingExample example);

    ShopOrderShipping selectByPrimaryKey(String orderId);

    int updateByExampleSelective(@Param("record") ShopOrderShipping record, @Param("example") ShopOrderShippingExample example);

    int updateByExample(@Param("record") ShopOrderShipping record, @Param("example") ShopOrderShippingExample example);

    int updateByPrimaryKeySelective(ShopOrderShipping record);

    int updateByPrimaryKey(ShopOrderShipping record);
}