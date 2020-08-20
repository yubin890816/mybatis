package com.yubin.test;

import com.yubin.mybatis.dao.EmpDao;
import com.yubin.mybatis.dao.UserAnnotationDao;
import com.yubin.mybatis.dao.UserClassDao;
import com.yubin.mybatis.dao.UserDao;
import com.yubin.mybatis.pojo.Emp;
import com.yubin.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;

/**
 * 测试类
 *
 * @author YUBIN
 * @create 2020-08-19
 */
public class MyTest {

    private SqlSession sqlSession;

    @Before
    public void init() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession();
    }

    @Test
    public void test1() {
        Emp emp = (Emp) sqlSession.selectOne("com.yubin.mybatis.dao.EmpDao.selectEmpByEmpno", 7839);
        System.out.println(emp);

        EmpDao mapper = sqlSession.getMapper(EmpDao.class);
        Emp emp1 = mapper.selectEmpByEmpno(7369);
        System.out.println(emp1);
        sqlSession.close();
    }

    @Test
    public void test2() {
        Emp emp = new Emp();
        emp.setEmpno(11111);
        emp.setEname("张三");
        EmpDao mapper = sqlSession.getMapper(EmpDao.class);

        Integer save = mapper.save(emp);
        System.out.println(save);

        // mybatis默认事务是手动提交,这里需要手动的写一个commit,或者sqlSessionFactory.openSession(true);
        sqlSession.commit();

        sqlSession.close();
    }

    @Test
    public void test3() {
        Emp emp = new Emp();
        emp.setEmpno(11111);
        emp.setEname("李四");
        emp.setSal(new BigDecimal("900"));

        EmpDao mapper = sqlSession.getMapper(EmpDao.class);

        Integer update = mapper.update(emp);
        System.out.println(update);

        // mybatis默认事务是手动提交,这里需要手动的写一个commit,或者sqlSessionFactory.openSession(true);
        sqlSession.commit();

        sqlSession.close();
    }

    @Test
    public void test4() {

        EmpDao mapper = sqlSession.getMapper(EmpDao.class);
        Integer delete = mapper.delete(11111);
        System.out.println(delete);
        // mybatis默认事务是手动提交,这里需要手动的写一个commit,或者sqlSessionFactory.openSession(true);
        sqlSession.commit();

        sqlSession.close();
    }

    /**
     * 驼峰匹配的演示
     */
    @Test
    public void test5() {
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        User user = mapper.selectUserById(1);
        System.out.println(user);
    }

    /**
     * 演示<mapper>标签的class属性 注解形式
     */
    @Test
    public void test6() {
        UserAnnotationDao mapper = sqlSession.getMapper(UserAnnotationDao.class);
        User user = mapper.selectUserById(1);
        System.out.println(user);
    }

    /**
     * 演示<mapper>标签的class属性带mapper.xml
     */
    @Test
    public void test7() {
        UserClassDao mapper = sqlSession.getMapper(UserClassDao.class);
        User user = mapper.selectUserById(1);
        System.out.println(user);
    }
}
