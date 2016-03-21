package com.mengxiaotian.learn.mall.servlet;

import java.util.List;

import com.mengxiaotian.learn.mall.meta.Goods;

public interface GoodsService {
	
	public List<Goods> getAllGoods(boolean published);
	
	public List<Goods> getGoods(String colunm,String value);
	
	public void addGoods(Goods goods);
	
	public void updateGoods(Goods goods);
	
	public void published(int id);

	public List<Goods> getdelete();
	
	public void delete(int id);
	
	public void getBackGoods(int id);
	
}
