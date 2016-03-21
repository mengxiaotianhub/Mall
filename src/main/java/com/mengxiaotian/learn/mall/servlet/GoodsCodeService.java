package com.mengxiaotian.learn.mall.servlet;

import java.util.List;

import com.mengxiaotian.learn.mall.meta.GoodsCode;

public interface GoodsCodeService {
	
	public List<GoodsCode> getAllGoodsCode();
	
	public List<GoodsCode> getCodes(String colunm,String value);
	
	public void addGoodsCode(GoodsCode goodsCode);
	
	public void updateGoodsCode(GoodsCode goodsCode);
	
	public GoodsCode exchange(String userName,int goodsId);

	public void addGoodsCode(int goodsId);
}
