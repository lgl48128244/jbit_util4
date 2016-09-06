package com.ssm.project.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssm.project.model.User;
import com.ssm.project.model.UserExample;

public interface UserMapper {

	User login(User user);

	int countByExample(UserExample example);

	int deleteByExample(UserExample example);

	int deleteByPrimaryKey(String uId);

	int insert(User record);

	int insertSelective(User record);

	List<User> selectByExample(UserExample example);

	User selectByPrimaryKey(String uId);

	int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

	int updateByExample(@Param("record") User record, @Param("example") UserExample example);

	// 更新新的model中不为空的字段
	int updateByPrimaryKeySelective(User record);

	//将为空的字段在数据库中置为NULL
	int updateByPrimaryKey(User record);
}