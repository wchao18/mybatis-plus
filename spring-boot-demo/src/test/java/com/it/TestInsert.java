package com.it;
import com.it.enums.SexEnum;
import com.it.mapper.UserMapper;
import com.it.domain.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TestInsert extends SpringTestRunner{

    @Autowired
    private UserMapper userMapper;

    //PS:不设置字段值,默认sql不插入
    @Test
    public void testInsert(){
        User user = new User();
        user.setUserName("test");
        //user.setPassword("123456");
        user.setName("哈哈哈");
        user.setMail("123456@qq.com");
        user.setAddress("浙江杭州");

        //枚举
        user.setSex(SexEnum.WOMAN);
        int insert = userMapper.insert(user);
        System.out.println("受影响的行数：" + insert);
        System.out.println("返回的主键ID:" + user.getId());

    }
}
