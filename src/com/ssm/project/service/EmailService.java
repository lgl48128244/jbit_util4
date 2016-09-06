package com.ssm.project.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.ssm.project.dao.EmailMapper;
import com.ssm.project.dao.UserMapper;
import com.ssm.project.model.Email;
import com.ssm.project.model.EmailExample;
import com.ssm.project.model.User;
import com.ssm.project.model.UserExample;
import com.ssm.project.util.BaseServices;
@Service
public class EmailService extends BaseServices {
	@Autowired
	private EmailMapper emailMapper;
	@Autowired
	private UserMapper userMapper;
	
	/**
	 * write
	 */
	public List<User> saveWrite() {
		logger.info("写邮件");
		UserExample example = new UserExample();
		example.createCriteria().andUNameIsNotNull();
		return userMapper.selectByExample(example);
	}

	/**
	 * save
	 */
	public int save(Email email) {
		logger.info("保存发件信息");
		return emailMapper.insert(email);
	}

	/**
	 * receive
	 */
	public Map<String,Object> findReceive(Integer pageNum, Integer pageSize, String eReceive) {
		logger.info("收件箱");
		PageHelper.startPage(pageNum, pageSize);
		EmailExample example = new EmailExample();
		example.createCriteria().andEIdIsNotNull().andEIsdelEqualTo(0).andEReceiveEqualTo(eReceive);
		List<Email> list = emailMapper.selectByExampleWithBLOBs(example);
		int total = emailMapper.countByExample(example);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("rows", list);
		map.put("total", total);
		return map;
	}
	
	/**
	 * recycle
	 */
	public Map<String,Object> findRecycle(Integer pageNum, Integer pageSize, String eReceive) {
		logger.info("回收站");
		PageHelper.startPage(pageNum, pageSize);
		EmailExample example = new EmailExample();
		example.createCriteria().andEIdIsNotNull().andEIsdelEqualTo(1).andEReceiveEqualTo(eReceive);
		List<Email> list = emailMapper.selectByExampleWithBLOBs(example);
		int total = emailMapper.countByExample(example);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("rows", list);
		map.put("total", total);
		return map;
	}
	
	/**
	 * reduction
	 */
	public boolean updateReduction(String id) {
		logger.info("还原");
		Email email = emailMapper.selectByPrimaryKey(id);
		email.seteIsdel(0);
		int count = emailMapper.updateByPrimaryKey(email);
		if (count > 0) {
			return true;
		}
		return false;
	}

	/**
	 * deleteVirtual
	 */
	public boolean deleteVirtual(String id) {
		logger.info("逻辑删除");
		Email email = findDetail(id);
		email.seteIsread(1);
		email.seteIsdel(1);
		int count = emailMapper.updateByPrimaryKey(email);
		if (count > 0) {
			return true;
		}
		return false;
	}

	/**
	 * delete
	 */
	public boolean delete(String id) {
		logger.info("物理删除");
		int count = emailMapper.deleteByPrimaryKey(id);
		if (count > 0) {
			return true;
		}
		return false;
	}

	/**
	 * detail
	 */
	public Email findDetail(String id) {
		logger.info("邮件详情");
		return emailMapper.selectByPrimaryKey(id);
	}

	/**
	 * update
	 */
	public boolean update(String id) {
		logger.info("已读邮件");
		Email email = findDetail(id);
		email.seteIsread(1);
		int count = emailMapper.updateByPrimaryKey(email);
		if (count > 0) {
			return true;
		}
		return false;
	}
}
