package com.yubin.mybatis.plus.pojo;

import com.baomidou.mybatisplus.annotation.*;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 员工实体类
 *
 * @author YUBIN
 * @create 2020-08-28
 */
//@TableName("tbl_emp")
public class Emp {

    /**
     *	在mybatis-plus2.x版本的时候,如果设置了表自增,那么id必须指定为auto类型,否则插入不成功, 3.x不存在此问题
     */
    @TableId(value = "empno",type = IdType.AUTO)
    private Integer empno;

    @TableField(value = "e_name", fill = FieldFill.INSERT)
    private String eName;

    private String job;

    private Integer mgr;

    private Date hiredate;

    private BigDecimal sal;

    private BigDecimal comm;

    private Integer deptno;

    @Version
    private Long version;

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

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
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

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "empno=" + empno +
                ", eName='" + eName + '\'' +
                ", job='" + job + '\'' +
                ", mgr=" + mgr +
                ", hiredate=" + hiredate +
                ", sal=" + sal +
                ", comm=" + comm +
                ", deptno=" + deptno +
                ", version=" + version +
                '}';
    }
}
