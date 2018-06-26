package com.sino.commens.login.dao;

import java.util.Map;

import com.sino.commens.login.domain.AdminInfo;

public interface AdminLoginMapper {
	//判断登录
	AdminInfo getAdminLogin(Map<String, String> map);
	void insert1();
	void insert2();
}	

