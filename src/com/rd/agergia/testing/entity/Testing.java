package com.rd.agergia.testing.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Testing implements Serializable {
	private int id;
	private String name;
	private boolean status;
	
	public Testing() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Testing [id=" + id + ", name=" + name + ", status=" + status
				+ "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	


}
