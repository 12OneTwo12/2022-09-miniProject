package com.playdata.petCommunity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
	@RequestMapping("/user_login")
	public String login() {
		return"user/user_login";
	}
	@RequestMapping("/user_signin")
	public String signin() {
		return"user/user_signin";
	}
}
