package cn.fengfan.personnel.controller;

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
	public int login(String no,String password) {
		System.out.println("ff");
		return administratorService.login(no, password);
	}
}
