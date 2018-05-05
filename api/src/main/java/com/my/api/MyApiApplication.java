package com.my.api;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author wenlf
 * @since 2018/4/17
 */
@SpringBootApplication(scanBasePackages = {"com.my.common","com.my.core","com.my.api"})
@MapperScan(basePackages = {"com.my.core.sys.dao"})
public class MyApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyApiApplication.class, args);
    }
}
