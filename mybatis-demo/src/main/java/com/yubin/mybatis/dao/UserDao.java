package com.yubin.mybatis.dao;

import com.yubin.mybatis.pojo.User;

/**
 * 用户持久层接口
 *
 * @author YUBIN
 * @create 2020-08-20
 */
public interface UserDao {

    public User selectUserById(Integer id);

    public Integer saveUser(User user);
}
