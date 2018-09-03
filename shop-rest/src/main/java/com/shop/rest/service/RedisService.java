package com.shop.rest.service;

import com.shop.common.pojo.TaotaoResult;

public interface RedisService {

	TaotaoResult syncContent(long contentCid);
}
