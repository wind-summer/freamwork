package com.my.core.config;

import lombok.Data;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @author wenlf
 * @since 2018/4/17
 */
@Getter
@Configuration
@ConfigurationProperties(prefix = "application")
public class ApplicationProperties {
    private final Bidding bidding = new Bidding();

    private final Security security = new Security();

    @Data
    public static class Bidding {
        private Double maxAmount;
    }

    @Data
    public static class Security {
        /**
         * token失效秒数
         */
        private Long tokenExpire;
        /**
         * 客户默认初始化密码
         */
        private String defaultPassword;
        /**
         * 角色id
         */
        private Long roleId;

        /**
         * 营销中心部门id
         */
        private Long deptId;

        private List<Long> adminIds;

        /**
         * 密码错误次数
         */
        private int errorNum;
    }

}
