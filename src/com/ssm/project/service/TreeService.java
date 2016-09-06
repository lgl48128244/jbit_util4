package com.ssm.project.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.project.dao.TreeMapper;
import com.ssm.project.model.Tree;
import com.ssm.project.model.TreeAttributes;
import com.ssm.project.model.TreeData;
import com.ssm.project.model.TreeExample;
import com.ssm.project.util.BaseServices;

@Service
public class TreeService extends BaseServices{

	@Autowired
	private TreeMapper treeMapper;
	
	public List<TreeData> getTreeList(String id){
		logger.info("获取菜单树");
		TreeExample example = new TreeExample();
		example.createCriteria().andPidEqualTo(id);
		List<Tree> treeList = treeMapper.selectByExample(example);
		List<TreeData> list = new ArrayList<TreeData>();
		for (Tree tree : treeList) {
			TreeData node = new TreeData();
			node.setId(tree.getId());
			node.setText(tree.getName());
			TreeAttributes attr = new TreeAttributes();
			attr.setUrl(tree.getUrl());
			node.setAttributes(attr);
			node.setState(id=="0"?"closed":"open");
			list.add(node);
		}
		return list;
	}
}
