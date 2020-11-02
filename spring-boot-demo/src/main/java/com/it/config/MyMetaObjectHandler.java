package com.it.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.context.annotation.Configuration;

/**
 * @author wangchao
 * @description 字段默认填充设置
 * @date 2020/11/02 11:42
 */
@Configuration
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        Object password = getFieldValByName("password", metaObject);
        if (null == password) {
            //字段为空，可以进行填充
            setFieldValByName("password", "99999999999", metaObject);
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {

    }
}
