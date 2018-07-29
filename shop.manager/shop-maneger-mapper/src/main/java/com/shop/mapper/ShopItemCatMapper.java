package com.shop.mapper;

import com.shop.pojo.ShopItemCat;
import com.shop.pojo.ShopItemCatExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShopItemCatMapper {
    int countByExample(ShopItemCatExample example);

    int deleteByExample(ShopItemCatExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShopItemCat record);

    int insertSelective(ShopItemCat record);

    List<ShopItemCat> selectByExample(ShopItemCatExample example);

    ShopItemCat selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShopItemCat record, @Param("example") ShopItemCatExample example);

    int updateByExample(@Param("record") ShopItemCat record, @Param("example") ShopItemCatExample example);

    int updateByPrimaryKeySelective(ShopItemCat record);

    int updateByPrimaryKey(ShopItemCat record);
}