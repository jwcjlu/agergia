package com.rd.agergia.db.util;
import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.DELETE_FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SELECT;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;
import com.rd.agergia.db.util.DBUtil;
import com.rd.agergia.testing.entity.Testing;
public class SqlProvider {
    public static String getSql(Object obj,String profix) {
        BEGIN();
        //SELECT("id,title,authername,date,content");
        SELECT("*");
        FROM(DBUtil.getTableFromClass(obj.getClass(), profix));
        //注意这里这种传递参数方式，#{}与map中的key对应，而map中的key又是注解param设置的
        WHERE("id = #{id}");
        return SQL();
    }
    public static String getAllSql(Object obj,String profix) {
        BEGIN();
        SELECT("*");
        FROM(DBUtil.getTableFromClass(obj.getClass(), profix));
        return SQL();
    }
 
    public static String insertSql(Object obj,String profix) {
        BEGIN();
        INSERT_INTO(DBUtil.getTableFromClass(obj.getClass(), profix));
        String []tableNames=DBUtil.getFieldsFromClass(obj.getClass());
        for(String tableName:tableNames){
        VALUES(DBUtil.addUnderline(tableName), "#"+tableName);
        }
   
        return SQL();
    }
    public static String deleteSql(Object obj,String profix) {
        BEGIN();
        DELETE_FROM(DBUtil.getTableFromClass(obj.getClass(), profix));
        WHERE("id = #{id}");
        return SQL();
    }
    public static String updateSql(Object obj,String profix,String filter) {
        BEGIN();
        UPDATE(DBUtil.getTableFromClass(obj.getClass(), profix));
        String []tableNames=DBUtil.getFieldsFromClass(obj.getClass());
       
        for(String tableName:tableNames){
        	SET(DBUtil.addUnderline(tableName)+"=#{"+tableName+"}");
        }
        WHERE(DBUtil.addUnderline(filter)+" = #{id}");
        return SQL();
    }
    public static void main(String[] args) {
		Testing t=new Testing();
		System.out.println(updateSql(t,"dw","id"));
	}
}
