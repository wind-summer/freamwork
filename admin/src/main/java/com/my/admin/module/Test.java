package com.my.admin.module;

import com.my.core.module.demo.entity.Demo;
import com.my.core.sys.entity.SysUser;
import com.my.core.sys.entity.SysUserToken;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wenlf
 * @since 2018/6/22
 */
public class Test {
    public static void main(String[] args) {
        List<Demo> demos = new ArrayList<>();
        Demo demo = new Demo();
        demo.setAge(true).setName("张三");
    }
}
