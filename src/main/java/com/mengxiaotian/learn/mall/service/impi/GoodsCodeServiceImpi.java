package com.mengxiaotian.learn.mall.service.impi;

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mengxiaotian.learn.mall.dao.GoodsCodeMapper;
import com.mengxiaotian.learn.mall.dao.GoodsMapper;
import com.mengxiaotian.learn.mall.dao.UserMapper;
import com.mengxiaotian.learn.mall.meta.GoodsCode;
import com.mengxiaotian.learn.mall.servlet.GoodsCodeService;
import com.mengxiaotian.learn.mall.utils.NoCodeException;
import com.mengxiaotian.learn.mall.utils.NotEnoughPoint;

@Component("goodsCodeService")
public class GoodsCodeServiceImpi implements GoodsCodeService {
	@Autowired
	private GoodsCodeMapper codeMapper;
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private GoodsMapper goodsMapper;
	public List<GoodsCode> getAllGoodsCode() {
		// TODO Auto-generated method stub
		return codeMapper.getAllGoodsCode();
	}

	public void addGoodsCode(GoodsCode goodsCode) {
		// TODO Auto-generated method stub
		codeMapper.addGoodsCode(goodsCode);
	}

	public void updateGoodsCode(GoodsCode goodsCode) {
		// TODO Auto-generated method stub
		codeMapper.updateGoodsCode(goodsCode);
	}


	public List<GoodsCode> getCodes(String colunm, String value) {
		// TODO Auto-generated method stub
		return codeMapper.getCodes(colunm, value);
	}

	public GoodsCode exchange(String userName,int goodsId) {
		// TODO Auto-generated method stub
		GoodsCode code = null;
		int userPoint = userMapper.getPoint(userName);
		int goodsPoint = goodsMapper.getOneGoods(goodsId).getPoint();
		if(userPoint>=goodsPoint){
			code=codeMapper.getOneNotExchenged(goodsId);
			if(code!=null){
				 code.setExchanged(true);
				 code.setExchangeTime(new Date());
				 code.setUserName(userName);
				 codeMapper.updateGoodsCode(code);
				 userMapper.updatePoint(userPoint-goodsPoint);
			}else{
				throw new NoCodeException();
			}
		}else{
			throw new NotEnoughPoint();
		}
		return code;
	}

	public void addGoodsCode(int goodsId) {
		// TODO Auto-generated method stub
		GoodsCode goodsCode=new GoodsCode();
		goodsCode.setGoodsId(goodsId);
		goodsCode.setCode(((Integer)(new Random().nextInt(10000000))).toString());
		codeMapper.addGoodsCode(goodsCode);
	}


}
