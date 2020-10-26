package com.example.springboot.Controller.base.service;

import com.example.springboot.Controller.base.dao.BaseDao;
import org.springframework.transaction.annotation.Transactional;

public abstract class BaseServiceImpl{
	
	public abstract BaseDao getDao();
	
	@Transactional(rollbackFor = Exception.class)
	public <T> int deleteByPrimaryKey(Object id) {
		return getDao().deleteByPrimaryKey(id);
	}
	@Transactional(rollbackFor = Exception.class)
	public <T> int insert(T t) {
		return getDao().insert(t);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public <T> int insertSelective(T t) {
		return getDao().insertSelective(t);
	}
	
	public <T> T selectByPrimaryKey(Object id) {
		return getDao().selectByPrimaryKey(id);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public <T> int updateByPrimaryKey(T t) {
		return getDao().updateByPrimaryKey(t);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public <T> int updateByPrimaryKeySelective(T t) {
		return getDao().updateByPrimaryKeySelective(t);
	}


}
