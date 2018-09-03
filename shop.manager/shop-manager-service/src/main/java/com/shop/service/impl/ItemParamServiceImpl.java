package com.shop.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.common.pojo.TaotaoResult;
import com.shop.mapper.ShopItemParamMapper;
import com.shop.pojo.ShopItemParam;
import com.shop.pojo.ShopItemParamExample;
import com.shop.pojo.ShopItemParamExample.Criteria;
import com.shop.service.ItemParamService;

@Service
public class ItemParamServiceImpl implements ItemParamService {

	@Autowired
	private ShopItemParamMapper itemParamMapper;
	
	@Override
	public TaotaoResult getItemParamByCid(long id) {
		ShopItemParamExample example = new ShopItemParamExample();
		Criteria criteria = example.createCriteria();
		criteria.andItemCatIdEqualTo(id);
		List<ShopItemParam> list = itemParamMapper.selectByExampleWithBLOBs(example);
		if(list != null && list.size()>0){
			return TaotaoResult.ok(list.get(0));
		}
		return TaotaoResult.ok();
		
	}

	@Override
	public TaotaoResult insertItemParam(ShopItemParam itemParam) {
		//补全pojo
		itemParam.setCreated(new Date());
		itemParam.setUpdated(new Date());
		//插入到规格参数模板表
		itemParamMapper.insert(itemParam);
		return TaotaoResult.ok();

	}

}
