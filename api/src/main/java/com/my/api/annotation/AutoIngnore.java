package com.my.api.annotation;

import java.lang.annotation.*;

/**
 * @author wenlf
 * @since 2018/4/23
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AutoIngnore {
}
