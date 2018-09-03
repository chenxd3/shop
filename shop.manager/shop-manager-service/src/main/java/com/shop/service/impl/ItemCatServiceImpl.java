package com.shop.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.common.pojo.EUTreeNode;
import com.shop.mapper.ShopItemCatMapper;
import com.shop.pojo.ShopItemCat;
import com.shop.pojo.ShopItemCatExample;
import com.shop.pojo.ShopItemCatExample.Criteria;
import com.shop.service.ItemCatService;

@Service
public class ItemCatServiceImpl implements ItemCatService {

	@Autowired
	private ShopItemCatMapper itemCatMapper; 
	
	@Override
	public List<EUTreeNode> getItemCatList(long parentId) throws Exception {
		
		ShopItemCatExample example = new ShopItemCatExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		List<ShopItemCat> list = itemCatMapper.selectByExample(example);
		List<EUTreeNode> resultList = new ArrayList();
		for(ShopItemCat shopItemCat : list){
			EUTreeNode node = new EUTreeNode();
			node.setId(shopItemCat.getId());
			node.setState(shopItemCat.getParentId()==0?"closed":"open");
			node.setText(shopItemCat.getName());
			resultList.add(node);
		}
		return resultList;
	}

}
