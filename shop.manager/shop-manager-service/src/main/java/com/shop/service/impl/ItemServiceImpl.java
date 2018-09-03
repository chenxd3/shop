package com.shop.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shop.common.pojo.EUDataGridResult;
import com.shop.common.pojo.TaotaoResult;
import com.shop.common.utils.IDUtils;
import com.shop.mapper.ShopItemDescMapper;
import com.shop.mapper.ShopItemMapper;
import com.shop.mapper.ShopItemParamItemMapper;
import com.shop.pojo.ShopItem;
import com.shop.pojo.ShopItemDesc;
import com.shop.pojo.ShopItemExample;
import com.shop.pojo.ShopItemExample.Criteria;
import com.shop.pojo.ShopItemParam;
import com.shop.pojo.ShopItemParamItem;
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
	
	@Autowired
	private ShopItemDescMapper iteamDescMapper;
	
	@Autowired
	private ShopItemParamItemMapper itemParamItemMapper;

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

	@Override
	public TaotaoResult createItem(ShopItem item, String desc, String itemParam) throws Exception {
		Long itemId = IDUtils.genItemId();
		item.setId(itemId);
		item.setStatus((byte) 1);
		item.setCreated(new Date());
		item.setUpdated(new Date());
		itemMapper.insert(item);
		//添加商品描述信息
		TaotaoResult result = insertItemDesc(itemId, desc);
		if (result.getStatus() != 200) {
			throw new Exception();
		}
		//添加谷歌参数
		result = insertItemParamItem(itemId, itemParam);
		if (result.getStatus() != 200) {
			throw new Exception();
		}
		return TaotaoResult.ok();

	}
	
	/**
	 * 添加商品描述
	 * <p>Title: insertItemDesc</p>
	 * <p>Description: </p>
	 * @param desc
	 */
	private TaotaoResult insertItemDesc(Long itemId, String desc) {
		ShopItemDesc itemDesc = new ShopItemDesc();
		itemDesc.setItemId(itemId);
		itemDesc.setItemDesc(desc);
		itemDesc.setCreated(new Date());
		itemDesc.setUpdated(new Date());
		iteamDescMapper.insert(itemDesc);
		return TaotaoResult.ok();
	}

	/**
	 * 添加规格参数
	 * @param itemId
	 * @param itemParam
	 * @return
	 */
	private TaotaoResult insertItemParamItem(Long itemId, String itemParam){
		ShopItemParamItem itemParamItem = new ShopItemParamItem();
		itemParamItem.setItemId(itemId);
		itemParamItem.setParamData(itemParam);
		itemParamItem.setCreated(new Date());
		itemParamItem.setUpdated(new Date());
		
		itemParamItemMapper.insert(itemParamItem);
		return TaotaoResult.ok();
	}

}
