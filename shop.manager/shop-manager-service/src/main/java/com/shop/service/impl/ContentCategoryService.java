package com.shop.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.common.pojo.EUTreeNode;
import com.shop.common.pojo.TaotaoResult;
import com.shop.mapper.ShopContentCategoryMapper;
import com.shop.pojo.ShopContentCategory;
import com.shop.pojo.ShopContentCategoryExample;
import com.shop.pojo.ShopContentCategoryExample.Criteria;
import com.shop.service.IContentCategoryService;
import com.sun.tools.internal.ws.wsdl.document.jaxws.Exception;

@Service
public class ContentCategoryService implements IContentCategoryService {

	@Autowired
	private ShopContentCategoryMapper contenCategoryMapper;
	
	@Override
	public List<EUTreeNode> getCategoryList(long parentId) {
		
		ShopContentCategoryExample example = new ShopContentCategoryExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		
		List<ShopContentCategory> list = contenCategoryMapper.selectByExample(example);
		List<EUTreeNode> resultList = new ArrayList<>();
		for(ShopContentCategory shopContentCategory : list){
			//创建一个节点
			EUTreeNode node = new EUTreeNode();
			node.setId(shopContentCategory.getId());
			node.setText(shopContentCategory.getName());
			node.setState(shopContentCategory.getIsParent()?"closed":"open");
			resultList.add(node);
		}
		return resultList;
	}

	@Override
	public TaotaoResult insertContentCategory(long parentId, String name) {
		ShopContentCategory shopContentCategory = new ShopContentCategory();
		shopContentCategory.setName(name);
		shopContentCategory.setIsParent(false);
		shopContentCategory.setParentId(parentId);
		shopContentCategory.setStatus(1);
		shopContentCategory.setSortOrder(1);
		shopContentCategory.setCreated(new Date());
		shopContentCategory.setUpdated(new Date());
		
		contenCategoryMapper.insert(shopContentCategory);
		//查看父节点的IsParent是否为true，不是的话改为true
		ShopContentCategory parent = contenCategoryMapper.selectByPrimaryKey(parentId);
		if(!parent.getIsParent()){
			parent.setIsParent(true);
			contenCategoryMapper.updateByPrimaryKey(parent);
		}
		
		return TaotaoResult.ok(shopContentCategory);
	}

	@Override
	public TaotaoResult deleteContentCategory(long parentId, long id) {
		ShopContentCategoryExample example = new ShopContentCategoryExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(id);
		contenCategoryMapper.deleteByExample(example);
		updateParentStatus(parentId);
		return TaotaoResult.ok();
	}
	
	private TaotaoResult updateParentStatus(long parentId){
		ShopContentCategoryExample example = new ShopContentCategoryExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		int count = contenCategoryMapper.countByExample(example);
		ShopContentCategory parent = contenCategoryMapper.selectByPrimaryKey(parentId);
		if(count == 0){
			parent.setIsParent(false);
			contenCategoryMapper.updateByPrimaryKey(parent);
		}
		return TaotaoResult.ok();
	}

	@Override
	public TaotaoResult updateContentCategory(long id, String name) {
		ShopContentCategory shopContentCategory = contenCategoryMapper.selectByPrimaryKey(id);
		shopContentCategory.setName(name);
		contenCategoryMapper.updateByPrimaryKey(shopContentCategory);
		return TaotaoResult.ok();
	}

}
