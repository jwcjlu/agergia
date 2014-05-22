package com.rd.agergia.base.support;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rd.agergia.base.BaseDao;
import com.rd.agergia.common.entity.PagerParam;

public abstract class DaoSupport<T> implements BaseDao<T> {
	private final static Logger logger = LoggerFactory
			.getLogger(DaoSupport.class);
	@Resource(name = "sqlSessionFactory")
	private SqlSessionFactory sqlSessionFactory;

	@Override
	public void save(T obj) {
		// TODO Auto-generated method stub
		SqlSession session = null;
		try {
			session = sqlSessionFactory.openSession();
			// 约定 namespace值是该实体类的全路径，并且所有的添加都是add
			session.insert(obj.getClass().getName() + ".add", obj);
			session.commit();
		} catch (Exception e) {
			logger.error(e.getMessage());
			session.rollback();
		} finally {
			session.close();
		}

	}

	@SuppressWarnings({ "hiding", "unchecked" })
	@Override
	public <T> T find(T obj, Object entityId) {
		// TODO Auto-generated method stub
		SqlSession session = null;
		T result = null;
		try {
			session = sqlSessionFactory.openSession();
			// 约定 namespace值是该实体类的全路径,并且根据id查询都用find
			obj = (T) session.selectOne(obj.getClass().getName() + ".find",
					entityId);
		} finally {
			session.close();
		}
		return result;
	}

	@Override
	public void update(T obj) {
		// TODO Auto-generated method stub
		SqlSession session = null;
		try {
			session = sqlSessionFactory.openSession();
			// 约定 namespace值是该实体类的全路径，并且所有的更新都是update
			session.update(obj.getClass().getName() + ".update", obj);
			session.commit();
		} catch (Exception e) {
			logger.error(e.getMessage());
			session.rollback();
		} finally {
			session.close();
		}

	}

	public T load(String sqlId, Map<String, Object> params) {
		SqlSession session = null;
		T obj = null;
		try {
			session = sqlSessionFactory.openSession();
			// 约定 namespace值是该实体类的全路径，并且所有的根据Id加载都是load
			obj = (T) session.selectOne(sqlId, params);
		} finally {
			session.close();
		}
		return obj;
	}

	@Override
	public <T> void delete(Class<T> clazz, Object entityId) {
		// TODO Auto-generated method stub
		SqlSession session = null;
		try {
			session = sqlSessionFactory.openSession();
			// 约定 namespace值是该实体类的全路径，并且所有的删除都是delete
			session.delete(clazz.getName() + ".delete", entityId);
			session.commit();
		} catch (Exception e) {
			logger.error(e.getMessage());
			session.rollback();
		} finally {
			session.close();
		}

	}

	@Override
	public <T> void delete(Class<T> clazz, Object[] ids) {
		// TODO Auto-generated method stub
		if (ids != null && ids.length > 0) {
			for (Object id : ids) {
				delete(clazz, id);
			}
		}

	}

	@Override
	public <T> List<T> getPageingData(Class<T> entityClass, PagerParam pp) {
		// TODO Auto-generated method stub
		SqlSession session = null;
		List<T> results = null;
		try {
			session = sqlSessionFactory.openSession();
			results = session.selectList(entityClass.getClass().getName(), pp);
		} catch (Exception e) {

		} finally {
			session.close();
		}

		return results;
	}

}
