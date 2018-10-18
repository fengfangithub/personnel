package cn.fengfan.personnel.service;

import cn.fengfan.personnel.pojo.Administrator;

public interface AdministratorService {
	int login(String no, String password);

	int register(Administrator administrator);

	int updatePassword(String no, String password);
}
