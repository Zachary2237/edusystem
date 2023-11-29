package com.wxh.test;

import com.wxh.pojo.User;
import com.wxh.service.UserService;
import com.wxh.service.impl.UserServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author wxh
 * @create 2023-09-17 11:38
 */
public class UserServiceImplTest {

    UserService userService = new UserServiceImpl();

    @Test
    public void registerUser() {

        User user = new User(null, "wx", "123", "wx@email.com");

        userService.registerUser(user);

    }

    @Test
    public void login() {

        User user = new User(null, "wx", "234", "wx@email.com");

        System.out.println(userService.login(user));

    }

    @Test
    public void existUsername() {

        String username = "asdfasd";

        if (userService.existUsername(username)) {
            System.out.println("用户名已存在");
        } else {
            System.out.println("用户名不存在");
        }
    }
}