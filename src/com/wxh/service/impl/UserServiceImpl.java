package com.wxh.service.impl;

import com.wxh.dao.UserDao;
import com.wxh.dao.impl.UserDaoImpl;
import com.wxh.pojo.User;
import com.wxh.service.UserService;

/**
 * @author wxh
 * @create 2023-09-17 11:34
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    @Override
    public void registerUser (User user) {

        userDao.saveUser(user);

    }

    @Override
    public User login (User user) {

        return userDao.queryByUsernameAndPassword(user.getUsername(), user.getPassword());

    }

    @Override
    public boolean existUsername (String username) {

        return userDao.queryByUsername(username) != null;

    }
}
