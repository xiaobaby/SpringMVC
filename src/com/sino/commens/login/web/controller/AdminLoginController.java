package com.sino.commens.login.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sino.commens.login.domain.AdminInfo;
import com.sino.commens.login.domain.BranchInfo;
import com.sino.commens.login.domain.PowerInfo;
import com.sino.commens.login.service.AdminLoginService;
import com.sino.commens.login.util.MD5;


@Controller
public class AdminLoginController {

	@Autowired
	private AdminLoginService adminLoginService;
	
	
	/*
	 * 跳转登录页面
	 */
	@RequestMapping("/home")
	public String toAdminLogin(HttpServletRequest request, HttpServletResponse response,String backUrl){
		return "/admin/login";
	}
	
	/*
	 * 校验登录
	 */
	@RequestMapping("/adminLoginCheck")
	@ResponseBody
	public Map<String, String> loginCheckAdmin(HttpServletRequest request, HttpServletResponse response,String username,String password){
		Map<String, String> loginMap = new HashMap<>();
		System.out.println("---username----"+username+"---password---"+password);
		loginMap.put("adminId", username);
		loginMap.put("adminPwd", MD5.Md5_32(password));
		Map<String, String> retMap;
		retMap = new HashMap<>();
		try {
			retMap = adminLoginService.adminLoginCheck(loginMap);
		} catch (Exception e) {
			retMap.put("error", "错误");
		}
		

		if ("Y".equals(retMap.get("flag"))) {
			HttpSession session = request.getSession();
	        session.setAttribute("adminId", username);
	        session.setAttribute("adminName", retMap.get("adminName"));
		}
		
		HttpSession session = request.getSession();
		session.setAttribute(username, username);
		System.out.println("保存Session成功!");
		return retMap;			
	}
	
	
}
