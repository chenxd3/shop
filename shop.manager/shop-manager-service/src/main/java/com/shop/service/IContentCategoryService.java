package com.shop.service;

import java.util.List;

import com.shop.common.pojo.EUTreeNode;
import com.shop.common.pojo.TaotaoResult;

public interface IContentCategoryService {

	List<EUTreeNode> getCategoryList(long parentId);
	
	TaotaoResult insertContentCategory(long parentId, String name);
	
	TaotaoResult deleteContentCategory(long parentId, long id);
	
	TaotaoResult updateContentCategory(long id, String name);
}
