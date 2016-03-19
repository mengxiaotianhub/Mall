package com.mengxiaotian.learn.mall.web.controller;


import java.io.IOException;
import java.io.Writer;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mengxiaotian.learn.mall.meta.User;
import com.mengxiaotian.learn.mall.servlet.SelectUser;

public class HelloController {
	
	@Autowired
	private  SelectUser selectUser;
	
	@RequestMapping(value="/spring/login")
	public String spring(@RequestParam("name") String name,@RequestParam("password") String password,ModelMap map) throws IOException{
		map.addAttribute("name",name);
		map.addAttribute("password",password);
		return "user";
	}
	
	@RequestMapping(value="/spring/write")
	public void table(@RequestHeader("Accept") String accept,Writer writer){
		List<User> userlist = selectUser.Select();
		for(User user:userlist){
		try {
			writer.write(user.getId()+ "--"+ user.getUserName()+ "<p />");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
	
	@RequestMapping(value="")
	public List<User> json(){
		List<User> userlist = selectUser.Select();
		return userlist;
		}
	
	@RequestMapping(value="/spring/table")
	public String freemarker(Model map){
		List<User> userlist = selectUser.Select();
		map.addAttribute("userlist",userlist);
		return "user1";
		}
	
	@RequestMapping(value="/spring/one.json")
	public User jsonOne(){
		User user = selectUser.SelectOne("id",1);
		return user;
		}
	
	@RequestMapping(value="/spring/one.html")
	public String html(Model map){
		User user = selectUser.SelectOne("id",1);
		map.addAttribute("userlist", user);
		return "user1";
		}
	
}

