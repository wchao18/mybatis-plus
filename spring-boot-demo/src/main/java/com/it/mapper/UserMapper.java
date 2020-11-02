package com.it.mapper;

import com.it.domain.User;

public interface UserMapper extends MyBaseMapper<User> {

   User findById(Long id);

   int updateAllXml(User user);
}
