package com.tech.movie.service.impl;

import com.tech.movie.common.SverResponse;
import com.tech.movie.pojo.User;

public interface UserServiceImpl {

    /**
     * 注册用户
     * @param user
     * @return
     */
    public SverResponse<String> doRegister(User user);

    /**
     * 检查用户名、邮箱或者电话是否已经被注册
     * @param str
     * @param type
     * @return
     */
    public SverResponse<String> checkValidation(String str, String type);

    /**
     * 登录
     * @param account
     * @param password
     * @return
     */
    public SverResponse<User> doLogin(String account, String password);

    /**
     * 修改个人信息
     * @param user
     * @return
     */
    public SverResponse<User> updateUserInfo(User user);

    /**
     * 修改密码
     * @param user
     * @param newpwd
     * @param oldpwd
     * @return
     */
    public SverResponse<String> updatePassword(User user, String newpwd, String oldpwd);

    /**
     * 判断是否为管理员
     * @param user
     * @return
     */
    public SverResponse<String> isAdmin(User user);

    /**
     * 根据账号名称获取账户信息
     * @param account
     * @return
     */
    public SverResponse<User> findUserByAccount(String account, String type);
}
