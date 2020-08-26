package com.yubin.ssm.controller;

import com.yubin.ssm.dao.EmpMapper;
import com.yubin.ssm.pojo.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * ssm框架整合测试类
 *
 * @author YUBIN
 * @create 2020-08-26
 */
@Controller
public class SsmTestController {

    @Autowired
    private EmpMapper empMapper;

    @ResponseBody
    @RequestMapping("/testSsm")
    public Emp testSsm() {
        Emp emp = empMapper.selectEmpByEmpno(7369);
        return emp;
    }
}
