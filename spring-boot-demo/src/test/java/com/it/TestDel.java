package com.it;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.it.mapper.UserMapper;
import com.it.domain.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TestDel extends SpringTestRunner {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testDelById() {
        int i = userMapper.deleteById(1L);
        System.out.println("受影响的行数：" + i);
    }

    @Test
    public void testDelByMap() {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("age", 26);
        int i = userMapper.deleteByMap(paramMap);
        System.out.println("受影响的行数：" + i);
    }


    @Test
    public void testDelByWraper() {
        //方法一
       /* QueryWrapper<User> queryWrapper = new QueryWrapper();
        queryWrapper.eq("email", "123456@qq.com");*/

        //方法二(推荐)
        User user = new User();
        user.setMail("123456@qq.com");
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        int i = userMapper.delete(queryWrapper);
        System.out.println("受影响的行数：" + i);
    }

    @Test
    public void testDelByIds() {
        int i = userMapper.deleteBatchIds(Arrays.asList(9));
        System.out.println("受影响的行数：" + i);
    }
}
