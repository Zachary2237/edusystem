package com.wxh.service;

import com.wxh.pojo.User;

/**
 * @author wxh
 * @create 2023-09-17 11:29
 */
public interface UserService {

    /**
     * 注册用户
     * @param user
     */
    public void registerUser(User user);

    /**
     * 用户登录
     * @param user
     * @return 返回null说明登陆失败
     */
    public User login(User user);

    /**
     * 检查用户名是否可用
     * @param username
     * @return
     */
    public boolean existUsername(String username);

}
