package com.rd.agergia.base.support;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.rd.agergia.base.BaseDao;
import com.rd.agergia.common.entity.Pager;
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
			result = (T) session.selectOne(obj.getClass().getName() + ".find",
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

	@SuppressWarnings("hiding")
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

	@SuppressWarnings("hiding")
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
	public Pager<T> getPageingData(Class<T> entityClass, PagerParam params) {
		// TODO Auto-generated method stub
		int pageOffset=params.getPageOffset();
        int pageSize=params.getPageSize();
        String order=params.getOrder();
        String sort=params.getSort(); 
        Pager<T> pages=new Pager<T>();
        SqlSession session=null;
        
        try {
            session =sqlSessionFactory.openSession();
            Map<String,Object> param=new HashMap<String,Object>();
            param.put("pageOffset", pageOffset);
            param.put("pageSize", pageSize);
            param.put("order", order);
            param.put("sort", sort);
            //约定 namespace值是该实体类的全路径，并且所有的分页查询都是find
            List<T> lists=session.selectList(entityClass.getName()+".page", param);
            pages.setData(lists);
            pages.setPageOffset(pageOffset);
            pages.setPageSize(pageSize);
            //获取当前条件下的所有记录数
            //查询记录的命名是 XXX，那么约定记录条数命名是 XXX_count
            int count=session.selectOne(entityClass.getName()+".page_count", params);
            pages.setTotalRecord(count);
            
        } finally{
            session.close();
        }
        return pages;
	
	}

}
