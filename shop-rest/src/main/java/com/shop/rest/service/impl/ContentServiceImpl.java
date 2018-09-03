package com.shop.rest.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.shop.common.utils.JsonUtils;
import com.shop.mapper.ShopContentMapper;
import com.shop.pojo.ShopContent;
import com.shop.pojo.ShopContentExample;
import com.shop.pojo.ShopContentExample.Criteria;
import com.shop.rest.dao.JedisClient;
import com.shop.rest.service.ContentService;

import sun.tools.jar.resources.jar;

/**
 * 内容管理
 * <p>Title: ContentServiceImpl</p>
 * <p>Description: </p>
 * @author	chenxd
 */
@Service
public class ContentServiceImpl implements ContentService {

	@Autowired
	private ShopContentMapper contentMapper;
	@Autowired
	private JedisClient jedisClient;
	@Value("${INDEX_CONTENT_REDIS_KEY}")
	private String INDEX_CONTENT_REDIS_KEY;
	
	
	@Override
	public List<ShopContent> getContentList(long contentCid) {
		//从缓存中取内容
		try {
			String result = jedisClient.hget(INDEX_CONTENT_REDIS_KEY, contentCid + "");
			if (!StringUtils.isBlank(result)) {
				//把字符串转换成list
				List<ShopContent> resultList = JsonUtils.jsonToList(result, ShopContent.class);
				return resultList;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//根据内容分类id查询内容列表
		ShopContentExample example = new ShopContentExample();
		Criteria criteria = example.createCriteria();
		criteria.andCategoryIdEqualTo(contentCid);
		//执行查询
		List<ShopContent> list = contentMapper.selectByExample(example);
		
		//向缓存中添加内容
		try {
			//把list转换成字符串
			String cacheString = JsonUtils.objectToJson(list);
			jedisClient.hset(INDEX_CONTENT_REDIS_KEY, contentCid + "", cacheString);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

}
