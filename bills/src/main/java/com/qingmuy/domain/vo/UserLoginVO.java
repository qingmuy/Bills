package com.qingmuy.domain.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class UserLoginVO implements Serializable {

    // id
    private Long id;

    // 账号
    private String account;

    // 昵称
    private String username;

    // 手机号
    private String phone;

    // 创建时间
    private Date createTime;

    // token
    private String token;
}
