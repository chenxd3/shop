package com.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shop.common.pojo.EUTreeNode;
import com.shop.common.pojo.TaotaoResult;
import com.shop.service.IContentCategoryService;

@Controller
@RequestMapping("/content/category")
public class ContentCategoryController {

	@Autowired
	private IContentCategoryService contentCategoryService;
	
	@RequestMapping("/list")
	@ResponseBody
	public List<EUTreeNode> getContentCatList(@RequestParam(value="id",defaultValue="0") long parentId){
		List<EUTreeNode> list = contentCategoryService.getCategoryList(parentId);
		return list;
	}
	
	@RequestMapping("/create")
	@ResponseBody
	public TaotaoResult creatContentCategory(long parentId, String name){
		TaotaoResult result = contentCategoryService.insertContentCategory(parentId, name);
		return result;
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public TaotaoResult deleteContentCategory(@RequestParam(value="parentId" ,defaultValue="0") long parentId, @RequestParam(value="id") long id){
		TaotaoResult result = contentCategoryService.deleteContentCategory(parentId, id);
		return result;
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public TaotaoResult updateContentCategory(long id, String name){
		TaotaoResult result = contentCategoryService.updateContentCategory(id, name);
		return result;
	}
	
}
