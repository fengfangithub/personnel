package cn.fengfan.personnel.service.impl;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.fengfan.personnel.dao.EmployeeDao;
import cn.fengfan.personnel.pojo.Employee;
import cn.fengfan.personnel.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;
	@Autowired
	private HttpSession session;

	@Override
	public int login(String no, String password) {
		if (employeeDao.selectNoPassword(no, null) == 1) {
			if (employeeDao.selectNoPassword(no, password) == 1) {
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
	public int updatePassword(String oldPassword, String newPassword) {
		if (session.getAttribute("no") != null) {
			if (session.getAttribute("password").equals(oldPassword) && newPassword != oldPassword
					&& employeeDao.updatePassword(session.getAttribute("no").toString(), newPassword) == 1) {
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

	@Override
	public int register(Employee employee) {
		if (employeeDao.insert(employee) == 1) {
			return 1;
		}
		return 0;
	}

	@Override
	public int updateInfo(Employee employee) {
		if (session.getAttribute("no") != null) {
			employee.setNo(session.getAttribute("no").toString());
			if (employeeDao.update(employee) > 0) {
				return 1;
			}else {
				return 0;
			}
		}
		return 2;
	}

}
