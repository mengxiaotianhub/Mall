package com.mengxiaotian.learn.mall.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.mengxiaotian.learn.mall.meta.Manager;

public interface ManagerMapper {
	@Select("SELECT * FROM Manager")
	public List<Manager> getAllManager();

	@Select("SELECT * FROM Manager WHERE managerName=#{managerName} AND password=#{password}")
	public Manager login(@Param("managerName") String managerName, @Param("password") int password);

	@Insert("INSERT INTO Manager SET managerName=#{managerName},password=#{password}")
	public void addManager(Manager manager);
	
	@Select("SELECT * FROM Manager WHERE managerName=#{managerName}")
	public Manager getManager(String managerName);

}
