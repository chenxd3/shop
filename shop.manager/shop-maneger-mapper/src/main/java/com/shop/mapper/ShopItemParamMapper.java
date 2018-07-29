package com.shop.mapper;

import com.shop.pojo.ShopItemParam;
import com.shop.pojo.ShopItemParamExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShopItemParamMapper {
    int countByExample(ShopItemParamExample example);

    int deleteByExample(ShopItemParamExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShopItemParam record);

    int insertSelective(ShopItemParam record);

    List<ShopItemParam> selectByExampleWithBLOBs(ShopItemParamExample example);

    List<ShopItemParam> selectByExample(ShopItemParamExample example);

    ShopItemParam selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShopItemParam record, @Param("example") ShopItemParamExample example);

    int updateByExampleWithBLOBs(@Param("record") ShopItemParam record, @Param("example") ShopItemParamExample example);

    int updateByExample(@Param("record") ShopItemParam record, @Param("example") ShopItemParamExample example);

    int updateByPrimaryKeySelective(ShopItemParam record);

    int updateByPrimaryKeyWithBLOBs(ShopItemParam record);

    int updateByPrimaryKey(ShopItemParam record);
}