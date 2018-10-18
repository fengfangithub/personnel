package cn.fengfan.personnel.dao;

import org.apache.ibatis.annotations.Param;

import cn.fengfan.personnel.pojo.Employee;

public interface EmployeeDao {
	int selectNoPassword(@Param("no") String no, @Param("password") String password);
	
	int updatePassword(@Param("no") String no, @Param("password") String password);

	int insert(Employee employee);

	int update(Employee employee);
}
