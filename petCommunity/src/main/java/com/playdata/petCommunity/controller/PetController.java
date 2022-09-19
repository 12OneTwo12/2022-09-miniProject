package com.playdata.petCommunity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pet")
public class PetController {
@RequestMapping("pet_signup")
public String pet_signup() {
	return"pet/pet_signup";
}
}
