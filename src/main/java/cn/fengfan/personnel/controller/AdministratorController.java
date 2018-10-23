package cn.fengfan.personnel.controller;

import org.json.JSONObject;
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
	public String login(String no, String password) {
		JSONObject code = new JSONObject();
		code.put("state", administratorService.login(no, password));
		return code.toString();
	}

	@RequestMapping("/administrator/register")
	@ResponseBody
	public String register(Administrator administrator) {
		JSONObject code = new JSONObject();
		code.put("state", administratorService.register(administrator));
		return code.toString();
	}

	@RequestMapping("/administrator/password")
	@ResponseBody
	public String updatePassword(String oldPassword, String newPassword) {
		JSONObject code = new JSONObject();
		code.put("state", administratorService.updatePassword(newPassword, oldPassword));
		return code.toString();
	}
}
