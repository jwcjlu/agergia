package com.rd.agergia.testing.dao;

import com.rd.agergia.testing.entity.Testing;

public interface TestingDAO {
	public void save(Testing t);

	public Testing find(int id);

}