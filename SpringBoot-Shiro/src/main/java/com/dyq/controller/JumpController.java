package com.dyq.controller;

import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * MVC跳转Controller
 * @author dyq
 *
 */
@Controller
public class JumpController {
	
	//首页跳转
	@RequestMapping("toabout")
	public String toabout(){ return "/about";}
	@RequestMapping("toindex")
	public String toindex(){ return "/index";}
	@RequestMapping("tocase")
	public String tocase() { return "/case"; }
	@RequestMapping("tonews")
	public String tonews() { return "/news"; }
	@RequestMapping("tostatistics")
	public String tostatistics() { return "/statistics"; }
	
	//登录注册
	@RequestMapping("tologin")
	public String tologin(){ return "/login";}
	@RequestMapping("toregister")
	public String toregister(){ return "/register";}
	
	//登陆成功跳转页面
	@RequestMapping("toHomePage")
	public String tomessage(){ return "/authPage/homePage";}
	//退出登录
	@RequestMapping("logout")
	public String logout(){ SecurityUtils.getSubject().logout(); return "/index"; }
	
}
