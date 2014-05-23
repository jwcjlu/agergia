package com.rd.agergia.testing.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.rd.agergia.common.entity.Pager;
import com.rd.agergia.common.entity.PagerParam;
import com.rd.agergia.testing.dao.ibatis.SqlMapTestingDAO;
import com.rd.agergia.testing.entity.Testing;

@Controller  
public class FreemarkerDemo {  
	@Resource
	private SqlMapTestingDAO sqlMapTestingDAO;
    @RequestMapping(value="/index")  
    public ModelAndView testfreemarkerview(HttpServletRequest request,HttpServletResponse response){  
        ModelAndView mav=new ModelAndView();   
        String str="agergia的第一个freemarker的demo";  
        mav.addObject("haha", str);  
		PagerParam pager=new PagerParam();
		pager.setPageOffset(0);
		pager.setPageSize(5);
		pager.setOrder("desc");
		pager.setSort("id");
        Pager testingPage=sqlMapTestingDAO.pageing(new Testing(), pager);
        Map<String,String> map=new HashMap<String,String>();  
        map.put("name", "金伟");   
        map.put("address", "浙江省省杭州市蒋村公交站");  
        map.put("company", "杭州融都科技有限公司");
        mav.addObject("testingPage",testingPage);
        mav.addObject("maplist", map);  
        return mav;  
    }  
}  
