package com.rd.agergia.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rd.agergia.util.UnCaughtException;

public class WebApplicationContextFilter implements Filter {


	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		try {
			WebContext.setRequest((HttpServletRequest) request);
			WebContext.setResponse((HttpServletResponse) response);
			chain.doFilter(request, response);
		} catch (Exception e) {
			throw new UnCaughtException(e);
		} finally {
			WebContext.remove();
		}
	}

	@Override
	public void destroy() {
	}

}
