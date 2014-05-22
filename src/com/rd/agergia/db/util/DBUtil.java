package com.rd.agergia.db.util;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.rd.agergia.testing.entity.Testing;

public class DBUtil {
	public static String getTableFromClass(Class clazz,String profix){
		StringBuffer sb=new StringBuffer();
		sb.append(profix.equals("")?clazz.getSimpleName().toLowerCase():profix+"_"+clazz.getSimpleName());
		return sb.toString();
		
	}
	public static String addUnderline(String tableName){
		StringBuffer sb=new StringBuffer();
		char [] chs=tableName.toCharArray();
		for(char c:chs){
			sb.append(Character.isLowerCase(c)?c:"_"+c);
		}
		return sb.toString();
		
	}
	  public static String[] getFieldsFromClass(Class bean){
		Field[] fs=  bean.getDeclaredFields();
		String []fieldNames=new String[fs.length];
		for(int i=0;i<fs.length;i++){
			fieldNames[i]=fs[i].getName();
		}
		  return fieldNames;
	  }
	  public static Object execGetter(Object obj,String fieldName){
		  Object o=null;
	      try {
	    	   Class clazz = obj.getClass();
	    	   PropertyDescriptor pd = new PropertyDescriptor(fieldName,clazz);
	    	   Method getMethod = pd.getReadMethod();
	    	            o = getMethod.invoke(obj);
	    	  } catch (SecurityException e) {
	    	   e.printStackTrace();
	    	  } catch (IllegalArgumentException e) {
	    	   e.printStackTrace();
	    	  } catch (IntrospectionException e) {
	    	   e.printStackTrace();
	    	  } catch (IllegalAccessException e) {
	    	   e.printStackTrace();
	    	  } catch (InvocationTargetException e) {
	    	   e.printStackTrace();
	    	  }
	      return o;
		  
	  }
	  public static void main(String[] args) {
		String[]names=DBUtil.getFieldsFromClass(Testing.class);
		for(String name:names){
			System.out.println(name);
		}
		
		Testing t=new Testing();
		t.setId(1);
		t.setName("测试模块名称");
		t.setStatus(false);
		System.out.println(getTableFromClass(new Testing().getClass(),"dw"));
		System.out.println(addUnderline("tableName"));
		System.out.println(Testing.class.getSimpleName());
		System.out.println("id="+execGetter(t,"id"));
		
	}
}
