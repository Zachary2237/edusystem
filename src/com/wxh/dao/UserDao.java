package com.wxh.dao;

import com.wxh.pojo.User;

/**
 * @author wxh
 * @create 2023-09-17 10:42
 */
public interface UserDao {


    /**
     * 根据用户名查询用户信息
     * @param username 用户名
     * @return 如果返回null,说明没有此用户.不然返回对应用户
     */
    public User queryByUsername(String username);

    /**
     * 根据用户名和密码查询用户
     * @param username 用户名
     * @param password 密码
     * @return 返回null:无用户
     */
    public User queryByUsernameAndPassword(String username, String password);

    /**
     * 保存用户信息
     * @param user
     * @return  -1表示操作失败,否则返回受到影响的行数
     */
    public int saveUser(User user);

}
