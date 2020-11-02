package com.it;

import com.it.mapper.UserMapper;
import com.it.domain.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TestMybatisPlusSpringBoot extends SpringTestRunner {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testFindList() {
        List<User> users = userMapper.selectList(null);
        users.forEach(s -> System.out.println(s));
    }


    @Test
    public void testFindByIdXML() {
        User user = userMapper.findById(11L);
        System.out.println(user);
    }


}
