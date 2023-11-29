package com.wxh.dao.impl;

import com.wxh.dao.UserDao;
import com.wxh.pojo.User;

/**
 * @author wxh
 * @create 2023-09-17 10:48
 */
public class UserDaoImpl extends BaseDao implements UserDao {

    @Override
    public User queryByUsername (String username) {
        String sql = "select id, username, password, email from t_user where username = ?;";
        return queryForOne(User.class, sql, username);
    }

    @Override
    public User queryByUsernameAndPassword (String username, String password) {
        String sql = "select id, username, password, email from t_user where username = ? and password = ?;";
        return queryForOne(User.class, sql, username, password);
    }

    @Override
    public int saveUser (User user) {
        String sql = "insert into t_user (username, password, email) values (?, ?, ?);";
        return update(sql, user.getUsername(), user.getPassword(), user.getEmail());
    }
}
