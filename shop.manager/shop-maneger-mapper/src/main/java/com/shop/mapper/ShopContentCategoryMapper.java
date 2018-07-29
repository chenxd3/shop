package com.shop.mapper;

import com.shop.pojo.ShopContentCategory;
import com.shop.pojo.ShopContentCategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShopContentCategoryMapper {
    int countByExample(ShopContentCategoryExample example);

    int deleteByExample(ShopContentCategoryExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShopContentCategory record);

    int insertSelective(ShopContentCategory record);

    List<ShopContentCategory> selectByExample(ShopContentCategoryExample example);

    ShopContentCategory selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShopContentCategory record, @Param("example") ShopContentCategoryExample example);

    int updateByExample(@Param("record") ShopContentCategory record, @Param("example") ShopContentCategoryExample example);

    int updateByPrimaryKeySelective(ShopContentCategory record);

    int updateByPrimaryKey(ShopContentCategory record);
}