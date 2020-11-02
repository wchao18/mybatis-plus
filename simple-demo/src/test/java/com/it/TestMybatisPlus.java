package com.it;

import com.baomidou.mybatisplus.core.MybatisSqlSessionFactoryBuilder;
import com.it.mapper.UserMapper;
import com.it.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class TestMybatisPlus {

    @Test
    public void testFindAll() throws Exception {
        String config = "mybatis-config.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(config);

        SqlSessionFactory sqlSessionFactory = new MybatisSqlSessionFactoryBuilder().build(resourceAsStream);

        //sqlSqsession会预先加载sql statment
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        //PS:打印的sql被包装了,默认支持驼峰
        List<User> all = mapper.selectList(null);

        all.forEach(s -> System.out.println(s));
    }
}
