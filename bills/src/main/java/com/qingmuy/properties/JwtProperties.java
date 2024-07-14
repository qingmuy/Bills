package com.qingmuy.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("jjwt")
@Data
public class JwtProperties {
    /**
     * jjwt令牌相关配置
     */
    private String secret;
    private Long ttl;
    private String tokenName;
}
