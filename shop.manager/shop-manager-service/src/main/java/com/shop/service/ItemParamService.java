package com.shop.service;

import com.shop.common.pojo.TaotaoResult;
import com.shop.pojo.ShopItemParam;

public interface ItemParamService {
	public TaotaoResult getItemParamByCid(long id);
	
	public TaotaoResult insertItemParam(ShopItemParam itemParam);

}
