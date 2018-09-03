package com.shop.portal.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.shop.common.pojo.TaotaoResult;
import com.shop.common.utils.HttpClientUtil;
import com.shop.common.utils.JsonUtils;
import com.shop.pojo.ShopContent;
import com.shop.portal.service.ContentService;

/**
 * 调用服务层服务，查询内容列表
 * <p>Title: ContentServiceImpl</p>
 * <p>Description: </p>
 */
@Service
public class ContentServiceImpl implements ContentService {

	@Value("${REST_BASE_URL}")
	private String REST_BASE_URL;
	@Value("${REST_INDEX_AD_URL}")
	private String REST_INDEX_AD_URL;
	
	@Override
	public String getContentList() {
		//调用服务层的服务
		String result = HttpClientUtil.doGet(REST_BASE_URL + REST_INDEX_AD_URL);
		//把字符串转换成TaotaoResult
		try {
			TaotaoResult taotaoResult = TaotaoResult.formatToList(result, ShopContent.class);
			//取内容列表
			List<ShopContent> list = (List<ShopContent>) taotaoResult.getData();
			List<Map> resultList = new ArrayList<>();
 			//创建一个jsp页码要求的pojo列表
			for (ShopContent shopContent : list) {
				Map map = new HashMap<>();
				map.put("src", shopContent.getPic());
				map.put("height", 240);
				map.put("width", 670);
				map.put("srcB", shopContent.getPic2());
				map.put("widthB", 550);
				map.put("heightB", 240);
				map.put("href", shopContent.getUrl());
				map.put("alt", shopContent.getSubTitle());
				resultList.add(map);
			}
			return JsonUtils.objectToJson(resultList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
