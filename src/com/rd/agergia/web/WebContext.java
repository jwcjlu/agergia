package com.rd.agergia.web;

import java.net.URLEncoder;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WebContext {

	private static ThreadLocal<HttpServletRequest> request = new ThreadLocal<HttpServletRequest>();
	private static ThreadLocal<HttpServletResponse> response = new ThreadLocal<HttpServletResponse>();

	public static void setRequest(HttpServletRequest r) {
		request.set(r);
	}


	public static HttpServletRequest getRequest() {
		return request.get();
	}


	public static void remove() {
		request.remove();
		response.remove();
	}


	public static HttpServletResponse getResponse() {
		if (null == response.get()) {
			return null;
		}
		return response.get();
	}


	public static void setResponse(HttpServletResponse r) {
		r.setContentType("text/html;charset=UTF-8");
		response.set(r);
	}

	public static void putRequestAttribute(String key, Object value) {
		request.get().setAttribute(key, value);
	}


	public static void removeRequestAttribute(String key) {
		request.get().removeAttribute(key);
	}


	public static Object getRequestAttribute(String key) {
		if (null == request.get()) {
			return null;
		}
		return request.get().getAttribute(key);
	}


	public static Object getRequestParameter(String key) {
		return request.get().getParameter(key);
	}


	public static void setSessionAttribute(String key, Object value) {
		request.get().getSession().setAttribute(key, value);
	}


	public static Object getSessionAttribute(String key) {
		return request.get().getSession().getAttribute(key);
	}

	
	public static HttpServletResponse getExcelRespose() {
		return getExcelRespose(UUID.randomUUID().toString());
	}

	
	@SuppressWarnings("deprecation")
	public static HttpServletResponse getExcelRespose(String filename) {
		HttpServletResponse res = response.get();
		res.setContentType("application/x-xls");
		res.setCharacterEncoding("utf-8");
		res.setHeader("Content-disposition", "attachment;filename="
				+ URLEncoder.encode(filename) + ".xls");
		return res;
	}

}
