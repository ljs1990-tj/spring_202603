package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {
	
	@RequestMapping("/stu-list.do") 
	public String test(Model model) throws Exception{
		return "/student/stu-list";
	}
	
}
