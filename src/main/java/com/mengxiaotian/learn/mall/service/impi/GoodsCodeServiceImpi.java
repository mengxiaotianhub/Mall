package com.mengxiaotian.learn.mall.service.impi;

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mengxiaotian.learn.mall.dao.GoodsCodeMapper;
import com.mengxiaotian.learn.mall.dao.GoodsMapper;
import com.mengxiaotian.learn.mall.dao.UserMapper;
import com.mengxiaotian.learn.mall.meta.GoodsCode;
import com.mengxiaotian.learn.mall.meta.User;
import com.mengxiaotian.learn.mall.servlet.GoodsCodeService;
import com.mengxiaotian.learn.mall.utils.NoCodeException;
import com.mengxiaotian.learn.mall.utils.NotEnoughPoint;

//定义bean和事务
@Component("goodsCodeService")
@Repository
public class GoodsCodeServiceImpi implements GoodsCodeService {
	//依赖注入
	@Autowired
	private GoodsCodeMapper codeMapper;
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private GoodsMapper goodsMapper;
	//获取全部的兑换码记录
	public List<GoodsCode> getAllGoodsCode() {
		// TODO Auto-generated method stub
		return codeMapper.getAllGoodsCode();
	}
	//根据兑换码的模型信息更新兑换码记录
	public void updateGoodsCode(GoodsCode goodsCode) {
		// TODO Auto-generated method stub
		codeMapper.updateGoodsCode(goodsCode);
	}

	//根据特定的行和值获取兑换码集合
	public List<GoodsCode> getCodes(String colunm, String value) {
		// TODO Auto-generated method stub
		return codeMapper.getCodes(colunm, value);
	}
	//定义required类型的事务
	//交易服务
	@Transactional(propagation = Propagation.REQUIRED)
	public GoodsCode exchange(String userName,int goodsId) {
		// TODO Auto-generated method stub
		//创建空的兑换码引用
		GoodsCode code = null;
		//根据用户名获取用户的模型信息
		User user = userMapper.getUser(userName);
		//根据商品id获取商品所需积分
		int goodsPoint = goodsMapper.getOneGoods(goodsId).getPoint();
		//判断用户积分余额是否足够，不够的情况下抛出异常
		if(user.getPoint()>=goodsPoint){
			//根据商品id获取一个对应的兑换码
			code=codeMapper.getOneNotExchenged(goodsId);
			//普黯淡是否还有兑换码没有的情况下抛出异常
			if(code!=null){
				//交易执行，更新兑换码和用户积分的状态并更新，保证事务
				 code.setExchanged(true);
				 code.setExchangeTime(new Date());
				 code.setUserName(userName);
				 codeMapper.updateGoodsCode(code);
				 user.setPoint(user.getPoint()-goodsPoint);
				 userMapper.updateUser(user);
			}else{
				throw new NoCodeException();
			}
		}else{
			throw new NotEnoughPoint();
		}
		return code;
	}
	//根据商品id添加新的兑换码
	public void addGoodsCode(int goodsId) {
		// TODO Auto-generated method stub
		GoodsCode goodsCode=new GoodsCode();
		goodsCode.setGoodsId(goodsId);
		//新的兑换码由随机数生成
		goodsCode.setCode(((Integer)(new Random().nextInt(10000000))).toString());
		codeMapper.addGoodsCode(goodsCode);
	}


}
