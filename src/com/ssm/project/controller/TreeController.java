package com.ssm.project.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssm.project.model.TreeData;
import com.ssm.project.model.User;
import com.ssm.project.service.TreeService;
import com.ssm.project.util.gson.GsonUtils;

@Controller
@RequestMapping("/tree")
public class TreeController {

	@Autowired
	private TreeService treeService;

	
	@RequestMapping("/getTreeList.do")
	public void getTreeList(String id,HttpSession session,HttpServletResponse response) throws IOException{
		User user = (User) session.getAttribute("user");
		if(user != null){
			List<TreeData> treeDataList = null;
			if(StringUtils.isBlank(id)){
				id = "0";
				treeDataList=treeService.getTreeList(id);
			}else{
				treeDataList=treeService.getTreeList(id);
			}
			 response.getWriter().print(GsonUtils.objToJson(treeDataList));
		}else{
			response.getWriter().print("-1");
		}
	}
	
	/**
	 * easyUi默认添加样式
	 */
	@RequestMapping("/reloadthemes.do")
	public String test(String themes,HttpSession session){
		session.setAttribute("themesName", themes);
		return "/index";
	}
}
