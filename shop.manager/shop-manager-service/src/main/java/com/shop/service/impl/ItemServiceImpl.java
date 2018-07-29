package com.shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shop.common.pojo.EUDataGridResult;
import com.shop.mapper.ShopItemMapper;
import com.shop.pojo.ShopItem;
import com.shop.pojo.ShopItemExample;
import com.shop.pojo.ShopItemExample.Criteria;
import com.shop.service.ItemService;

/**
 * 商品管理Service
 * @author Administrator
 *
 */
@Service
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	private ShopItemMapper itemMapper;

	@Override
	public ShopItem getItemById(long itemId) {
		
		//ShopItem item = itemMapper.selectByPrimaryKey(itemId);
		
		ShopItemExample example = new ShopItemExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(itemId);
		List<ShopItem> list = itemMapper.selectByExample(example);
		if(list !=null && list.size() > 0) {
			ShopItem item = list.get(0);
			return item;
		}
		return null;
	}

	/**
	 * 查询商品列表
	 */
	@Override
	public EUDataGridResult getItemList(int page, int rows) {
		//查询商品列表
		ShopItemExample example = new ShopItemExample();
		//分页处理
		PageHelper.startPage(page, rows);
		List<ShopItem> list = itemMapper.selectByExample(example);
		//创建一个返回对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取总记录条数
		PageInfo<ShopItem> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		
		return result;
	}

}
