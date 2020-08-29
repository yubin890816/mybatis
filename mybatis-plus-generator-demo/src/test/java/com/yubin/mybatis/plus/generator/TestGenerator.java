package com.yubin.mybatis.plus.generator;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * 测试mybatis-plus代码生成器
 *
 * @author YUBIN
 * @create 2020-08-29
 */
public class TestGenerator {

    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        //String projectPath = System.getProperty("user.dir");
        // 设置输出路径
        gc.setOutputDir("E:/git_project/mybatis/mybatis-plus-generator-demo/src/main/java");
        // 设置作者
        gc.setAuthor("yubin");
        // 设置文件覆盖
        gc.setFileOverride(true);
        // 设置主键生成策略
        gc.setIdType(IdType.AUTO);
        // 设置Service接口名称
        gc.setServiceName("%sService");
        // 设置基本结果集合
        gc.setBaseResultMap(true);
        // 设置基本的列(sql标签)
        gc.setBaseColumnList(true);
        // 设置Controller层的名称
        gc.setControllerName("%sController");
        // 设置生成完成后不打开目录
        gc.setOpen(false);
        // gc.setSwagger2(true); 实体属性 Swagger2 注解
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/demo?useUnicode=true&useSSL=false&characterEncoding=utf8");
        // dsc.setSchemaName("public");
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("123456");
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        //pc.setModuleName(scanner("模块名"));
        pc.setParent("com.yubin.mybatis.plus.generator");
        pc.setController("controller");
        pc.setService("service");
        pc.setMapper("mapper");
        pc.setEntity("entity");
        pc.setXml("mapper");

        mpg.setPackageInfo(pc);


        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel); // 映射实体类的时候类名的策略(驼峰匹配)
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        //strategy.setSuperEntityClass("你自己的父类实体,没有就不用设置!");
        //strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        // 公共父类
        //strategy.setSuperControllerClass("你自己的父类控制器,没有就不用设置!");
        // 写于父类中的公共字段
        //strategy.setSuperEntityColumns("id");
        //strategy.setInclude(scanner("表名，多个英文逗号分割").split(",")); // 设置要包含的表
        strategy.setInclude("tbl_emp"); // 设置要包含的表
        //strategy.setControllerMappingHyphenStyle(true);
        //strategy.setTablePrefix(pc.getModuleName() + "_");
        strategy.setTablePrefix("tbl_"); // 设置表名的前缀

        mpg.setStrategy(strategy);
        mpg.execute();
    }
}
