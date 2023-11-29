package com.wxh.dao.impl;

import com.wxh.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author wxh
 * @create 2023-09-15 15:56
 */
public abstract class BaseDao {

    // 使用DBUtils操作数据库
    private QueryRunner queryRunner = new QueryRunner();

    /**
     * update()方法用于执行insert,update,delete语句
     * @param sql
     * @param args
     * @return -1表示失败,否则表示受到影响的行数
     */
    public int update(String sql, Object ...args) {

        Connection conn = JdbcUtils.getConnection();

        try {
            return queryRunner.update(conn, sql, args);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(conn);
        }

        return -1;
    }

    /**
     * 查询返回一个javaBean的sql语句
     * @param type 返回的对象类型
     * @param sql  执行的sql语句
     * @param args sql对应的参数值
     * @return
     * @param <T> 返回的类型的泛型
     */
    public <T> T queryForOne(Class<T> type, String sql, Object ...args) {

        Connection conn = JdbcUtils.getConnection();

        try {
            return queryRunner.query(conn, sql, new BeanHandler<T>(type), args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(conn);
        }
        return null;
    }

    /**
     * 查询返回多个javaBean对象的sql语句
     * @param type
     * @param sql
     * @param args
     * @return
     * @param <T>
     */
    public <T>List<T> queryForList(Class<T> type, String sql, Object ...args) {

        Connection conn = JdbcUtils.getConnection();

        try {
            return queryRunner.query(conn, sql, new BeanListHandler<T>(type), args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(conn);
        }

        return null;
    }

    /**
     * 执行返回一行一列的sql语句
     * @param sql
     * @param args
     * @return
     */
    public Object queryForSingleValue(String sql, Object ...args) {

        Connection conn = JdbcUtils.getConnection();

        try {
            return queryRunner.query(conn, sql, new ScalarHandler(), args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(conn);
        }

        return null;


    }



}
