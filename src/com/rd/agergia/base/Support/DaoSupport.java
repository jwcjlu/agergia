package com.rd.agergia.base.Support;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rd.agergia.base.BaseDao;
import com.rd.agergia.common.entity.QueryResult;
import com.rd.agergia.db.util.MyBatisUtil;

public abstract class DaoSupport<T>  implements BaseDao<T> {
	private final static Logger logger = LoggerFactory.getLogger(DaoSupport.class);


	@Override
	public void save(T obj) {
		// TODO Auto-generated method stub
		   SqlSession session=null;
	        try {
	            session = MyBatisUtil.createSession();
	            //Լ�� namespaceֵ�Ǹ�ʵ�����ȫ·�����������е���Ӷ���add
	            session.insert(obj.getClass().getName()+".add", obj);
	            session.commit();
	        } catch (Exception e) {
	            e.printStackTrace();
	            session.rollback();
	        }finally{
	            MyBatisUtil.closeSession(session);
	        }

	}

	@Override
	public <T> T find(Class<T> entityClass, Object entityId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(T obj) {
		// TODO Auto-generated method stub
		   SqlSession session=null;
	        try {
	            session = MyBatisUtil.createSession();
	            //Լ�� namespaceֵ�Ǹ�ʵ�����ȫ·�����������еĸ��¶���update
	            session.update(obj.getClass().getName()+".update", obj);
	            session.commit();
	        } catch (Exception e) {
	            e.printStackTrace();
	            session.rollback();
	        }finally{
	            MyBatisUtil.closeSession(session);
	        }

	}
	/**
     * ����ָ���Ķ��������ȡһ����¼����ͨ�ã�
     */
    public T load(String sqlId,Map<String,Object> params){
        SqlSession session=null;
        T obj=null;
        try {
            session = MyBatisUtil.createSession();
            //Լ�� namespaceֵ�Ǹ�ʵ�����ȫ·�����������еĸ���Id���ض���load
            obj=(T) session.selectOne(sqlId, params);    
        }finally{
            MyBatisUtil.closeSession(session);
        }
        return obj;
    }
	@Override
	public <T> void delete(Class<T> clazz, Object entityId) {
		// TODO Auto-generated method stub
		   SqlSession session=null;
	        try {
	            session = MyBatisUtil.createSession();
	            //Լ�� namespaceֵ�Ǹ�ʵ�����ȫ·�����������е�ɾ������delete
	            session.delete(clazz.getName()+".delete", entityId);
	            session.commit();
	        } catch (Exception e) {
	            e.printStackTrace();
	            session.rollback();
	        }finally{
	            MyBatisUtil.closeSession(session);
	        }

	}

	@Override
	public <T> void delete(Class<T> clazz, Object[] ids) {
		// TODO Auto-generated method stub
		if(ids!=null&&ids.length>0){
			for(Object id:ids){
				delete(clazz,  id);
			}
		}

	}

	@Override
	public <T> QueryResult<T> getPageingData(Class<T> entityClass,
			int firstIndex, int resultMax, String wheresql, Object[] params,
			LinkedHashMap<String, String> orderby) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> QueryResult<T> getPageingData(Class<T> entityClass,
			int firstIndex, int resultMax, String wheresql, Object[] params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> QueryResult<T> getPageingData(Class<T> entityClass,
			int firstIndex, int resultMax, LinkedHashMap<String, String> orderby) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> QueryResult<T> getPageingData(Class<T> entityClass,
			int firstIndex, int resultMax) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> QueryResult<T> getPageingData(Class<T> entityClass) {
		// TODO Auto-generated method stub
		return null;
	}

}
