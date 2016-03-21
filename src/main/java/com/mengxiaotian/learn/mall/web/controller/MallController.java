package com.mengxiaotian.learn.mall.web.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mengxiaotian.learn.mall.meta.Goods;
import com.mengxiaotian.learn.mall.servlet.GoodsCodeService;
import com.mengxiaotian.learn.mall.servlet.GoodsService;
import com.mengxiaotian.learn.mall.servlet.LoginService;

@Controller
public class MallController {
	@Autowired
	private GoodsService goodsService;
	@Autowired
	private GoodsCodeService goodsCodeService;
	@Autowired
	private LoginService login;

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
		map.addAttribute("goodsList",goodsService.getAllGoods(true));
		return "goods";
	}
	
	@RequestMapping(value="/buy")
	@ResponseBody
	public String exchange(@Param("goodsId") int goodsId){
		return goodsCodeService.exchange(1, goodsId).getCode();
	}
	@RequestMapping(value="/manager")
	public String manager(Model map){
		map.addAttribute("goodsList",goodsService.getAllGoods(true));
		map.addAttribute("goodsNotPublishedList",goodsService.getAllGoods(false));
		map.addAttribute("delete",goodsService.getdelete());
		map.addAttribute("codeList",goodsCodeService.getAllGoodsCode());
		return "manager";
	}
	
	@RequestMapping(value="/addGoods")
	public String addGoods(@Param("goodsName") String goodsName,@Param("description") String description,@Param("point") int point){
		Goods goods = new Goods();
		goods.setName(goodsName);
		goods.setDescription(description);
		goods.setPoint(point);
		goodsService.addGoods(goods);
		return "redirect:manager";
	}
	
	@RequestMapping(value="/published")
	public String published(@Param("id") int id){
		goodsService.published(id);
		return "redirect:manager";
	}
	
	@RequestMapping(value="/deleteGoods")
	public String deleteGoods(@Param("id") int id){
		goodsService.delete(id);
		return "redirect:manager";
	}
}
