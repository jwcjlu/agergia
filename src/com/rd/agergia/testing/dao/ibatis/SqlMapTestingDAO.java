package com.rd.agergia.testing.dao.ibatis;

import org.springframework.stereotype.Service;

import com.rd.agergia.base.support.DaoSupport;
import com.rd.agergia.testing.dao.TestingDAO;
import com.rd.agergia.testing.entity.Testing;
@Service
public class SqlMapTestingDAO extends DaoSupport implements TestingDAO{


	@Override
	public void save(Testing t) {
		// TODO Auto-generated method stub
		super.save(t);
		
	}

	@Override
	public Testing find(Testing t,int id) {
		// TODO Auto-generated method stub
		return (Testing) super.find(t, id);
	
	}

}
