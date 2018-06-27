package com.my.core.sys.service;

import com.my.core.sys.entity.SysUser;
import com.my.core.sys.entity.SysUserToken;

import java.util.Set;


/**
 * shiro相关接口
 * @author wenlf
 * @date 2017-06-06 8:49
 */
public interface ShiroService {
    /**
     * 获取用户权限列表
     */
    Set<String> getUserPermissions(long userId);

    SysUserToken queryByToken(String token);

    /**
     * 根据用户ID，查询用户
     * @param userId
     */
    SysUser queryUser(Long userId);
}
