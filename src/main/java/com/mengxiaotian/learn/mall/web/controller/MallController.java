package com.mengxiaotian.learn.mall.web.controller;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.mengxiaotian.learn.mall.meta.Goods;
import com.mengxiaotian.learn.mall.servlet.GoodsCodeService;
import com.mengxiaotian.learn.mall.servlet.GoodsService;
import com.mengxiaotian.learn.mall.servlet.LoginService;
import com.mengxiaotian.learn.mall.servlet.SignUpService;
import com.mengxiaotian.learn.mall.utils.NoCodeException;
import com.mengxiaotian.learn.mall.utils.NotEnoughPoint;

@Controller
public class MallController {
	@Autowired
	private GoodsService goodsService;
	@Autowired
	private GoodsCodeService goodsCodeService;
	@Autowired
	private LoginService login;
	@Autowired
	private SignUpService signUp;;

	@RequestMapping(value="/userLogin")
	public String userLogin(@Param("name") String name,@Param("password")int password,Model map,HttpSession session) {
		if(login.userLogin(name,password)){
			session.setAttribute("userName", name);
			return "redirect:logined/goods";
		}else{
			map.addAttribute("message", "UserName or Password Error,please try again.");
			return "login/userLogin";
		}
	}
	
	@RequestMapping(value="/managerLogin")
	public String managerLogin(@Param("name") String name,@Param("password") int password,Model map){
		if(login.managerLogin(name, password)){
			return "redirect:logined/manager";
	}else{
		map.addAttribute("message", "ManagerName or Password Error,please try again.");
		return "login/managerLogin";
	}
	}
	
	@RequestMapping(value="/logined/goods")
	public String showGoods(Model map){
		map.addAttribute("goodsList",goodsService.getAllGoods(true));
		return "main/goods";
	}
	
	@RequestMapping(value="logined//buy")
	public String exchange(@Param("goodsId") int goodsId,Model map,HttpSession session){
		try{
		map.addAttribute("code",goodsCodeService.exchange(session.getAttribute("userName").toString(), goodsId).getCode());
		}catch(NoCodeException e){
			map.addAttribute("message", "Sorry,it's no code for your choosed goods.please choose another goods.");
			map.addAttribute("goodsList",goodsService.getAllGoods(true));
			return "main/goods";
		}catch(NotEnoughPoint e){
			map.addAttribute("message", "Sorry,it's not enough point of your account.");
			map.addAttribute("goodsList",goodsService.getAllGoods(true));
			return "main/goods";
		}
		map.addAttribute("userName", session.getAttribute("userName"));
		return "main/buy";
	}
	@RequestMapping(value="/logined/manager")
	public String manager(Model map){
		map.addAttribute("goodsList",goodsService.getAllGoods(true));
		map.addAttribute("goodsNotPublishedList",goodsService.getAllGoods(false));
		map.addAttribute("delete",goodsService.getdelete());
		map.addAttribute("codeList",goodsCodeService.getAllGoodsCode());
		return "main/manager";
	}
	
	@RequestMapping(value="/addGoods")
	public String addGoods(@Param("goodsName") String goodsName,@Param("description") String description,@Param("point") int point){
		Goods goods = new Goods();
		goods.setName(goodsName);
		goods.setDescription(description);
		goods.setPoint(point);
		goodsService.addGoods(goods);
		return "redirect:logined/manager";
	}
	
	@RequestMapping(value="/published")
	public String published(@Param("id") int id){
		goodsService.published(id);
		return "redirect:logined/manager";
	}
	
	@RequestMapping(value="/deleteGoods")
	public String deleteGoods(@Param("id") int id){
		goodsService.delete(id);
		return "redirect:logined/manager";
	}
	
	@RequestMapping(value="/getBackGoods")
	public String getBackGoods(@Param("id") int id){
		goodsService.getBackGoods(id);
		return "redirect:logined/manager";
	}
	
	@RequestMapping(value="/addGoodsCode")
	public String addGoodsCode(@Param("goodsId") int goodsId){
		goodsCodeService.addGoodsCode(goodsId);
		return "redirect:logined/manager";
	}
	
	@RequestMapping(value="/managerSignUp")
	public String managerSignUp(@Param("name") String name,@Param("password") int password,Model map){
		if(signUp.managerSignUp(name, password)){
			map.addAttribute("message", "please login again.");
			return "login/managerLogin";
		}else{
			map.addAttribute("message", "Sorry,your managername used.");
			return "login/managerSignUp";
		}
		
	}
	@RequestMapping(value="/userSignUp")
	public String userSignUp(@Param("name") String name,@Param("password") int password,Model map){
		if(signUp.userSignUp(name, password)){
			map.addAttribute("message","please login again." );
			return "login/userLogin";
		}else{
			map.addAttribute("message", "Sorry,your username used.");
			return "login/userSignUp";
		}
		
	}
	
}
