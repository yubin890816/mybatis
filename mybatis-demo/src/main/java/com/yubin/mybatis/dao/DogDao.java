package com.yubin.mybatis.dao;

import com.yubin.mybatis.pojo.Dog;

/**
 * 狗的持久层接口
 *
 * @author YUBIN
 * @create 2020-08-24
 */
public interface DogDao {

    public Dog selectDogById(Integer id);
}
