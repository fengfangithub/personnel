package cn.fengfan.personnel.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.fengfan.personnel.pojo.Employee;
import cn.fengfan.personnel.service.EmployeeService;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	@RequestMapping("/employee/login")
	@ResponseBody
	public Map<String, Integer> login(String no, String password) {
		Map<String, Integer> code = new HashMap<String, Integer>();
		code.put("state", employeeService.login(no, password));
		return code;
	}

	@RequestMapping("/employee/password")
	@ResponseBody
	public Map<String, Integer> updatePassword(String oldPassword, String newPassword) {
		Map<String, Integer> code = new HashMap<String, Integer>();
		code.put("state", employeeService.updatePassword(oldPassword, newPassword));
		return code;
	}

	@RequestMapping("/employee/register")
	@ResponseBody
	public Map<String, Integer> register(Employee employee) {
		Map<String, Integer> code = new HashMap<String, Integer>();
		/*
		 * Employee e = new Employee(); e.setNo("123123"); e.setName("fff");
		 * e.setPassword("111"); e.setBirth("2015-12-04"); e.setPhone("111555");
		 * e.setMobile("1456156"); e.setCard("65165165"); e.setAddress("effff");
		 * e.setImage("efef"); e.setHiredate("2000-01-1");
		 */
		code.put("state", employeeService.register(employee));
		return code;
	}

	@RequestMapping("/employee/updateInfo")
	@ResponseBody
	public Map<String, Integer> updateInfo(Employee employee) {
		Map<String, Integer> code = new HashMap<String, Integer>();
		Employee e = new Employee();
		e.setName("eee");
		code.put("state", employeeService.updateInfo(e));
		return code;
	}
}
