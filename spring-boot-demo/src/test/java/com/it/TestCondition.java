package com.it;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.it.domain.User;
import com.it.mapper.UserMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class TestCondition extends SpringTestRunner {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testFindList() {
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("user_name", "test");
        //null条件的判断
        paramMap.put("password", null);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        //queryWrapper.allEq(paramMap);
        //第二个参数:null不作为查询条件
        queryWrapper.allEq(paramMap, false);
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(s -> System.out.println(s));
    }

    //多条件查询
    @Test
    public void testMultiSelect() {
        QueryWrapper<User> queryWrapper = new QueryWrapper();
        //大于等于
        queryWrapper.ge("age", 27);
        //null条件的判断
        queryWrapper.isNull("password");
        //in
        queryWrapper.in("id", Arrays.asList(1, 2));
        //like
        queryWrapper.likeLeft("email", "123@qq.com");
        //排序,第一个参数设置排序生效
        //queryWrapper.orderBy(true,false,"id");
        queryWrapper.orderByAsc("id");
        //指定查询字段
        queryWrapper.select("id","name");
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(s -> System.out.println(s));
    }


    //or
    @Test
    public void testOr() {
        QueryWrapper<User> queryWrapper = new QueryWrapper();
        queryWrapper.eq("name", "李四").or().eq("age", 24);
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(s -> System.out.println(s));
    }


}
