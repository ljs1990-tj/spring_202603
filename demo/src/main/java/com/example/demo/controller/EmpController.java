package com.example.demo.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dao.EmpService;
import com.google.gson.Gson;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class EmpController {
	
	@Autowired
	EmpService empService;
	
	// 웹브라우저로 접속하는 주소, return은 jsp파일
	@RequestMapping("/emp/list.do") 
	public String copy(HttpServletRequest request, Model model, @RequestParam HashMap<String, Object> map) throws Exception{
		return "/emp/emp-list";
	}
	
	// ajax가 호출하는 주소
	@RequestMapping(value = "/emp/list.dox", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String copy(Model model, @RequestParam HashMap<String, Object> map) throws Exception {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		int pageSize = Integer.parseInt((String) map.get("pageSize"));
		int offSet = Integer.parseInt((String) map.get("offSet"));
		map.put("pageSize", pageSize);
		map.put("offSet", offSet);
		
		resultMap = empService.getEmpList(map);
		
		return new Gson().toJson(resultMap); 
	}
}
