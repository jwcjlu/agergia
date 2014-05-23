package com.rd.agergia.testing.dao.ibatis;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rd.agergia.base.support.DaoSupport;
import com.rd.agergia.common.entity.Pager;
import com.rd.agergia.common.entity.PagerParam;
import com.rd.agergia.testing.dao.TestingDAO;
import com.rd.agergia.testing.entity.Testing;
@SuppressWarnings("rawtypes")
@Service
public class SqlMapTestingDAO extends DaoSupport implements TestingDAO{

	@SuppressWarnings("unchecked")
	@Override
	public void saveTesting(Testing t) {
		// TODO Auto-generated method stub
		super.save(t);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public Testing findTesting(Testing t, int id) {
		// TODO Auto-generated method stub
		return (Testing) super.find(t, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void deleteTesting(Testing t, int id) {
		// TODO Auto-generated method stub\
		super.delete(t.getClass(), id);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public void updateTesting(Testing t) {
		// TODO Auto-generated method stub
		super.update(t);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public Pager<Testing> pageing(Testing t, PagerParam pager) {
		// TODO Auto-generated method stub
		return super.getPageingData(t.getClass(), pager);
	}



}
