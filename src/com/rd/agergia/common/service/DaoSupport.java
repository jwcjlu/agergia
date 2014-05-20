package com.rd.agergia.common.service;

import java.util.LinkedHashMap;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.rd.agergia.base.BaseDao;
import com.rd.agergia.common.entity.QueryResult;

@SuppressWarnings("rawtypes")
public abstract class DaoSupport extends SqlMapClientDaoSupport implements BaseDao{

	@Override
	public void save(Object entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object find(Class entityClass, Object entityId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Object entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Class entityClass, Object entityId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Class entityClass, Object[] entityIds) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public QueryResult getPageingData(Class entityClass, int firstIndex,
			int resultMax, String wheresql, Object[] params,
			LinkedHashMap orderby) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QueryResult getPageingData(Class entityClass, int firstIndex,
			int resultMax, String wheresql, Object[] params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QueryResult getPageingData(Class entityClass, int firstIndex,
			int resultMax, LinkedHashMap orderby) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QueryResult getPageingData(Class entityClass, int firstIndex,
			int resultMax) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QueryResult getPageingData(Class entityClass) {
		// TODO Auto-generated method stub
		return null;
	}

}
