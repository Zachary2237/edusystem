package com.wxh.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author wxh
 * @create 2023-09-15 13:48
 */
public class JdbcUtils {

    private static DruidDataSource dataSource;

    static {

        Properties properties = new Properties();

        InputStream inputStream = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");

        try {
            properties.load(inputStream);
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);

//            System.out.println(dataSource.getConnection());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    /**
     * 获取数据库连接池中的连接
     *
     * @return 返回null说明获取连接失败,有值则成功.
     */
    public static Connection getConnection() {
        Connection conn = null;

        try {
            conn = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }

    /**
     * 关闭连接,放回数据库连接池
     * @param conn
     */
    public static void close(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
