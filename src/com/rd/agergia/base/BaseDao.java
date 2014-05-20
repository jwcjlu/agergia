package com.rd.agergia.base;

import java.util.List;
import java.util.Map;


public interface BaseDao<T> {
	/**
	 * 
	 * @param entity
	 */
	public<T> void save(T t);
	/**
	 * 
	 * @param classentity
	 * @param entityId
	 * @return
	 */
	public<T> T find(Class<T> entityClass,Object entityId);
	/**
	 * 
	 * @param entity
	 */
	public<T> void update(T entity);
	/**
	 * 
	 * @param entityId
	 */
	public <T>void delete(Class<T> entityClass,Object entityId);
	/**
	 * 
	 * @param entityIds
	 */
	public <T>void delete(Class<T> entityClass,Object []entityIds);
	/**
	 * @param indexPage
	 * @param pageSize
	 * @param filter
	 * @param orderbySql
	 * @return
	 */
	public <T>List<T> paging(int indexPage,int pageSize,String filter,Map<String,String> orderbySql);
}
