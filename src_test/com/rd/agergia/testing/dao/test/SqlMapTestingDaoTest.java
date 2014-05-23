package com.rd.agergia.testing.dao.test;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.rd.agergia.common.entity.Pager;
import com.rd.agergia.common.entity.PagerParam;
import com.rd.agergia.testing.dao.ibatis.SqlMapTestingDAO;
import com.rd.agergia.testing.entity.Testing;
@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations = { "classpath:spring/applicationContext.xml" })
public class SqlMapTestingDaoTest {
	@Resource
	private SqlMapTestingDAO sqlMapTestingDAO;

	@Test
	public void testInsert() {
		Testing t = new Testing();
		Date d=new Date();
		t.setName("测试模块今天111"+d);
		t.setStatus(false);
		sqlMapTestingDAO.saveTesting(t);

	}

	@Test
	public void getTesting() {
		System.out.println(sqlMapTestingDAO.find(new Testing(), 2));
	}

	@Test
	public void deleteTesting() {
		sqlMapTestingDAO.deleteTesting(new Testing(), 2);
	}
	@Test
	public void getPageing(){
		PagerParam pager=new PagerParam();
		pager.setPageOffset(0);
		pager.setPageSize(5);
		pager.setOrder("desc");
		pager.setSort("id");
		Pager<Testing> p=sqlMapTestingDAO.pageing(new Testing(), pager);
		for(Testing t:p.getData()){
			System.out.println(t);
			
		}
	}

}
