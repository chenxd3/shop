package com.shop.service;

import java.util.List;

import com.shop.common.pojo.EUTreeNode;
import com.shop.pojo.ShopItemCat;

public interface ItemCatService {
	public List<EUTreeNode> getItemCatList(long parentId) throws Exception;

}
