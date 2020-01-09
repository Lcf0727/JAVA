package com.example.pj.goods.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.pj.goods.pojo.Goods;

@Mapper
public interface GoodsDao {
	
	public List<Goods> findGoods();
	
	public void deleteById(Integer id);
	
	public int insertObject(Goods entity);
}
