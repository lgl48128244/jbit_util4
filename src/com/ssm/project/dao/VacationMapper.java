package com.ssm.project.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssm.project.model.Vacation;
import com.ssm.project.model.VacationExample;

public interface VacationMapper {
    int countByExample(VacationExample example);

    int deleteByExample(VacationExample example);

    int deleteByPrimaryKey(String vId);

    int insert(Vacation record);

    int insertSelective(Vacation record);

    List<Vacation> selectByExample(VacationExample example);

    Vacation selectByPrimaryKey(String vId);

    int updateByExampleSelective(@Param("record") Vacation record, @Param("example") VacationExample example);

    int updateByExample(@Param("record") Vacation record, @Param("example") VacationExample example);

    int updateByPrimaryKeySelective(Vacation record);

    int updateByPrimaryKey(Vacation record);
}