package com.mengxiaotian.learn.mall.meta;

import java.util.Date;

public class GoodsCode {
	private int id;
	private String userName;
	private int goodsId;
	private int code;
	private Date exchangeTime;
	private boolean exchanged;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public Date getExchangeTime() {
		return exchangeTime;
	}

	public void setExchangeTime(Date date) {
		this.exchangeTime = date;
	}

	public boolean isExchanged() {
		return exchanged;
	}

	public void setExchanged(boolean exchanged) {
		this.exchanged = exchanged;
	}

}
