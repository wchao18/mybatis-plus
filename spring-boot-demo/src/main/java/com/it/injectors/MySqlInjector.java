package com.it.injectors;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.injector.AbstractSqlInjector;
import com.baomidou.mybatisplus.core.injector.DefaultSqlInjector;
import com.sun.org.apache.regexp.internal.RE;

import java.util.List;

/**
 * @author wangchao
 * @description TODO
 * @date 2020/11/02 11:21
 */
public class MySqlInjector extends DefaultSqlInjector {

    @Override
    public List<AbstractMethod> getMethodList() {
        List<AbstractMethod> methodList = super.getMethodList();
        methodList.add(new FindAll());
        return methodList;
    }
}
