package com.mengxiaotian.learn.mall.service.impi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mengxiaotian.learn.mall.dao.ManagerMapper;
import com.mengxiaotian.learn.mall.dao.UserMapper;
import com.mengxiaotian.learn.mall.meta.Manager;
import com.mengxiaotian.learn.mall.meta.User;
import com.mengxiaotian.learn.mall.servlet.SignUpService;

@Component("SignUp")
public class SignUpServiceImpi implements SignUpService {
	
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private ManagerMapper managerMapper;

	public boolean userSignUp(String userName, int password) {
		// TODO Auto-generated method stub
		if(userMapper.getUser(userName)==null){
		User user =new User();
		user.setUserName(userName);
		user.setPassword(password);
		user.setPoint(1000);
		userMapper.addUser(user);
		return true;}
		else{
			return false;
		}
	}

	public boolean managerSignUp(String managerName, int password) {
		// TODO Auto-generated method stub
		if(managerMapper.getManager(managerName)==null){
		Manager manager = new Manager();
		manager.setManagerName(managerName);
		manager.setPassword(password);
		managerMapper.addManager(manager);
		return true;
		}else{
			return false;
		}
	}

}
