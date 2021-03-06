package com.yubin.mybatis.plus.test;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yubin.mybatis.plus.dao.EmpMapper;
import com.yubin.mybatis.plus.pojo.Emp;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 测试类
 *
 * @author YUBIN
 * @create 2020-08-28
 */
public class MyTest {

    /**
     * 验证数据源配置
     */
    @Test
    public void test01() throws SQLException {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        DataSource dataSource = context.getBean("dataSource", DataSource.class);
        System.out.println(dataSource.getConnection());
    }

    private ApplicationContext context;

    private EmpMapper mapper;

    @Before
    public void init() {
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
        mapper = context.getBean(EmpMapper.class);
    }

    /**
     * 测试mybatis-plus的新增操作
     */
    @Test
    public void test02() {
        Emp emp = new Emp();
        //emp.setEmpno(666);
        emp.seteName("张三");
        emp.setJob("Teacher");
        emp.setMgr(100);
        //emp.setHiredate(new Date());
        //emp.setSal(new BigDecimal("1000"));
        //emp.setComm(new BigDecimal("500"));
        //emp.setDeptno(10);
        int insertCount = mapper.insert(emp);
        System.out.println(insertCount);
        System.out.println(emp.getEmpno());
    }

    /**
     * 测试mybatis-plus的更新操作
     *  更新的时候也是根据输入的对象字段来动态调整我们的sql
     */
    @Test
    public void test03() {
        Emp emp = new Emp();
        emp.setEmpno(667);
        emp.seteName("王五");
        emp.setJob("student");
        emp.setMgr(101);
        //emp.setHiredate(new Date());
        //emp.setSal(new BigDecimal("2000"));
        //emp.setComm(new BigDecimal("600"));
        //emp.setDeptno(11);
        int updateCount = mapper.updateById(emp);
        System.out.println(updateCount);
    }

    /**
     * 测试mybatis-plus的删除操作
     *  更新的时候也是根据输入的对象字段来动态调整我们的sql
     */
    @Test
    public void test04() {
        // 根据id 删除记录
        //int deleteCount = mapper.deleteById(668);
        //System.out.println(deleteCount);

        // 根据一组id删除记录
        //int deleteCount = mapper.deleteBatchIds(Arrays.asList(666, 667));
        //System.out.println(deleteCount);

        /**
         * 条件封装map删除数据
         * 但是要注意:map的key对应的是列的名称 value对应的是列的值
         */
        //Map<String, Object> map = new HashMap<String, Object>();
        //map.put("empno", 669);
        //map.put("e_name", "张三");
        //int deleteCount = mapper.deleteByMap(map);
        //System.out.println(deleteCount);

        // 根据条件删除数据
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("e_name", "张三");
        int deleteCount = mapper.delete(wrapper);
        System.out.println(deleteCount);
    }

    /**
     * 测试mybatis-plus的查询操作
     */
    @Test
    public void test05() {
        // 根据id查询对象
        Emp emp = mapper.selectById(673);
        System.out.println(emp);

        System.out.println("===================================");
        // 根据实体包装类,查询单个对象, 返回的结果集有且仅有一条记录,如果返回多个则会报错
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("empno", 674);
        wrapper.eq("e_name", "张三");
        Emp emp1 = mapper.selectOne(wrapper);
        System.out.println(emp1);

        System.out.println("===================================");
        // 根据多个id进行查询
        List<Emp> empList = mapper.selectBatchIds(Arrays.asList(673, 674, 675));
        System.out.println(empList);

        System.out.println("===================================");
        // 根据map条件查询记录
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("e_name", "张三");
        List<Emp> emps = mapper.selectByMap(map);
        System.out.println(emps);

        System.out.println("===================================");
        /**
         * 分页查询,需要添加分页插件
         * <property name="plugins">
         *     <array>
         *         <bean class="com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor"/>
         *     </array>
         * </property>
         */
        Page<Emp> page = mapper.selectPage(new Page<Emp>(2, 2), null);
        System.out.println(page.getRecords());
    }

    /**
     * 测试非mybatis-plus中的BaseMapper类中的方法
     */
    @Test
    public void test06() {
        // 根据id查询对象
        Emp emp = new Emp();
        emp.seteName("张三");
        List<Emp> emps = mapper.selectByCondition(emp);
        System.out.println(emps);
    }

    /**
     * mybatis-plus 内置分页插件的使用示例
     */
    @Test
    public void test07() {
        Page<Emp> empPage = mapper.selectPage(new Page<Emp>(2, 3), null);
        System.out.println("获取的记录:" + empPage.getRecords());

        System.out.println("获取的总条数:" + empPage.getTotal());

        System.out.println("当前页码:" + empPage.getCurrent());

        System.out.println("总页码:" + empPage.getPages());

        System.out.println("每页显示的条数:" + empPage.getSize());

        System.out.println("是否有下一页:" + empPage.hasNext());

        System.out.println("是否有上一页:" + empPage.hasPrevious());
    }

    /**
     * mybatis-plus 内置乐观锁插件的使用示例
     */
    @Test
    public void test08() {
        Emp emp = new Emp();
        emp.setEmpno(673);
        emp.seteName("李四");
        emp.setSal(new BigDecimal("1000"));
        emp.setVersion(1L); // 该值为当前记录的版本号

        int updateCount = mapper.updateById(emp);
        System.out.println(updateCount);
    }

    /**
     * mybatis-plus SQL执行分析插件, 避免出现全表更新和删除
     */
    @Test
    public void test09() {
        Emp emp = new Emp();
        emp.setSal(new BigDecimal("20000"));

        int updateCount = mapper.update(emp, null);
        System.out.println(updateCount);
    }

    /**
     * mybatis-plus 非法Sql检查插件
     */
    @Test
    public void test10() {
        QueryWrapper<Emp> wrapper = new QueryWrapper();
        wrapper.or();
        List<Emp> emps = mapper.selectList(wrapper);
        System.out.println(emps);
    }

    /**
     * sql注入器
     */
    @Test
    public void test11() {
        Integer deleteCount = mapper.deleteAll();
        System.out.println(deleteCount);
    }

    /**
     * 公共字段填充测试
     */
    @Test
    public void test12() {
        int insertCount = mapper.insert(new Emp());
        System.out.println(insertCount);
    }
}
