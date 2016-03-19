package com.mengxiaotian.learn.mall.service.impi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mengxiaotian.learn.mall.dao.UserMapper;
import com.mengxiaotian.learn.mall.meta.User;
import com.mengxiaotian.learn.mall.servlet.SelectUser;

@Component("selectUser")
public class SelectUserImpi implements SelectUser {
	
	@Autowired
	private UserMapper userMapper;
	
	public UserMapper getUserMapper() {
		return userMapper;
	}

	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	public List<User> Select(){
		return null;
		
		
	}

	public User SelectOne(String idName,int id) {
		// TODO Auto-generated method stub
		User user = new User();
		user.setId(10);
		user.setUserName("xiaohonghong");
		userMapper.addUser(user);
		return user;
	}

}
