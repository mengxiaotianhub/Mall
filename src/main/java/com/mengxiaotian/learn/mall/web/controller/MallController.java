package com.mengxiaotian.learn.mall.web.controller;

import javax.servlet.http.HttpServletRequest;
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
	public String userLogin(@Param("name") String name,@Param("password")int password,Model map,HttpServletRequest request) {
		if(login.userLogin(name,password)){
			HttpSession session = request.getSession();
			session.setAttribute("userName", name);
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
	public String exchange(@Param("goodsId") int goodsId,Model map,HttpSession session){
		map.addAttribute("code",goodsCodeService.exchange(session.getAttribute("userName").toString(), goodsId).getCode());
		map.addAttribute("userName", session.getAttribute("userName"));
		return "buy";
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
	
	@RequestMapping(value="/getBackGoods")
	public String getBackGoods(@Param("id") int id){
		goodsService.getBackGoods(id);
		return "redirect:manager";
	}
	
	@RequestMapping(value="/addGoodsCode")
	public String addGoodsCode(@Param("goodsId") int goodsId){
		goodsCodeService.addGoodsCode(goodsId);
		return "redirect:manager";
	}
	
	@RequestMapping(value="/managerSignUp")
	public String managerSignUp(@Param("name") String name,@Param("password") int password){
		if(signUp.managerSignUp(name, password)){
			return "redirect:/ManagerLogin.html";
		}else{
			return "redirect:/ManagerSignUp.html";
		}
		
	}
	@RequestMapping(value="/userSignUp")
	public String userSignUp(@Param("name") String name,@Param("password") int password){
		if(signUp.userSignUp(name, password)){
			return "redirect:/UserLogin.html";
		}else{
			return "redirect:/UserSignUp.html";
		}
		
	}
	
}
