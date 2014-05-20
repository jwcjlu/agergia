package com.rd.agergia.testing.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rd.agergia.testing.dao.TestingDAO;
import com.rd.agergia.testing.entity.Testing;

public class TestApp {
	ApplicationContext ac=new ClassPathXmlApplicationContext("classpath:/spring/applicationContext.xml");
	TestingDAO testingDAO=(TestingDAO) ac.getBean("testingDAO");
	@Test
	public void testInsert(){
		Testing t=new Testing();
		t.setName("����ģ������22");
		t.setStatus(false);
		testingDAO.save(t);
		
	}
	@Test
	public void getTesting(){
	System.out.println(testingDAO.find(2));
	}

}