package cn.fengfan.personnel.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.fengfan.personnel.pojo.Administrator;
import cn.fengfan.personnel.service.AdministratorService;

@Controller
public class AdministratorController {
	@Autowired
	private AdministratorService administratorService;

	@RequestMapping("/administrator/login")
	@ResponseBody
	public Map<String,Integer> login(String no, String password) {
		Map<String,Integer> code = new HashMap<String,Integer>();
		code.put("state", administratorService.login(no, password));
		return code;
	}

	@RequestMapping("/administrator/register")
	@ResponseBody
	public Map<String,Integer> register(Administrator administrator) {
		Map<String,Integer> code = new HashMap<String,Integer>();
		code.put("state", administratorService.register(administrator));
		return code;
	}
	@RequestMapping("/administrator/password")
	@ResponseBody
	public Map<String,Integer> updatePassword(String oldPassword,String newPassword){
		Map<String,Integer> code = new HashMap<String,Integer>();
		code.put("state", administratorService.updatePassword(newPassword, oldPassword));
		return code;
	}
}
