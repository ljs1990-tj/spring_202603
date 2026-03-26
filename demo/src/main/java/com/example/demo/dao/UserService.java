package com.example.demo.dao;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;

@Service
public class UserService {
	
	@Autowired
	UserMapper userMapper;
	
	public HashMap<String, Object> login(HashMap<String, Object> map){
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		
		User user = userMapper.selectUser(map);
		if(user != null) {
//			ooo님 환영합니다!
			if(user.getPwd().equals(map.get("pwd"))) {
				resultMap.put("message", user.getUserName() + "님 환영합니다.");
			} else {
				resultMap.put("message", "비밀번호를 확인해주세요.");
			}
		} else {
			resultMap.put("message", "없는 아이디 입니다.");
		}
		resultMap.put("result", "success");
		
		
		return resultMap;
	}
	
	
}
