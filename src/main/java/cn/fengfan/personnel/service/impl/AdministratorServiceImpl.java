package cn.fengfan.personnel.service.impl;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.fengfan.personnel.dao.AdministratorDao;
import cn.fengfan.personnel.pojo.Administrator;
import cn.fengfan.personnel.service.AdministratorService;

@Service
public class AdministratorServiceImpl implements AdministratorService {
	@Autowired
	private AdministratorDao administratorDao;
	@Autowired
	private HttpSession session;

	@Override
	public int login(String no, String password) {
		if (administratorDao.select(no, null) == 1) {
			if (administratorDao.select(no, password) == 1) {
				session.setAttribute("no", no);
				session.setAttribute("password", password);
				return 1;
			} else {
				return 0;
			}
		}
		return 2;
	}

	@Override
	public int register(Administrator administrator) {
		if (administratorDao.insert(administrator) == 1) {
			return 1;
		}
		return 0;
	}

	@Override
	public int updatePassword(String newPassword, String oldPassword) {
		if (session.getAttribute("no") != null) {
			if (session.getAttribute("password").equals(oldPassword) && newPassword != oldPassword
					&& administratorDao.updatePassword(session.getAttribute("no").toString(), newPassword) == 1) {
				session.removeAttribute("no");
				session.removeAttribute("password");
				return 1;
			} else if (!session.getAttribute("password").equals(oldPassword)) {
				return 2;
			} else if (newPassword == oldPassword) {
				return 3;
			} else {
				return 0;
			}
		}
		return 4;
	}

}
