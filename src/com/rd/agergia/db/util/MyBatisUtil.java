package com.rd.agergia.db.util;

import javax.annotation.Resource;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;

public class MyBatisUtil extends SqlSessionDaoSupport{
	@Resource(name ="sqlSessionFactory")  
    private  SqlSessionFactory sqlSessionFactory;
	public  SqlSession createSession(){
		SqlSession sqlSession=null;
		sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH, false); 
		return sqlSession;
		
	}
	public  void closeSession(SqlSession session){
		session.close();
		
	}

}
