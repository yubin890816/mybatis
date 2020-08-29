package com.yubin.mybatis.plus.fill;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;

/**
 * 自定义的公共字段填充
 *      这种方式比较使用时间字段  如updateTime
 * @author YUBIN
 * @create 2020-08-29
 */
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        // fieldName对应的是实体类的字段名
        this.strictInsertFill(metaObject, "eName", String.class, "默认名");
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.strictUpdateFill(metaObject, "eName", String.class,"默认名");
    }
}
