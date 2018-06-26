package com.sino.commens.login.adminFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AdminLoginInterceptor extends HandlerInterceptorAdapter{

	 public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		 System.out.println("=====================admin=============================");
		String adminId = "";
		HttpSession session = request.getSession();
		adminId = (String) session.getAttribute("adminId");
		
		if (StringUtils.isEmpty(adminId) || "".equals(adminId)) {
			String backUrl = request.getRequestURI();
			String path = request.getContextPath();
			backUrl = backUrl.replaceAll(path, "");
			response.sendRedirect(path+"/home.do");
			//request.getRequestDispatcher("/toAdminLogin.do").forward(request, response);
			return false;
		} else {
			return true;
		}
	}

	    public void postHandle(
	            HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
	            throws Exception {
	    }

	    public void afterCompletion(
	            HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
	            throws Exception {
	    }
}
