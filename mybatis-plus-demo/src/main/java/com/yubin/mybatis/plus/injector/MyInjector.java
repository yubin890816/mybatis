package com.yubin.mybatis.plus.injector;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.injector.AbstractSqlInjector;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 自定义注入器
 *
 * @author YUBIN
 * @create 2020-08-29
 */
public class MyInjector extends AbstractSqlInjector {

    @Override
    public List<AbstractMethod> getMethodList(Class<?> mapperClass) {
        return Stream.of(new DeleteAll()).collect(Collectors.toList());
    }
}
