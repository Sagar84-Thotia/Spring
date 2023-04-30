package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RedirectController 
{
	@RequestMapping("/one")
	public String one()
	{
		System.out.println("This is one handler");	
		return "redirect:/enjoy"; //relative path
	}
	
	@RequestMapping("/enjoy")
	public String two()
	{
		System.out.println("This is second handler[enjoy]");
		return "contact";
	}
	
}
