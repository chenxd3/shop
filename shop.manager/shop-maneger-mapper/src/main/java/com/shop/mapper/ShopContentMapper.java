package com.shop.mapper;

import com.shop.pojo.ShopContent;
import com.shop.pojo.ShopContentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShopContentMapper {
    int countByExample(ShopContentExample example);

    int deleteByExample(ShopContentExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShopContent record);

    int insertSelective(ShopContent record);

    List<ShopContent> selectByExampleWithBLOBs(ShopContentExample example);

    List<ShopContent> selectByExample(ShopContentExample example);

    ShopContent selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShopContent record, @Param("example") ShopContentExample example);

    int updateByExampleWithBLOBs(@Param("record") ShopContent record, @Param("example") ShopContentExample example);

    int updateByExample(@Param("record") ShopContent record, @Param("example") ShopContentExample example);

    int updateByPrimaryKeySelective(ShopContent record);

    int updateByPrimaryKeyWithBLOBs(ShopContent record);

    int updateByPrimaryKey(ShopContent record);
}