package com.ssm.project.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.ssm.project.dao.VacationMapper;
import com.ssm.project.model.Vacation;
import com.ssm.project.model.VacationExample;
import com.ssm.project.util.BaseServices;

@Service
public class VacationService extends BaseServices {
	@Autowired
	private VacationMapper vacationMapper;

	/**
	 * list
	 */
	public Map<String,Object> findVacationAll(Integer pageNum, Integer pageSize) {
		logger.info("假期信息");
		PageHelper.startPage(pageNum, pageSize);
		VacationExample example = new VacationExample();
		example.createCriteria().andVIdIsNotNull();
		List<Vacation> list = vacationMapper.selectByExample(example);
		int total = vacationMapper.countByExample(example);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("rows", list);
		map.put("total", total);
		return map;
	}

	/**
	 * list
	 */
	public List<Vacation> findAll() {
		logger.info("假期信息");
		VacationExample example = new VacationExample();
		example.createCriteria().andVIdIsNotNull();
		return vacationMapper.selectByExample(example);
	}

	/**
	 * add
	 */
	public boolean save(Vacation vacation) {
		logger.info("保存假期信息");
		int count = vacationMapper.insert(vacation);
		if (count > 0) {
			return true;
		}
		return false;
	}

	/**
	 * detail
	 */
	public Vacation findDetail(String vId) {
		logger.info("获取申请信息");
		return vacationMapper.selectByPrimaryKey(vId);
	}

	/**
	 * audit
	 */
	public int update(Vacation vacation) {
		logger.info("是否审核");
		return vacationMapper.updateByPrimaryKeySelective(vacation);
	}

	/**
	 * delete
	 */
	public boolean delete(String id) {
		logger.info("取消或删除申请");
		int count = vacationMapper.deleteByPrimaryKey(id);
		if (count > 0) {
			return true;
		}
		return false;
	}
	
	/**
	 * findById
	 */
	public Vacation findById(String id){
		return vacationMapper.selectByPrimaryKey(id);
	}
	
	/**
	 * nextPage
	 */
	public int searchRecordsNextPage(Integer pageSize) {
		VacationExample example = new VacationExample();
		example.createCriteria().andVIdIsNotNull();
		int total = vacationMapper.countByExample(example);
		int pageNo = total / pageSize;
		if (total % pageSize > 0) {
			pageNo++;
		}
		return pageNo;
	}
}