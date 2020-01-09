package com.example.pj.goods.service;

import java.util.Map;

import com.example.pj.goods.pojo.Goods;

public interface GoodsService {
	public Map<String, Object> findGoods();
	
	public void deleteById(Integer id);
	
	public int saveObject(Goods goods);
}
