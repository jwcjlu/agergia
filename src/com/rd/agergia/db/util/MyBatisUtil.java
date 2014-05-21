package com.rd.agergia.db.util;

import org.apache.ibatis.session.SqlSession;

public class MyBatisUtil {
	public static SqlSession createSession(){
		return null;
		
	}
	public static void closeSession(SqlSession session){
		session.close();
		
	}

}
