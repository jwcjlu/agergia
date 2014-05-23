package com.rd.agergia.testing.dao;

import com.rd.agergia.common.entity.Pager;
import com.rd.agergia.common.entity.PagerParam;
import com.rd.agergia.testing.entity.Testing;

public interface TestingDAO {
	public void saveTesting(Testing t);
	public Testing findTesting(Testing t,int id);
	public void deleteTesting(Testing t,int id);
	public void updateTesting(Testing t);
	public Pager<Testing>pageing(Testing t,PagerParam pager);

}
