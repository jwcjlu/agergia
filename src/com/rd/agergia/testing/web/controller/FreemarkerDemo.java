package com.rd.agergia.testing.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller  
public class FreemarkerDemo {  
    @RequestMapping(value="/index")  
    public ModelAndView testfreemarkerview(HttpServletRequest request,HttpServletResponse response){  
        ModelAndView mav=new ModelAndView();   
        String str="这是返回给freemarker页面的值";  
        mav.addObject("haha", str);  
   
        ///这里顺便回顾下HashMap的使用方法  
/*      创建：Map<String,String> map = new HashMap<String,String>(); 
        插入元素：map.put("1","a");  
        移除元素: map.remove("1"); 
        清空: map.clear();*/  
        Map<String,String> map=new HashMap<String,String>();  
        map.put("name", "金伟");   
        map.put("address", "浙江省杭州市蒋村公交站");  
        map.put("company", "融都科技");  
        mav.addObject("maplist", map);  
        return mav;  
    }  
}  
