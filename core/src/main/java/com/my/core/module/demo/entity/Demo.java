package com.my.core.module.demo.entity;

import com.baomidou.mybatisplus.annotations.TableName;

import com.my.core.sys.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author wenlf
 * @since 2018-04-24
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("my_demo")
public class Demo extends BaseEntity<Demo> {

    private static final long serialVersionUID = 1L;

    /**
     * 姓名
     */
    private String name;
    /**
     * 年龄
     */
    private Boolean age;
    /**
     * 备注
     */
    private String remark;

}
