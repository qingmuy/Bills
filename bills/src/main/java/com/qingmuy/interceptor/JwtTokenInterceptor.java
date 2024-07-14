package com.qingmuy.interceptor;

import com.qingmuy.constant.JwtClaimsConstant;
import com.qingmuy.properties.JwtProperties;
import com.qingmuy.utils.BaseContext;
import com.qingmuy.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class JwtTokenInterceptor implements HandlerInterceptor {

    @Resource
    JwtProperties jwtProperties;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        //判断当前拦截到的是Controller的方法还是其他资源
        if (!(handler instanceof HandlerMethod)) {
            //当前拦截到的不是动态方法，直接放行
            return true;
        }

        // 请求头中获取token
        String token = request.getHeader("token");

        try {
            // 获取token中存储的值
            Claims claims = JwtUtils.parseJWT(jwtProperties.getSecret(), token);
            Long userId = Long.valueOf(claims.get(JwtClaimsConstant.USER_ID).toString());
            // 将userId存储到线程中
            BaseContext.setCurrentId(userId);
            // 放行
            return true;
        } catch (Exception e) {
            // 不通过，响应401
            response.setStatus(401);
            return false;
        }
    }
}
