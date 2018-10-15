package cn.fengfan.personnel.dao;

import org.apache.ibatis.annotations.Param;
public interface AdministratorDao {
	
	int selectNoPassword(@Param("no") String no, @Param("password") String password);

	int selectNo(@Param("no") String no);
}
