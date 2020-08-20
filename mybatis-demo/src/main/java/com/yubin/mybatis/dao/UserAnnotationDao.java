package com.yubin.mybatis.dao;

import com.yubin.mybatis.pojo.User;
import org.apache.ibatis.annotations.Select;

/**
 * 用户持久层接口
 *
 * @author YUBIN
 * @create 2020-08-20
 */
public interface UserAnnotationDao {

    @Select("select * from user where id = #{id}")
    public User selectUserById(Integer id);
}
