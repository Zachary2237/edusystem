package com.wxh.test;

import com.wxh.dao.UserDao;
import com.wxh.dao.impl.UserDaoImpl;
import com.wxh.pojo.User;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author wxh
 * @create 2023-09-17 10:58
 */
public class UserDaoTest {

    UserDao userDao = new UserDaoImpl();

    @Test
    public void queryByUsername () {

        if (userDao.queryByUsername("admin") == null) {
            System.out.println("用户名可用");
        } else {
            System.out.println("用户名已存在");
        }
    }

    @Test
    public void queryByUsernameAndPassword () {
        if (userDao.queryByUsernameAndPassword("admin", "2333") == null) {
            System.out.println("登陆失败");
        } else {
            System.out.println("登陆成功");
        }

    }

    @Test
    public void saveUser () {

        User user = new User(null, "testUser", "123", "user@email.com");

        System.out.println(userDao.saveUser(user));

    }
}