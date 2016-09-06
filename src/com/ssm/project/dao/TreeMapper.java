package com.ssm.project.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssm.project.model.Tree;
import com.ssm.project.model.TreeExample;

public interface TreeMapper {
    int countByExample(TreeExample example);

    int deleteByExample(TreeExample example);

    int deleteByPrimaryKey(String id);

    int insert(Tree record);

    int insertSelective(Tree record);

    List<Tree> selectByExample(TreeExample example);

    Tree selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Tree record, @Param("example") TreeExample example);

    int updateByExample(@Param("record") Tree record, @Param("example") TreeExample example);

    int updateByPrimaryKeySelective(Tree record);

    int updateByPrimaryKey(Tree record);
}