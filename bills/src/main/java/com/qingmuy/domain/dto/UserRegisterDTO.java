package com.qingmuy.domain.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserRegisterDTO implements Serializable {

    // 账号
    private String account;

    // 密码
    private String password;

    // 手机号
    private String phone;
}
