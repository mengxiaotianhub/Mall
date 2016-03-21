package com.mengxiaotian.learn.mall.service.impi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mengxiaotian.learn.mall.dao.GoodsMapper;
import com.mengxiaotian.learn.mall.meta.Goods;
import com.mengxiaotian.learn.mall.servlet.GoodsService;

@Component("goodsService")
public class GoodsServiceImpi implements GoodsService {
	
	@Autowired
	private GoodsMapper goodsMapper;

	public List<Goods> getAllGoods(boolean published) {
		// TODO Auto-generated method stub
		return goodsMapper.getAllGoods(published);
	}

	public List<Goods> getGoods(String colunm, String value) {
		// TODO Auto-generated method stub
		return goodsMapper.getGoods(colunm, value);
	}

	public List<Goods> getdelete() {
		// TODO Auto-generated method stub
		return goodsMapper.getdelete();
	}
	
	public void addGoods(Goods goods) {
		// TODO Auto-generated method stub
		goodsMapper.addGoods(goods);
	}

	public void updateGoods(Goods goods) {
		// TODO Auto-generated method stub
		goodsMapper.updateGoods(goods);
	}

	public void published(int id) {
		// TODO Auto-generated method stub
		Goods goods = goodsMapper.getOneGoods(id);
		goods.setDelete(false);
		goods.setPublished(true);
		goodsMapper.updateGoods(goods);
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		Goods goods = goodsMapper.getOneGoods(id);
		goods.setPublished(false);
		goods.setDelete(true);
		goodsMapper.updateGoods(goods);
	}
	

	public void getBackGoods(int id) {
		// TODO Auto-generated method stub
		Goods goods = goodsMapper.getOneGoods(id);
		goods.setPublished(false);
		goods.setDelete(false);
		goodsMapper.updateGoods(goods);
	}

}
