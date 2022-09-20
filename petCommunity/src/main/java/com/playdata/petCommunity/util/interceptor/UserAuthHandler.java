package com.playdata.petCommunity.util.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

public class UserAuthHandler implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception{
		
		HttpSession session = request.getSession();
		String userId = (String)session.getAttribute("userId");
		String doctorId = (String)session.getAttribute("doctorId");
		
		if(userId != null || doctorId != null) {
			return true; // 컨트롤러를 실행함
		} else {
			response.sendRedirect("/user/login"); //로그인화면으로 
			return false; // 컨트롤러를 실행하지 않음
		}
	}



}
