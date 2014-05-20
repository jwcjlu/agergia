package com.rd.agergia.db.util;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.rd.agergia.testing.entity.Testing;

public class DBUtil {
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
	    	   Method getMethod = pd.getReadMethod();//���get����
	    	            o = getMethod.invoke(obj);//ִ��get��������һ��Object
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
		t.setName("����ģ��");
		t.setStatus(false);
		System.out.println("id="+execGetter(t,"id"));
		
	}
}
