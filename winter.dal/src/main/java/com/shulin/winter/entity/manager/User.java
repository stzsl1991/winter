package com.shulin.winter.entity.manager;

import com.shulin.winter.entity.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class User extends BaseEntity {

    private String userName;//用户名称
    private String userModile;//联系电话
    private String userPassword;//用户密码

}

