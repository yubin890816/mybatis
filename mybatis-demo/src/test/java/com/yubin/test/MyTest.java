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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    /**
     * 测试查询语句中useGeneratedKey和keyProperty属性的使用
     */
    @Test
    public void test8() {
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        User user = new User();
        user.setUserName("小红");
        Integer saveCount = mapper.saveUser(user);
        System.out.println(saveCount);
        System.out.println(user);
        sqlSession.commit();
        sqlSession.close();
    }

    /**
     * 演示参数列表中存在多个参数时,mybatis的取值方式
     */
    @Test
    public void test9() {
        EmpDao mapper = sqlSession.getMapper(EmpDao.class);
        Emp emp = mapper.selectEmpByNoAndName1(7369, "SMITH");
        System.out.println(emp);
        sqlSession.close();
    }

    /**
     * 使用自定义map的方式来传递参数
     */
    @Test
    public void test10() {
        EmpDao mapper = sqlSession.getMapper(EmpDao.class);
        Map<String, Object> map = new HashMap<>();
        map.put("empno", 7369);
        map.put("ename", "SMITH");
        Emp emp = mapper.selectEmpByNoAndName2(map);
        System.out.println(emp);
        sqlSession.close();
    }

    /**
     * 处理集合返回结果
     * 当返回结果类型为List<T> 的时候,resultType依然写的是集合中具体的类型
     */
    @Test
    public void test11() {
        EmpDao mapper = sqlSession.getMapper(EmpDao.class);
        List<Emp> emps = mapper.selectAll();
        for (Emp emp : emps) {
            System.out.println(emp);
        }
        sqlSession.close();
    }

    /**
     * 处理集合返回结果
     * 在查询的时候可以设置返回值的类型为map，当mybatis查询完成之后会把列的名称作为key,列的值作为value，转换到map中
     */
    @Test
    public void test12() {
        EmpDao mapper = sqlSession.getMapper(EmpDao.class);
        Map<String, Object> map = mapper.selectEmpByEmpnoReturnMap(7369);
        System.out.println(map);
        sqlSession.close();
    }

    /**
     * 处理集合返回结果
     * 注意:当返回的结果是一个Map集合对象的时候,返回值的类型一定要写具有的value的类型,同时在dao的方法上必须要添加@MapKey的注解,来设置key是什么结果
     */
    @Test
    public void test13() {
        EmpDao mapper = sqlSession.getMapper(EmpDao.class);
        Map<Integer, Emp> map = mapper.selectAll2();
        System.out.println(map);
        sqlSession.close();
    }
}
