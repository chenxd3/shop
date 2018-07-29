package com.shop.mapper;

import com.shop.pojo.ShopItemDesc;
import com.shop.pojo.ShopItemDescExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShopItemDescMapper {
    int countByExample(ShopItemDescExample example);

    int deleteByExample(ShopItemDescExample example);

    int deleteByPrimaryKey(Long itemId);

    int insert(ShopItemDesc record);

    int insertSelective(ShopItemDesc record);

    List<ShopItemDesc> selectByExampleWithBLOBs(ShopItemDescExample example);

    List<ShopItemDesc> selectByExample(ShopItemDescExample example);

    ShopItemDesc selectByPrimaryKey(Long itemId);

    int updateByExampleSelective(@Param("record") ShopItemDesc record, @Param("example") ShopItemDescExample example);

    int updateByExampleWithBLOBs(@Param("record") ShopItemDesc record, @Param("example") ShopItemDescExample example);

    int updateByExample(@Param("record") ShopItemDesc record, @Param("example") ShopItemDescExample example);

    int updateByPrimaryKeySelective(ShopItemDesc record);

    int updateByPrimaryKeyWithBLOBs(ShopItemDesc record);

    int updateByPrimaryKey(ShopItemDesc record);
}