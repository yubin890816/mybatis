package com.yubin.mybatis.plus.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yubin.mybatis.plus.pojo.Emp;

import java.util.List;

/**
 * 员工持久层接口
 *
 * 在mybatis操作的时候,我们需要自己定义接口中实现的方法,并添加与之对应的EmpMapper.xml文件,编写对应的sql语句
 * 在mybatis-plus操作的时候,我们只需要继承BaseMapper接口即可,其中的泛型T表示我们要实际操作的实体类对象
 *
 * @author YUBIN
 * @create 2020-08-28
 */
public interface EmpMapper extends BaseMapper<Emp> {

    public List<Emp> selectByCondition(Emp emp);
}
