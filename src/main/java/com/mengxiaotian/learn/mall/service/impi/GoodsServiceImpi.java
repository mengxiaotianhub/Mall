package com.mengxiaotian.learn.mall.service.impi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mengxiaotian.learn.mall.dao.GoodsMapper;
import com.mengxiaotian.learn.mall.meta.Goods;
import com.mengxiaotian.learn.mall.servlet.GoodsService;

//定义bean
@Component("goodsService")
public class GoodsServiceImpi implements GoodsService {
	//依赖注入
	@Autowired
	private GoodsMapper goodsMapper;

	//根据发布状态获取商品列表
	public List<Goods> getAllGoods(boolean published) {
		// TODO Auto-generated method stub
		return goodsMapper.getAllGoods(published);
	}
	//根据特定的行和值获取商品列表
	public List<Goods> getGoods(String colunm, String value) {
		// TODO Auto-generated method stub
		return goodsMapper.getGoods(colunm, value);
	}
	//获取被删除的商品列表
	public List<Goods> getdelete() {
		// TODO Auto-generated method stub
		return goodsMapper.getdelete();
	}
	//根据商品模型信息添加商品记录
	public void addGoods(Goods goods) {
		// TODO Auto-generated method stub
		goodsMapper.addGoods(goods);
	}
	//根据商品模型信息更新商品记录
	public void updateGoods(Goods goods) {
		// TODO Auto-generated method stub
		goodsMapper.updateGoods(goods);
	}
	//根据商品id发布商品
	public void published(int id) {
		// TODO Auto-generated method stub
		Goods goods = goodsMapper.getOneGoods(id);
		goods.setDelete(false);
		goods.setPublished(true);
		goodsMapper.updateGoods(goods);
	}
	//根据商品id找回商品	
	public void delete(int id) {
		// TODO Auto-generated method stub
		Goods goods = goodsMapper.getOneGoods(id);
		goods.setPublished(false);
		goods.setDelete(true);
		goodsMapper.updateGoods(goods);
	}
	
	//根据商品id找回商品
	public void getBackGoods(int id) {
		// TODO Auto-generated method stub
		Goods goods = goodsMapper.getOneGoods(id);
		goods.setPublished(false);
		goods.setDelete(false);
		goodsMapper.updateGoods(goods);
	}

}
