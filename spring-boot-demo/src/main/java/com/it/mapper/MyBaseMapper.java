package com.it.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * @author wangchao
 * @description TODO
 * @date 2020/11/02 11:16
 */
public interface MyBaseMapper<T> extends BaseMapper<T> {

    List<T> findALL();
}
