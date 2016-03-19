package com.mengxiaotian.learn.mall.servlet;

public interface Login {
	
	public boolean userLogin(String userName,int password);
	public boolean managerLogin(String managerName,int password);

}
