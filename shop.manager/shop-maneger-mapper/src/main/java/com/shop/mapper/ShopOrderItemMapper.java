package com.shop.mapper;

import com.shop.pojo.ShopOrderItem;
import com.shop.pojo.ShopOrderItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShopOrderItemMapper {
    int countByExample(ShopOrderItemExample example);

    int deleteByExample(ShopOrderItemExample example);

    int deleteByPrimaryKey(String id);

    int insert(ShopOrderItem record);

    int insertSelective(ShopOrderItem record);

    List<ShopOrderItem> selectByExample(ShopOrderItemExample example);

    ShopOrderItem selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ShopOrderItem record, @Param("example") ShopOrderItemExample example);

    int updateByExample(@Param("record") ShopOrderItem record, @Param("example") ShopOrderItemExample example);

    int updateByPrimaryKeySelective(ShopOrderItem record);

    int updateByPrimaryKey(ShopOrderItem record);
}