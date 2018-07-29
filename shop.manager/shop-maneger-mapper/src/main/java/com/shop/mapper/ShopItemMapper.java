package com.shop.mapper;

import com.shop.pojo.ShopItem;
import com.shop.pojo.ShopItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShopItemMapper {
    int countByExample(ShopItemExample example);

    int deleteByExample(ShopItemExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShopItem record);

    int insertSelective(ShopItem record);

    List<ShopItem> selectByExample(ShopItemExample example);

    ShopItem selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShopItem record, @Param("example") ShopItemExample example);

    int updateByExample(@Param("record") ShopItem record, @Param("example") ShopItemExample example);

    int updateByPrimaryKeySelective(ShopItem record);

    int updateByPrimaryKey(ShopItem record);
}