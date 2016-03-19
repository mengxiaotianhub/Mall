package com.mengxiaotian.learn.mall.servlet;

import java.util.List;

import com.mengxiaotian.learn.mall.meta.Goods;

public interface GoodsService {
	
	public List<Goods> getAllGoods();
	
	public List<Goods> getGoods(String colunm,String value);
	
	public void addGoods(Goods goods);
	
	public void updateGoods(Goods goods);
	

}
