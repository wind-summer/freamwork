package com.my.common.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author wenlf
 * @since 2018/6/19
 */
@Configuration
@EnableSwagger2
public class Swagger2 {

    /*@Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.my.admin.sys.controller"))
                .paths(PathSelectors.any())
                .build();
    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("springboot利用swagger构建api文档")
                .description("简单优雅的restfun风格，http://blog.csdn.net/forezp")
                .termsOfServiceUrl("http://blog.csdn.net/forezp")
                .version("1.0")
                .build();
    }*/

    /**
     * /api.* [访问的路径匹配,如:SwaggerApiController.java @RequestMapping("/api/v1") 符合该路径匹配]
     *
     * @return
     */
    @Bean
    public Docket userApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                // 选择那些路径和api会生成document
                .select()
                // 对所有@Api注解进行监控
                .apis(RequestHandlerSelectors.any())
//                .paths(PathSelectors.any()) // 对所有路径进行监控[指定匹配路径监控(PathSelectors.regex("/api.*"))]
                .build();
    }

    /**
     * 确保以下配置的信息可用，否则不能访问
     *
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("****-**系统接口文档")
                .description("**-server系统接口文档")
                .license("Apache license")
                .version("2.0")
                .build();
    }
}
