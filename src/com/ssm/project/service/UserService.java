package com.ssm.project.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.ssm.project.dao.UserMapper;
import com.ssm.project.model.User;
import com.ssm.project.model.UserExample;
import com.ssm.project.util.BaseServices;

@Service
public class UserService extends BaseServices {
	@Autowired
	private UserMapper userMapper;
	
	/**
	 * 登录
	 * @param upk
	 * @param pwd
	 * @return
	 */
	public User getLogin(String uname, String pwd) {
		logger.info("用户登录");
		User user = new User();
		user.setuName(uname);
		user.setuPwd(pwd);
		return userMapper.login(user);
	}
	/**
	 * 查找个人信息
	 */
	public User findById(String uId){
		logger.info("查找个人信息");
		return userMapper.selectByPrimaryKey(uId);
		
	}
	/**
	 * 修改
	 */
	public int update(User user) {
		logger.info("修改用户");
		return  userMapper.updateByPrimaryKeySelective(user);
	}

	/**
	 * list
	 */
	public Map<String,Object> findAccountAll(Integer page,Integer rows) {
		logger.info("用户列表信息");
		PageHelper.startPage(page, rows);
		UserExample example = new UserExample();
		example.createCriteria().andUIdIsNotNull();
		Map<String,Object> map = new HashMap<String,Object>();
		List<User> list = userMapper.selectByExample(example);
		int total = userMapper.countByExample(example);
		map.put("rows", list);
		map.put("total", total);
		return map;
	}
	
	public List<User> findByName(String uName){
		UserExample example = new UserExample();
		example.createCriteria().andUNameNotEqualTo(uName);
		return userMapper.selectByExample(example);
	}

	/**
	 * add
	 */
	public boolean save(User user) {
		logger.info("添加用户");
		UserExample example = new UserExample();
		example.createCriteria().andUNameEqualTo(user.getuName());
		List<User> users = userMapper.selectByExample(example);
		if (users.size() > 0) {
			return false;
		} else {
			userMapper.insert(user);
			return true;
		}
	}

	/**
	 * delete
	 */
	public boolean delete(String id) {
		logger.info("删除用户");
		int count = userMapper.deleteByPrimaryKey(id);
		if (count > 0) {
			return true;
		}
		return false;
	}

	/**
	 * updatepwd
	 */
	public boolean update(String pwd, String uId) {
		logger.info("修改密码");
		UserExample example = new UserExample();
		example.createCriteria().andUIdEqualTo(uId);
		User user = new User();
		user.setuPwd(pwd);
		user.setuId(uId);
		int count = userMapper.updateByExampleSelective(user, example);
		if (count > 0) {
			return true;
		}
		return false;
	}

	/**
	 * checkName
	 * @param uname
	 * @return
	 */
	public List<User> searchCheckUnameOnly(String uname) {
		// TODO Auto-generated method stub
		logger.info("验证用户名唯一");
		UserExample example = new UserExample();
		example.createCriteria().andUNameEqualTo(uname);
		return  userMapper.selectByExample(example);
	}
}
