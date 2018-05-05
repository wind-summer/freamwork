package com.my.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author wenlf
 * @since 2018/4/27
 */
@SpringBootApplication(scanBasePackages = {"com.my.common","com.my.core","com.my.admin"})
@MapperScan(basePackages = {"com.my.core.sys.dao"})
public class MyAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyAdminApplication.class);
    }
}
