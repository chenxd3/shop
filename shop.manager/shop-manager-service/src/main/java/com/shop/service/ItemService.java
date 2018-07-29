package com.shop.service;

import com.shop.common.pojo.EUDataGridResult;
import com.shop.pojo.ShopItem;

public interface ItemService {
	
	ShopItem getItemById(long itemId);
	
	EUDataGridResult getItemList(int page, int rows);
}
