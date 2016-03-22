package com.mengxiaotian.learn.mall.service.impi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mengxiaotian.learn.mall.dao.ManagerMapper;
import com.mengxiaotian.learn.mall.dao.UserMapper;
import com.mengxiaotian.learn.mall.meta.User;
import com.mengxiaotian.learn.mall.servlet.LoginService;

//定义bean
@Component("login")
public class LoginImpi implements LoginService {
	//依赖注入
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private ManagerMapper managerMapper;

	//用户登陆验证，验证失败返回false
	public boolean userLogin(String userName, int password) {
		User user=userMapper.login(userName, password);
		if ( user== null) {
			return false;
		} else {
			return true;

		}
	}
	//管理员登陆验证，验证失败返回false
	public boolean managerLogin(String managerName, int password) {
		if (managerMapper.login(managerName, password) == null) {
			return false;
		} else {
			return true;

		}
	}

}
