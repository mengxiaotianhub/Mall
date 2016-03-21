package com.mengxiaotian.learn.mall.servlet;

public interface LoginService {
	
	public boolean userLogin(String userName,int password);
	public boolean managerLogin(String managerName,int password);

}
