package com.yubin.mybatis.dao;

import com.yubin.mybatis.pojo.JointEmp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 联合查询相关部门持久层接口
 *
 * @author YUBIN
 * @create 2020-08-24
 */
public interface JointEmpDao {

    public JointEmp selectEmpByEmpno(Integer empno);

    public JointEmp selectEmpBySimple(Integer empno);

    public List<JointEmp> selectEmpStep(Integer deptno);

    /**
     * 根据条件查询员工信息
     * @param emp
     * @return
     */
    public List<JointEmp> selectEmpByCondition(JointEmp emp);

    /**
     * 根据条件查询员工信息 使用trim标签来处理sql动态拼接问题
     * @param emp
     * @return
     */
    public List<JointEmp> selectEmpByCondition2(JointEmp emp);

    /**
     * 根据员工编号列表查询员工信息
     * @param empnos
     * @return
     */
    public List<JointEmp> selectEmpByEmpNos(@Param("empnos") List<Integer> empnos);

    /**
     * 根据条件查询员工信息
     * @param emp
     * @return
     */
    public List<JointEmp> selectEmpByConditionChoose(JointEmp emp);

    /**
     * 根据员工编号动态更新员工信息
     * @param emp
     * @return
     */
    public Integer updateEmpByEmpno(JointEmp emp);
}
