package com.it.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.it.pojo.User;
import java.util.List;

public interface UserMapper extends BaseMapper<User> {

    List<User> findAll();
}
