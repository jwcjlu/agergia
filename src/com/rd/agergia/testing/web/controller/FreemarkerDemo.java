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
        String str="���Ƿ��ظ�freemarkerҳ���ֵ";  
        mav.addObject("haha", str);  
   
        ///����˳��ع���HashMap��ʹ�÷���  
/*      ������Map<String,String> map = new HashMap<String,String>(); 
        ����Ԫ�أ�map.put("1","a");  
        �Ƴ�Ԫ��: map.remove("1"); 
        ���: map.clear();*/  
        Map<String,String> map=new HashMap<String,String>();  
        map.put("name", "��ΰ");   
        map.put("address", "�㽭ʡ�����н��幫��վ");  
        map.put("company", "�ڶ��Ƽ�");  
        mav.addObject("maplist", map);  
        return mav;  
    }  
}  
