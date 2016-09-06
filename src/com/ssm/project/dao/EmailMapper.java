package com.ssm.project.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssm.project.model.Email;
import com.ssm.project.model.EmailExample;

public interface EmailMapper {
    int countByExample(EmailExample example);

    int deleteByExample(EmailExample example);

    int deleteByPrimaryKey(String eId);

    int insert(Email record);

    int insertSelective(Email record);

    List<Email> selectByExampleWithBLOBs(EmailExample example);

    List<Email> selectByExample(EmailExample example);

    Email selectByPrimaryKey(String eId);

    int updateByExampleSelective(@Param("record") Email record, @Param("example") EmailExample example);

    int updateByExampleWithBLOBs(@Param("record") Email record, @Param("example") EmailExample example);

    int updateByExample(@Param("record") Email record, @Param("example") EmailExample example);

    int updateByPrimaryKeySelective(Email record);

    int updateByPrimaryKeyWithBLOBs(Email record);

    int updateByPrimaryKey(Email record);
}