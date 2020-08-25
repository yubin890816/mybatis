package com.yubin.test;

import com.yubin.mybatis.dao.JointEmpDao;
import com.yubin.mybatis.pojo.JointEmp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.List;

/**
 * 测试类
 *
 * @author YUBIN
 * @create 2020-08-25
 */
public class MyTest2 {

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void init() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory =  new SqlSessionFactoryBuilder().build(inputStream);
    }

    /**
     * 一级缓存测试
     * @throws IOException
     */
    @Test
    public void test1() {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        JointEmpDao mapper = sqlSession.getMapper(JointEmpDao.class);
        JointEmp emp1 = mapper.selectEmpByEmpno(7369);
        System.out.println(emp1);
        JointEmp emp2 = mapper.selectEmpByEmpno(7369);
        System.out.println(emp2);
        sqlSession.close();
    }

    /**
     * 一级缓存失效测试
     * 不同的sqlSession
     */
    @Test
    public void test2() {
        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        JointEmpDao mapper1 = sqlSession1.getMapper(JointEmpDao.class);
        JointEmp emp1 = mapper1.selectEmpByEmpno(7369);
        System.out.println(emp1);
        sqlSession1.close();
        System.out.println("================================");
        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        JointEmpDao mapper2 = sqlSession2.getMapper(JointEmpDao.class);
        JointEmp emp2 = mapper2.selectEmpByEmpno(7369);
        System.out.println(emp2);
        sqlSession2.close();
    }

    /**
     * 一级缓存失效测试
     * sql相同,参数不同
     */
    @Test
    public void test3() {
        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        JointEmpDao mapper1 = sqlSession1.getMapper(JointEmpDao.class);
        JointEmp emp1 = mapper1.selectEmpByEmpno(7369);
        System.out.println(emp1);
        System.out.println("================================");
        JointEmp emp2 = mapper1.selectEmpByEmpno(7499);
        System.out.println(emp2);
        sqlSession1.close();
    }

    /**
     * 一级缓存失效
     * sql相同,参数不同
     * @throws IOException
     */
    @Test
    public void test4() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        JointEmpDao mapper = sqlSession.getMapper(JointEmpDao.class);
        JointEmp emp = new JointEmp();
        //emp.setEmpno(7369);
        //emp.setEname("刘一");
        emp.setSal(new BigDecimal("100"));
        List<JointEmp> jointEmps1 = mapper.selectEmpByCondition(emp);
        System.out.println(jointEmps1);
        System.out.println("=============================================");
        emp.setEmpno(7369);
        List<JointEmp> jointEmps2 = mapper.selectEmpByCondition(emp);
        System.out.println(jointEmps2);
        sqlSession.close();
    }

    /**
     * 一级缓存失效
     * 在同一个连接中，如果在两个相同的查询之间修改了数据，那么结果就不会缓存
     */
    @Test
    public void test5(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        JointEmpDao mapper = sqlSession.getMapper(JointEmpDao.class);
        JointEmp emp1 = mapper.selectEmpByEmpno(7369);
        System.out.println(emp1);
        System.out.println("================================");
        emp1.setEname("刘一");
        int i = mapper.updateEmpByEmpno(emp1);
        System.out.println(i);
        System.out.println("================================");
        JointEmp emp2 = mapper.selectEmpByEmpno(7369);
        System.out.println(emp2);
        sqlSession.close();
    }

    /**
     * 一级缓存失效
     * 在同一个连接中，如果在两个相同的查询之间手动去清空缓存,也会让缓存失效
     */
    @Test
    public void test6(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        JointEmpDao mapper = sqlSession.getMapper(JointEmpDao.class);
        JointEmp emp1 = mapper.selectEmpByEmpno(7369);
        System.out.println(emp1);
        System.out.println("================================");
        sqlSession.clearCache();
        System.out.println("================================");
        JointEmp emp2 = mapper.selectEmpByEmpno(7369);
        System.out.println(emp2);
        sqlSession.close();
    }
}
