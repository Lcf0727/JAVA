package com.example.pj.goods.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pj.goods.dao.GoodsDao;
import com.example.pj.goods.pojo.Goods;
import com.example.pj.goods.service.GoodsService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class GoodsServiceImpl implements GoodsService {

	@Autowired
	private GoodsDao goodsDao;
	@Override
	public Map<String, Object> findGoods() {
		Map<String, Object> map = new HashMap<>();
		long t1 = System.currentTimeMillis();
		List<Goods> goods = goodsDao.findGoods();
		long t2 = System.currentTimeMillis();
		log.info("execute time {}",(t2-t1)+"秒"); //{}表示占位符
		String time = t2-t1+"毫秒";
		map.put("data", goods);
		map.put("time", time);
		return map;
	}
	
	@Override
	public void deleteById(Integer id) {
		goodsDao.deleteById(id);
	}
	
	@Override
	public int saveObject(Goods goods) {
		int rows = goodsDao.insertObject(goods);
		return rows;
	}

}
