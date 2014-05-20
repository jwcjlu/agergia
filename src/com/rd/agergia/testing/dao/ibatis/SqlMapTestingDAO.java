package com.rd.agergia.testing.dao.ibatis;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.rd.agergia.testing.dao.TestingDAO;
import com.rd.agergia.testing.entity.Testing;

@SuppressWarnings("deprecation")
public class SqlMapTestingDAO extends SqlMapClientDaoSupport implements TestingDAO{
	private static final String SAVE_TESTING="insertTesting";
	private static final String GET_TESTING="getTesting";

	@Override
	public void save(Testing t) {
		// TODO Auto-generated method stub
		getSqlMapClientTemplate().insert(SAVE_TESTING, t);
		
	}

	@Override
	public Testing find(int id) {
		// TODO Auto-generated method stub
		return (Testing) getSqlMapClientTemplate().queryForObject(GET_TESTING,id);
	}

}
