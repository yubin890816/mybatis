package com.yubin.ssm.dao;

import com.yubin.ssm.pojo.Emp;

/**
 * 联合查询相关部门持久层接口
 *
 * @author YUBIN
 * @create 2020-08-24
 */
public interface EmpMapper {

    public Emp selectEmpByEmpno(Integer empno);
}
