package com.yubin.mybatis.dao;

import com.yubin.mybatis.pojo.Emp;

/**
 * 员工持久层接口
 *
 * @author YUBIN
 * @create 2020-08-19
 */
public interface EmpDao {

    // 保存员工信息
    public Integer save(Emp emp);

    // 根据员工编号删除员工信息
    public Integer delete(Integer empno);

    // 根据员工编号更新员工信息
    public Integer update(Emp emp);

    // 根据员工编号获取员工信息
    public Emp selectEmpByEmpno(Integer empno);
}
