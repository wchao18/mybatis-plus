package com.it;

import com.it.mapper.UserMapper;
import com.it.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import java.io.InputStream;
import java.util.List;

public class TestMybatis {

    @Test
    public void testFindAll() throws Exception {
        String config = "mybatis-config.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(config);

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<User> all = mapper.findAll();

        all.forEach(s -> System.out.println(s));
    }
}
