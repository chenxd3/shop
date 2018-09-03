package com.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shop.common.pojo.EUDataGridResult;
import com.shop.common.pojo.TaotaoResult;
import com.shop.pojo.ShopItem;
import com.shop.service.ItemService;

/**
 * 商品Controller
 * 
 * @author chenxd
 *
 */
@Controller
public class ItemController {
	@Autowired
	private ItemService itemService;

	@RequestMapping("item/{itemId}")
	@ResponseBody
	public ShopItem getItemById(@PathVariable long itemId) {
		ShopItem item = itemService.getItemById(itemId);
		return item;
	}

	@RequestMapping("item/list")
	@ResponseBody
	public EUDataGridResult getItemList(Integer page, Integer rows) {
		EUDataGridResult result = itemService.getItemList(page, rows);
		return result;
	}

	@RequestMapping("/item/save")
	@ResponseBody
	public TaotaoResult saveItem(ShopItem item, String desc, String itemParams) throws Exception {
		// 添加商品信息
		itemService.createItem(item, desc, itemParams);
		return TaotaoResult.ok();
	}

}
