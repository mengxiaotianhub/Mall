package com.mengxiaotian.learn.mall.web.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.mengxiaotian.learn.mall.servlet.GoodsCodeService;
import com.mengxiaotian.learn.mall.servlet.GoodsService;
import com.mengxiaotian.learn.mall.servlet.Login;

@Controller
public class MallController {
	@Autowired
	private GoodsService goodsService;
	@Autowired
	private GoodsCodeService goodsCodeService;
	@Autowired
	private Login login;

	@RequestMapping(value="/userLogin")
	public String userLogin(@Param("name") String name,@Param("password")int password,Model map) {
		if(login.userLogin(name,password)){
			return "redirect:goods";
		}else{
			map.addAttribute("message", "error");
			return "redirect:/UserLogin.html";
		}
	}
	
	@RequestMapping(value="/managerLogin")
	public String managerLogin(@Param("name") String name,@Param("password") int password){
		if(login.managerLogin(name, password)){
			return "redirect:manager";
	}else{
		return "redirect:/ManagerLogin.html";
	}
	}
	
	@RequestMapping(value="/goods")
	public String showGoods(Model map){
		map.addAttribute("goodsList",goodsService.getAllGoods());
		return "goods";
	}
	
	@RequestMapping(value="/buy")
	@ResponseBody
	public String exchange(@Param("goodsId") int goodsId){
		return ((Integer) goodsCodeService.exchange(1, goodsId).getId()).toString();
	}
	@RequestMapping(value="/manager")
	public String manager(Model map){
		map.addAttribute("goodsList",goodsService.getAllGoods());
		map.addAttribute("codeList",goodsCodeService.getAllGoodsCode());
		return "manager";
	}
}
