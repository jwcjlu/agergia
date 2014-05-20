package com.rd.agergia.base;

import java.util.LinkedHashMap;

import com.rd.agergia.common.entity.QueryResult;



public interface BaseDao<T> {
	/**
	 * ����ʵ������
	 * @param entity
	 */
	public void save(Object entity);
	/**
	 * ����ʵ��id����ʵ������
	 * @param classentity
	 * @param entityId
	 * @return
	 */
	public<T> T find(Class<T> entityClass,Object entityId);
	/**
	 * �޸�ʵ������
	 * @param entity
	 */
	public void update(Object entity);
	/**
	 * ����idɾ��һ��ʵ��
	 * @param entityId
	 */
	public <T>void delete(Class<T> entityClass,Object entityId);
	/**
	 * ɾ�����ʵ��
	 * @param entityIds
	 */
	public <T>void delete(Class<T> entityClass,Object []entityIds);
	/**
	 * ��������й�����ӵķ�ҳ��ѯ
	 * @param entityClass
	 * @param firstIndex
	 * @param resultMax
	 * @param wheresql
	 * @param params
	 * @param orderby
	 * @return
	 */
	public<T> QueryResult<T> getPageingData(Class<T> entityClass,int firstIndex,
			int resultMax,String wheresql,Object[]params,LinkedHashMap<String,String>orderby);
	/**
	 * �й��������ķ�ҳ��ѯ
	 * @param entityClass
	 * @param firstIndex
	 * @param resultMax
	 * @param wheresql
	 * @param params
	 * @return
	 */
	public<T> QueryResult<T> getPageingData(Class<T> entityClass,int firstIndex,
			int resultMax,String wheresql,Object[]params);

	/**
	 * ������ķ�ҳ��ѯ
	 * @param entityClass
	 * @param firstIndex
	 * @param resultMax
	 * @param orderby
	 * @return
	 */
	public<T> QueryResult<T> getPageingData(Class<T> entityClass,int firstIndex,
			int resultMax,LinkedHashMap<String,String>orderby);
	/**
	 * ��ҳ��ѯ
	 * @param entityClass
	 * @param firstIndex
	 * @param resultMax
	 * @return
	 */
	public<T> QueryResult<T> getPageingData(Class<T> entityClass,int firstIndex,
			int resultMax);
	/**
	 * ��ѯ���м�¼
	 * @param entityClass

	 * @return
	 */
	public<T> QueryResult<T> getPageingData(Class<T> entityClass);
}
