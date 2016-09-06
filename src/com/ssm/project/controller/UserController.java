package com.ssm.project.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ssm.project.model.User;
import com.ssm.project.service.UserService;


@Controller
@RequestMapping(value = "/user")
public class UserController {
	@Autowired
	private UserService userService;

	/**
	 * login
	 * @param UId
	 * @param upassword
	 * @param request
	 * @param response
	 * @throws IOException
	 */
/*	@RequestMapping(value = "/login.do")
	public String login(String uName, String uPwd, String code, HttpServletRequest request) {
		String sessionCode = (String) request.getSession().getAttribute("code");
		User user = userService.getLogin(uName, uPwd);
		if (!code.equalsIgnoreCase(sessionCode)) {
			request.setAttribute("message", "验证码错误！");
			return "/login";
		} else if (user != null) {
			request.getSession().setAttribute("user", user);
			request.setAttribute("message", "登录成功！");
			//页面跳转至欢迎界面(系统首页面)
			return "/index";
		} else {
			//跳转至登录界面
			request.setAttribute("message", "登录失败,用户名或密码错误！");
			return "/login";
		}
	}
*/

	
	@RequestMapping(value = "/login.do")
	public String login(String uName, String uPwd, HttpServletRequest request) {
		User user = userService.getLogin(uName, uPwd);
		if (user != null) {
			request.getSession().setAttribute("user", user);
			//页面跳转至欢迎界面(系统首页面)
			return "/index";
		} else {
			//跳转至登录界面
			request.setAttribute("message", "用户名或密码错误！");
			return "/login";
		}
	}

	/**
	 * 注销
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/logout.do")
	public String logout(HttpServletRequest request) {
		String param = request.getParameter("type");
		request.getSession().invalidate();
		if(Integer.valueOf(param)==1){
			request.setAttribute("message", "修改密码成功，请重新登录！");
		}else{
			request.setAttribute("message", "注销成功！");
		}
		return "/login";
	}
	
	
	/**
	 * userinfo
	 */
	@RequestMapping("/info.do")
	public String info(HttpServletRequest request,String uId) {
		User user = userService.findById(uId);
		request.setAttribute("user", user);
		return "/jsp/user/user_editor";
	}

	/**
	 * succ
	 */
	@RequestMapping("/succ.do")
	public String succ(HttpServletRequest request,@RequestParam String uId) {
		User user = userService.findById(uId);
		request.getSession().setAttribute("user", user);
		return "/jsp/user/user";
	}
	/**
	 * edit
	 * @return
	 * @throws IOException 
	 * @throws ServletException 
	 */
	@RequestMapping(value = "/edit.do", method = RequestMethod.POST)
	public String edit(User user, HttpServletRequest request,RedirectAttributes attr) {
		int count = userService.update(user);
		if (count > 0) {
			attr.addAttribute("uId", user.getuId()).addFlashAttribute("message", "修改成功");
			return "redirect:/user/succ.do";
		} else {
			request.setAttribute("message", "修改失败");
			return "/jsp/user/user";
		}
	}

	/**
	 * list
	 */
	@RequestMapping(value = "/list.do")
	@ResponseBody
	public Map<String,Object> list(Integer page,Integer rows) {
		Map<String,Object> map = userService.findAccountAll(page, rows);
		return map;
	}

	/**
	 * add
	 */
	@RequestMapping("/add.do")
	@ResponseBody
	public Map<String,Object> add(User user) {
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			if (userService.save(user)) {
				map.put("message", "添加成功");
			} 
		} catch (Exception e) {
			map.put("message", "添加失败");
		}
		return map;
	}

	/**
	 * checkName
	 * @throws IOException 
	 */
	@RequestMapping("/checkName.do")
	public void checkName(@RequestParam String uname, HttpServletResponse response) throws IOException {
		//去数据库进行唯一验证
		List<User> users = userService.searchCheckUnameOnly(uname);
		if (users.size() > 0) {
			response.getWriter().print("false");
		} else {
			response.getWriter().print("true");
		}
	}

	/**
	 * update
	 * @throws IOException 
	 */
	@RequestMapping("/updatePwd.do")
	@ResponseBody
	public Map<String,Object> update(String uId, String uPwd) {
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			if (userService.update(uPwd, uId)) {
				map.put("message", "密码修改成功，请重新登录！");
			}
		} catch (Exception e) {
			map.put("message", "密码修改失败");
		}
		return map;
	}

	/**
	 * delete
	 */
	@RequestMapping("/userdelete.do")
	@ResponseBody
	public Map<String,Object> delete(@RequestParam String id) {
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			if (userService.delete(id)) {
				map.put("message", "删除成功");
			} 
		} catch (Exception e) {
			map.put("message", "删除失败");
		}
		return map;
	}
}
