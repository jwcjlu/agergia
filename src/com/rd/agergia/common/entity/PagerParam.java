package com.rd.agergia.common.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PagerParam {
	private int pageOffset;
	private int pageSize;
    private Map<String,String> order=new HashMap<String,String>();
    private List<String>filter=new ArrayList<String>();
	public int getPageOffset() {
		return pageOffset;
	}
	public void setPageOffset(int pageOffset) {
		this.pageOffset = pageOffset;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public Map<String, String> getOrder() {
		return order;
	}
	public void setOrder(Map<String, String> order) {
		this.order = order;
	}
	public List<String> getFilter() {
		return filter;
	}
	public void setFilter(List<String> filter) {
		this.filter = filter;
	}
    
 

}
