package com.rd.agergia.base;

import java.util.List;

import com.rd.agergia.common.entity.PagerParam;



public interface BaseDao<T> {
	/**
	 *插入一条记录
	 * @param entity
	 */
	public void save(T obj);
	/**
	 * 根据id查询一条记录
	 * @param classentity
	 * @param entityId
	 * @return
	 */
	@SuppressWarnings("hiding")
	public<T> T find(T obj,Object entityId);
	/**
	 * 更新记录
	 * @param entity
	 */
	public void update(T obj);
	/**
	 * 根据id删除指定记录
	 * @param entityId
	 */
	@SuppressWarnings("hiding")
	public <T>void delete(Class<T> entityClass,Object entityId);
	/**
	 * 批量删除记录
	 * @param entityIds
	 */
	@SuppressWarnings("hiding")
	public <T>void delete(Class<T> entityClass,Object []entityIds);
	/**
	 * 分页查询
	 * @param entityClass
	 * @param firstIndex
	 * @param resultMax
	 * @param wheresql
	 * @param params
	 * @param orderby
	 * @return
	 */
	@SuppressWarnings("hiding")
	public<T> List<T> getPageingData(Class<T> entityClass,PagerParam pp);

}
