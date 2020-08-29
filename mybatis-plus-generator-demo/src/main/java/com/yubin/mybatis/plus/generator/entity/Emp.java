package com.yubin.mybatis.plus.generator.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author yubin
 * @since 2020-08-29
 */
@TableName("tbl_emp")
public class Emp implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "EMPNO", type = IdType.AUTO)
    private Integer empno;

    @TableField("E_NAME")
    private String eName;

    @TableField("JOB")
    private String job;

    @TableField("MGR")
    private Integer mgr;

    @TableField("HIREDATE")
    private LocalDate hiredate;

    @TableField("SAL")
    private BigDecimal sal;

    @TableField("COMM")
    private BigDecimal comm;

    @TableField("DEPTNO")
    private Integer deptno;


    public Integer getEmpno() {
        return empno;
    }

    public void setEmpno(Integer empno) {
        this.empno = empno;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Integer getMgr() {
        return mgr;
    }

    public void setMgr(Integer mgr) {
        this.mgr = mgr;
    }

    public LocalDate getHiredate() {
        return hiredate;
    }

    public void setHiredate(LocalDate hiredate) {
        this.hiredate = hiredate;
    }

    public BigDecimal getSal() {
        return sal;
    }

    public void setSal(BigDecimal sal) {
        this.sal = sal;
    }

    public BigDecimal getComm() {
        return comm;
    }

    public void setComm(BigDecimal comm) {
        this.comm = comm;
    }

    public Integer getDeptno() {
        return deptno;
    }

    public void setDeptno(Integer deptno) {
        this.deptno = deptno;
    }

    @Override
    public String toString() {
        return "Emp{" +
        "empno=" + empno +
        ", eName=" + eName +
        ", job=" + job +
        ", mgr=" + mgr +
        ", hiredate=" + hiredate +
        ", sal=" + sal +
        ", comm=" + comm +
        ", deptno=" + deptno +
        "}";
    }
}
