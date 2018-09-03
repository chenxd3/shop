package com.shop.rest.service;

import java.util.List;

import com.shop.pojo.ShopContent;

public interface ContentService {

	List<ShopContent> getContentList(long contentCid);
}
