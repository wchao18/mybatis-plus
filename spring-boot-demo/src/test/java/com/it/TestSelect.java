package com.it;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.it.enums.SexEnum;
import com.it.mapper.UserMapper;
import com.it.domain.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

public class TestSelect extends SpringTestRunner {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelectById() {
        User user = userMapper.selectById(3);
        System.out.println(user);
    }

    @Test
    public void testSelectByIds() {
        List<User> users = userMapper.selectBatchIds(Arrays.asList(10));
        users.forEach(s -> System.out.println(s));
    }

    @Test
    public void testSelectOne() {
        User user = new User();
        user.setUserName("test2020");
        //枚举查询自动映射
        user.setSex(SexEnum.MAN);
        QueryWrapper<User> queryWrapper = new QueryWrapper(user);
        User user1 = userMapper.selectOne(queryWrapper);
        System.out.println(user1);
    }


    @Test
    public void testSelectCount() {
        User user = new User();
        user.setUserName("test2020");
        QueryWrapper<User> queryWrapper = new QueryWrapper(user);
        Integer count = userMapper.selectCount(queryWrapper);
        System.out.println(count);
    }


    @Test
    public void testSelectList() {
        User user = new User();
        user.setUserName("test");
        //user.setPassword(null);//null条件的判断不能这些
        QueryWrapper<User> queryWrapper = new QueryWrapper(user);
        queryWrapper.ge("age", 27);
        //null条件的判断
        queryWrapper.isNull("password");
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(s -> System.out.println(s));
    }

    @Test
    public void testSelectPage() {
        QueryWrapper<User> queryWrapper = new QueryWrapper();
        queryWrapper.ge("age", 20);

        //分页
        Page<User> page = new Page(1, 10);
        IPage<User> userIPage = userMapper.selectPage(page, queryWrapper);

        System.out.println("总条数:" + userIPage.getTotal());
        System.out.println("总页数:" + userIPage.getPages());
    }


}
