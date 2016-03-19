package com.mengxiaotian.learn.mall.servlet;

import java.util.List;

import com.mengxiaotian.learn.mall.meta.User;

public interface SelectUser {

	public List<User> Select();
	public User SelectOne(String idName,int id);
}
