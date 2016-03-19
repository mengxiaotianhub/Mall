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

	public List<Goods> getAllGoods() {
		// TODO Auto-generated method stub
		return goodsMapper.getAllGoods();
	}

	public List<Goods> getGoods(String colunm, String value) {
		// TODO Auto-generated method stub
		return goodsMapper.getGoods(colunm, value);
	}

	public void addGoods(Goods goods) {
		// TODO Auto-generated method stub
		goodsMapper.addGoods(goods);
	}

	public void updateGoods(Goods goods) {
		// TODO Auto-generated method stub
		goodsMapper.updateGoods(goods);
	}


}
