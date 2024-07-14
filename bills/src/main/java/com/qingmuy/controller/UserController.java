package com.qingmuy.controller;

import com.qingmuy.common.Result;
import com.qingmuy.constant.JwtClaimsConstant;
import com.qingmuy.domain.dto.UserLoginDTO;
import com.qingmuy.domain.dto.UserRegisterDTO;
import com.qingmuy.domain.pojo.User;
import com.qingmuy.domain.vo.UserLoginVO;
import com.qingmuy.exception.IllegalArgumentException;
import com.qingmuy.properties.JwtProperties;
import com.qingmuy.service.UserService;
import com.qingmuy.utils.JwtUtils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
@Tag(name = "用户接口")
public class UserController {

    @Resource
    JwtProperties jwtProperties;

    @Resource
    UserService userService;

    /**
     * 注册
     *
     * @param userRegisterDTO 注册信息
     * @return 是否注册成功
     */
    @PostMapping("/register")
    @Operation(summary = "注册接口")
    public Result<Boolean> register(@RequestBody UserRegisterDTO userRegisterDTO) {
        // 关键字段缺失
        if (userRegisterDTO.getAccount() == null || userRegisterDTO.getPhone() == null || userRegisterDTO.getPassword() == null) {
            throw new IllegalArgumentException();
        }
        userService.register(userRegisterDTO);
        return Result.success();
    }

    /**
     * 登录
     * @param userLoginDTO 登录信息
     * @return token
     */
    @PostMapping("/login")
    @Operation(summary = "登录接口")
    public Result<UserLoginVO> login(@RequestBody UserLoginDTO userLoginDTO) {
        if (userLoginDTO.getAccount() == null || userLoginDTO.getPassword() == null) {
            throw new IllegalArgumentException();
        }

        User user = userService.login(userLoginDTO);

        //登录成功后，生成jwt令牌
        Map<String, Object> claims = new HashMap<>();
        claims.put(JwtClaimsConstant.USER_ID, user.getId());
        String token = JwtUtils.createJWT(jwtProperties.getSecret(), jwtProperties.getTtl(), claims);

        UserLoginVO userLoginVO = new UserLoginVO();

        BeanUtils.copyProperties(user, userLoginVO);
        userLoginVO.setToken(token);

        return Result.success(userLoginVO);
    }
}
