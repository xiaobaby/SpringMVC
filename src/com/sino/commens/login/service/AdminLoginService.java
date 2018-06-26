package com.sino.commens.login.service;

import java.util.Map;


public interface AdminLoginService {

	/**
	 * 校验账号密码及登录
	 */
	public Map<String, String> adminLoginCheck(Map<String, String> map);

}
