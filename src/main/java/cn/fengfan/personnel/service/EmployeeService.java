package cn.fengfan.personnel.service;

import cn.fengfan.personnel.pojo.Employee;

public interface EmployeeService {
	int login(String no, String password);

	int updatePassword(String oldPassword, String newPassword);

	int register(Employee employee);

	int updateInfo(Employee employee);
	
	Employee queryPersonInfo();
}
