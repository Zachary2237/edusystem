package com.wxh.test;

import com.wxh.utils.JdbcUtils;
import org.junit.Test;

import java.sql.Connection;

/**
 * @author wxh
 * @create 2023-09-15 14:44
 */
public class JdbcUtilsTest {

    @Test
    public void testJdbcUtils() {

        for (int i = 0; i < 100; i++) {
            Connection conn = JdbcUtils.getConnection();
            System.out.println(conn);
            JdbcUtils.close(conn);
        }

    }

}
