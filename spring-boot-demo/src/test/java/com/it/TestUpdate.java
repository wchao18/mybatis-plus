package com.it;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.it.mapper.UserMapper;
import com.it.domain.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TestUpdate extends SpringTestRunner {

    @Autowired
    private UserMapper userMapper;

    //不设值默认更新字段
    @Test
    public void testUpdateById() {
        User user = new User();
        user.setId(8l);
        user.setPassword("666");
        user.setAge(26);
        int i = userMapper.updateById(user);
        System.out.println("受影响的行数：" + i);
    }


    @Test
    public void testUpdateByWhere() {
        User user = new User();
        user.setPassword("888");
        //user.setPassword(null);//注意
        QueryWrapper<User> queryWrapper = new QueryWrapper();
        //更新age is null的数据
        //queryWrapper.isNull("age");
        //更新user_name 等于test
        queryWrapper.eq("user_name", "test");

        //int i = userMapper.update(user, queryWrapper);
        int i = userMapper.update(user, null);
        System.out.println("受影响的行数：" + i);
    }


    @Test
    public void testUpdateByWhere2() {
        UpdateWrapper<User> updateWrapper = new UpdateWrapper();
        //更新user_name 等于test
        updateWrapper.set("name", "2020").eq("user_name", "test");

        int i = userMapper.update(null, updateWrapper);
        System.out.println("受影响的行数：" + i);
    }
}
