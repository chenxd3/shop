package com.shop.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shop.common.utils.JsonUtils;
import com.shop.rest.pojo.CatResult;
import com.shop.rest.service.ItemCatService;

@Controller
public class ItemCatController {
	
	@Autowired
	private ItemCatService itemCatService;
	
	/*@RequestMapping(value = "/itemcat/list", produces=MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
	@ResponseBody
	public String getItemCatList(String callBack){
		CatResult catResult = itemCatService.getItemCatList();
		
		String json = JsonUtils.objectToJson(catResult);
		
		String result = callBack + "(" +json+ ")";
		return result;
	}
	*/
	
	@RequestMapping(value = "/itemcat/list")
	@ResponseBody
	public Object getItemCatList(String callback){
		CatResult catResult = itemCatService.getItemCatList();
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(catResult);
		mappingJacksonValue.setJsonpFunction(callback);
		return mappingJacksonValue;
	}

}
