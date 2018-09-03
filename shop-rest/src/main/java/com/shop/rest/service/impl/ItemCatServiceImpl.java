package com.shop.rest.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.mapper.ShopItemCatMapper;
import com.shop.pojo.ShopItemCat;
import com.shop.pojo.ShopItemCatExample;
import com.shop.pojo.ShopItemCatExample.Criteria;
import com.shop.rest.pojo.CatNode;
import com.shop.rest.pojo.CatResult;
import com.shop.rest.service.ItemCatService;

@Service
public class ItemCatServiceImpl implements ItemCatService{
	
	@Autowired
	private ShopItemCatMapper itemCatMapper;

	@Override
	public CatResult getItemCatList() {
		
		CatResult catResult = new CatResult();
		//查询分类列表
		catResult.setData(getCatList(0));
		return catResult;
	}
	
	private List<?> getCatList(long parentId){
		ShopItemCatExample example = new ShopItemCatExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		List<ShopItemCat> list = itemCatMapper.selectByExample(example);
		List resultList = new ArrayList<>();
		int count = 0;
		for(ShopItemCat itemCat: list){
			//判断是否为父节点
			if (itemCat.getIsParent()) {
				CatNode catNode = new CatNode();
				if (parentId == 0) {
					catNode.setName("<a href='/products/"+itemCat.getId()+".html'>"+itemCat.getName()+"</a>");
				} else {
					catNode.setName(itemCat.getName());
				}
				catNode.setUrl("/products/"+itemCat.getId()+".html");
				catNode.setItem(getCatList(itemCat.getId()));
				
				resultList.add(catNode);
				//第一层只取14条记录
				if (parentId == 0 && count >= 13) {
					break;
				}
			//如果是叶子节点
			} else {
				resultList.add("/products/"+itemCat.getId()+".html|" + itemCat.getName());
			}
		}
		return resultList;
		
	}

}
