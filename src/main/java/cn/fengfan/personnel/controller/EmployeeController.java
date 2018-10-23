package cn.fengfan.personnel.controller;

import org.json.JSONObject;
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
	public String login(String no, String password) {
		JSONObject code = new JSONObject();
		code.put("state", employeeService.login(no, password));
		return code.toString();
	}

	@RequestMapping("/employee/password")
	@ResponseBody
	public String updatePassword(String oldPassword, String newPassword) {
		JSONObject code = new JSONObject();
		code.put("state", employeeService.updatePassword(oldPassword, newPassword));
		return code.toString();
	}

	@RequestMapping("/employee/register")
	@ResponseBody
	public String register(Employee employee) {
		JSONObject code = new JSONObject();
		/*
		 * Employee e = new Employee(); e.setNo("123123"); e.setName("fff");
		 * e.setPassword("111"); e.setBirth("2015-12-04"); e.setPhone("111555");
		 * e.setMobile("1456156"); e.setCard("65165165"); e.setAddress("effff");
		 * e.setImage("efef"); e.setHiredate("2000-01-1");
		 */
		code.put("state", employeeService.register(employee));
		return code.toString();
	}

	@RequestMapping("/employee/updateInfo")
	@ResponseBody
	public String updateInfo(Employee employee) {
		JSONObject code = new JSONObject();
		Employee e = new Employee();
		e.setName("eee");
		code.put("state", employeeService.updateInfo(e));
		return code.toString();
	}

	@RequestMapping("/employee/queryPersonInfo")
	@ResponseBody
	public String queryPersonInfo() {
		JSONObject code = new JSONObject();
		if (employeeService.queryPersonInfo() != null) {
			code.put("state", 1);
			code.put("resutlt", new JSONObject(employeeService.queryPersonInfo()));
		} else {
			code.put("state", 0);
			code.put("result", "");
		}
		System.out.println(code);
		return code.toString();
	}
}
