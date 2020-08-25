package com.yubin.mybatis.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * 部门实体类
 *
 * @author YUBIN
 * @create 2020-08-24
 */
public class JointDept implements Serializable {
    private Integer deptno;

    private String dname;

    private String loc;

    private List<JointEmp> empList;

    public Integer getDeptno() {
        return deptno;
    }

    public void setDeptno(Integer deptno) {
        this.deptno = deptno;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public List<JointEmp> getEmpList() {
        return empList;
    }

    public void setEmpList(List<JointEmp> empList) {
        this.empList = empList;
    }

    @Override
    public String toString() {
        return "JointDept{" +
                "deptno=" + deptno +
                ", dname='" + dname + '\'' +
                ", loc='" + loc + '\'' +
                ", empList=" + empList +
                '}';
    }
}
