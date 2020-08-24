package com.yubin.mybatis.dao;

import com.yubin.mybatis.pojo.JointEmp;

/**
 * 联合查询相关部门持久层接口
 *
 * @author YUBIN
 * @create 2020-08-24
 */
public interface JointEmpDao {

    public JointEmp selectEmpByEmpno(Integer empno);
}
