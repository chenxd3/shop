package com.shop.mapper;

import com.shop.pojo.ShopItemParamItem;
import com.shop.pojo.ShopItemParamItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShopItemParamItemMapper {
    int countByExample(ShopItemParamItemExample example);

    int deleteByExample(ShopItemParamItemExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShopItemParamItem record);

    int insertSelective(ShopItemParamItem record);

    List<ShopItemParamItem> selectByExampleWithBLOBs(ShopItemParamItemExample example);

    List<ShopItemParamItem> selectByExample(ShopItemParamItemExample example);

    ShopItemParamItem selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShopItemParamItem record, @Param("example") ShopItemParamItemExample example);

    int updateByExampleWithBLOBs(@Param("record") ShopItemParamItem record, @Param("example") ShopItemParamItemExample example);

    int updateByExample(@Param("record") ShopItemParamItem record, @Param("example") ShopItemParamItemExample example);

    int updateByPrimaryKeySelective(ShopItemParamItem record);

    int updateByPrimaryKeyWithBLOBs(ShopItemParamItem record);

    int updateByPrimaryKey(ShopItemParamItem record);
}