package com.mengxiaotian.learn.mall.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.mengxiaotian.learn.mall.meta.User;

public interface UserMapper {

	@Select("SELECT * FROM User")
	public List<User> getAllUser();

	@Select("SELECT * FROM User WHERE userName=#{userName} AND password=#{password}")
	public User login(@Param("userName") String userName, @Param("password") int password);

	@Select("SELECT point FROM User WHERE id=#{id}")
	public int getPoint(int id);
	
	@Update("UPDATE User SET point=#{point}")
	public void updatePoint(int point);
	
	@Select("SELECT userName FROM User WHERE id=#{id}")
	public String getUserName(int id);

	@Insert("INSERT INTO User SET userName=#{userName},password=#{password},point=#{point}")
	public void addUser(User user);

}
