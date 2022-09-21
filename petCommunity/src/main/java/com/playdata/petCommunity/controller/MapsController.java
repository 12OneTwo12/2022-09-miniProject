package com.playdata.petCommunity.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.playdata.petCommunity.command.UserVO;

@Controller
@RequestMapping("/maps")
public class MapsController {

	@RequestMapping("map")
	public String map(@Valid UserVO vo) {
		
		return"/maps/map";
	}
	
}
