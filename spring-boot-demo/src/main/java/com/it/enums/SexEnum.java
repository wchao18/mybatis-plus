package com.it.enums;

import com.baomidou.mybatisplus.core.enums.IEnum;

/**
 * @author wangchao
 * @description TODO
 * @date 2020/11/02 11:54
 */
public enum SexEnum implements IEnum<Integer> {


    MAN(1, "男"),

    WOMAN(2, "女");

    private int value;

    private String desc;

    SexEnum(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    @Override
    public Integer getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return this.desc;
    }
}
