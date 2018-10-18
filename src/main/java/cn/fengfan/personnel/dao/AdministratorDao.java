package cn.fengfan.personnel.dao;

import org.apache.ibatis.annotations.Param;

import cn.fengfan.personnel.pojo.Administrator;

public interface AdministratorDao {

	int select(@Param("no") String no, @Param("password") String password);

	int insert(Administrator administrator);

	int updatePassword(@Param("no") String no, @Param("password") String password);
}
