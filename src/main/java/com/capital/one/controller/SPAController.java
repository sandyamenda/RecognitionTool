package com.capital.one.controller;


import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("page")
public class SPAController {
	
	@RequestMapping
	public String getSPA() {
		return "forward:/static/index.html";
	}
	
}