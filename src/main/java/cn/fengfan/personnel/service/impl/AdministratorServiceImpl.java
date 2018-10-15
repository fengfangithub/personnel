package cn.fengfan.personnel.service.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.fengfan.personnel.dao.AdministratorDao;
import cn.fengfan.personnel.service.AdministratorService;

@Service
public class AdministratorServiceImpl implements AdministratorService {

	@Autowired
	private AdministratorDao administratorDao;
	@Autowired
	private HttpServletRequest request;

	@Override
	public int login(String no, String password) {
		System.out.println(request.getSession(true).getId());
		if (administratorDao.selectNo(no) == 1) {
			if (administratorDao.selectNoPassword(no, password) == 1) {
				return 1;
			} else {
				return 2;
			}
		}
		return 0;
	}

}
