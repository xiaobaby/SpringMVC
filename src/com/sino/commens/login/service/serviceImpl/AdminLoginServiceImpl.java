package com.sino.commens.login.service.serviceImpl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sino.commens.login.dao.AdminLoginMapper;
import com.sino.commens.login.domain.AdminInfo;
//import com.sino.commens.login.dao.AdminLoginMapper;
import com.sino.commens.login.service.AdminLoginService;
@Service("adminLoginService")
public class AdminLoginServiceImpl implements AdminLoginService{

	 @Autowired  
	 private AdminLoginMapper adminLoginMapper;

	@Override
	@Transactional
	public Map<String, String> adminLoginCheck(Map<String, String> map) {
		Map<String, String> retMap = new HashMap<>();
		adminLoginMapper.insert1();
		adminLoginMapper.insert2();
		
		//1、校验账号
		AdminInfo checkLogin = adminLoginMapper.getAdminLogin(map);
		if ("".equals(checkLogin) || null == checkLogin) {
			retMap.put("flag", "N");
			retMap.put("msg", "账号不正确，请输入正确账号重新登录！");
		}else {
			retMap.put("flag", "Y");
			retMap.put("msg", "登录成功");
//			retMap.put("powerCode", checkLogin.getPowerCode());
//			retMap.put("branchCode", checkLogin.getBranchCode());
//			retMap.put("adminName", checkLogin.getAdminName());
		}
		return retMap;
	}

}
