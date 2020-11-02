package com.it;

import com.baomidou.mybatisplus.extension.plugins.SqlExplainInterceptor;
import com.it.domain.User;
import com.it.mapper.UserMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author wangchao
 * @description sql相关插件
 * @date 2020/11/02 10:28
 */
public class TestSqlParse extends SpringTestRunner {

    @Autowired
    private UserMapper userMapper;

    /**
     * 测试sql插件阻断更新
     * {@link SqlExplainInterceptor}
     */
    @Test
    public void testUpdateAll() {
        User user = new User();
        user.setPassword("666");
        userMapper.update(user, null);
    }

    @Test
    public void testUpdateAllXml() {
        User user = new User();
        user.setPassword("2020");
        userMapper.updateAllXml(user);
    }

    //乐观锁更新:仅支持 updateById(id) 与  update(entity, wrapper) 方法
    @Test
    public void testUpdateWithVersion() {
        User user = new User();
        user.setVersion(2);
        user.setId(1L);
        userMapper.updateById(user);
        //回填version
        Integer version = user.getVersion();
    }


    //自定义sql
    @Test
    public void testMyDefineSql() {
        List<User> all = userMapper.findALL();
        all.forEach(s -> System.out.println(s));
    }
}
