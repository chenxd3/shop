package com.shop.service;

import com.shop.common.pojo.EUDataGridResult;
import com.shop.common.pojo.TaotaoResult;
import com.shop.pojo.ShopItem;
import com.shop.pojo.ShopItemDesc;

public interface ItemService {
	
	ShopItem getItemById(long itemId);
	
	EUDataGridResult getItemList(int page, int rows);
	
	TaotaoResult createItem(ShopItem item, String itemDesc, String itemParam) throws Exception;
}
