package com.ssm.project.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssm.project.model.User;
import com.ssm.project.model.Vacation;
import com.ssm.project.service.UserService;
import com.ssm.project.service.VacationService;

@Controller
@RequestMapping("/vacation")
public class VacationController {
	@Autowired
	private VacationService vacationService;
	@Autowired
	private UserService userService;
	
	/**
	 * 假期列表
	 */
	@RequestMapping("/list.do")
	@ResponseBody
	public Map<String,Object> list(Integer page,Integer rows) {
		Map<String,Object> map = vacationService.findVacationAll(page, rows);
		return map;
	}

	/**
	 * 获取审核人（不能有自己）
	 * @return
	 */
	@RequestMapping("/app_vacation")
	@ResponseBody
	public List<User> test(String uName){
		List<User> list = userService.findByName(uName);
		return list;
	}
	

	/**
	 * 申请休假
	 */
	@RequestMapping("/add.do")
	@ResponseBody
	public Map<String,Object> add(Vacation vacation) {
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			if (vacationService.save(vacation)) {
				map.put("message", "操作成功");
			}
		} catch (Exception e) {
			map.put("message", "操作失败");
		}
		return map;
	}
	
	/**
	 * 重新申请
	 */
	@RequestMapping("/apply.do")
	public String apply(String vId) {
		vacationService.delete(vId);
		return "/jsp/vacation/vacation_apply";
	}

	/**
	 * 审核前准备
	 */
	@RequestMapping("/detail.do")
	public String detail(String vId, HttpServletRequest request) {
		Vacation vacation = vacationService.findDetail(vId);
		request.setAttribute("vacation", vacation);
		return "/jsp/vacation/vacation_audit";
	}

	/**
	 * 是否审核
	 */
	@RequestMapping("/audit.do")
	@ResponseBody
	public Map<String,Object> audit(Vacation vacation) {
		Map<String,Object> map = new HashMap<String,Object>();
		int state = vacation.getvState();
		int count =0;
		if (1 == state) {
			count = vacationService.update(vacation);
			if(count>0){
				map.put("message", "审核通过");
			}
		}else if (3 == state){
			count = vacationService.update(vacation);
			if(count>0){
				map.put("message", "审核未通过");
			}
		}
		return map;
	}

	/**
	 * 删除申请
	 */
	@RequestMapping("/delete.do")
	@ResponseBody
	public Map<String,Object> delete(String vId) {
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			 if (vacationService.delete(vId)){
				 map.put("message", "删除成功！");
			 }
		} catch (Exception e) {
			map.put("message", "删除失败！");
		}
		return map;
	}
	
	/**
	 * 取消审核
	 */
	@RequestMapping("/cancel.do")
	@ResponseBody
	public Map<String,Object> cancel(String vId, String vState) {
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			Vacation vacation = vacationService.findById(vId);
			vacation.setvState(4);
			vacationService.update(vacation);
			map.put("message", "取消成功！");
		} catch (Exception e) {
			map.put("message", "取消失败！");
		}
		return map;
	}
}
