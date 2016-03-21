package com.mengxiaotian.learn.mall.servlet;

public interface SignUpService {
	
	public boolean userSignUp(String userName,int password);
	public boolean managerSignUp(String managerName,int password);

}
