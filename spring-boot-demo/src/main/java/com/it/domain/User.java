package com.it.domain;

import com.baomidou.mybatisplus.annotation.*;
import com.it.config.MyMetaObjectHandler;
import com.it.enums.SexEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
//表名在配置文件中全局设置
//@TableName("tb_user")
public class User {

    //1.主键设置,配置文件中全局设置了
    //@TableId(type = IdType.AUTO)
    private Long id;
    private String userName;

    private String name;
    private Integer age;

    //2.@TableField
    @TableField(value = "email")//指定数据库中的字段名称
    private String mail;

    @TableField(exist = false)
    private String address;//字段在数据库中不存在


    /**
     * //fill自动填充
     * {@link MyMetaObjectHandler}
     */
    @TableField(select = false, fill = FieldFill.INSERT)
    private String password;//查询时不返回字段值

    //乐观锁字段
    @Version
    private Integer version;


    /**
     * #逻辑已删除值(默认为 1)
     * mybatis-plus.global-config.db-config.logic-delete-value=1
     * #逻辑未删除值(默认为 0)
     * mybatis-plus.global-config.db-config.logic-not-delete-value=0
     */
    @TableLogic
    private Integer deleted;

    //自定义枚举
    private SexEnum sex;
}
