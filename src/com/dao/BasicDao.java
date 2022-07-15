package com.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.utils.JDBCUtils;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

public class BasicDao<T> {

    private QueryRunner qr = new QueryRunner();

    // DML操作方法的通用方法
    public int update(String sql, Object... parameters) {
        Connection connection = null;

        try {
            connection = JDBCUtils.getConnection();
            int update = qr.update(connection, sql, parameters);
            return update;
        } catch (SQLException e) {
            throw new RuntimeException();
        } finally {
            JDBCUtils.close(null, null, connection);
        }
    }

    // 查询多行多列的通用方法
    public List<T> queryMany(String sql, Class<T> clazz, Object... parameters) {
        Connection connection = null;

        try {
            connection = JDBCUtils.getConnection();
            return qr.query(connection, sql, new BeanListHandler<>(clazz), parameters); // List<T> query
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils.close(null, null, connection);
        }
    }

    // 组织sql语句
    public String getSql(String sql,String[] sql_d,int[] index){
        for(int i=0;i<index.length;i++){
            sql += sql_d[index[i]];
            for(int j=i+1;j<index.length;j++){
                sql += "and " + sql_d[index[j]];
            }
            break;
        }
        return sql;
    }


}