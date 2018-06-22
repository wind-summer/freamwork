package com.my.core.sys.service.impl;

import com.my.core.config.ApplicationProperties;
import com.my.core.sys.dao.SysMenuDao;
import com.my.core.sys.dao.SysUserDao;
import com.my.core.sys.dao.SysUserTokenDao;
import com.my.core.sys.entity.SysMenu;
import com.my.core.sys.entity.SysUser;
import com.my.core.sys.entity.SysUserToken;
import com.my.core.sys.service.ShiroService;
import lombok.AllArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.*;

@Service
@AllArgsConstructor
public class ShiroServiceImpl implements ShiroService {
    //@Autowired
    private SysMenuDao sysMenuDao;
    //@Autowired
    private SysUserDao sysUserDao;
    //@Autowired
    private SysUserTokenDao sysUserTokenDao;
    @Autowired
    private ApplicationProperties applicationProperties;

    @Override
    public Set<String> getUserPermissions(long userId) {
        List<String> permsList;
        //系统管理员，拥有最高权限
        if(applicationProperties.getSecurity().getAdminIds().indexOf(userId) != -1){
            List<SysMenu> menuList = sysMenuDao.queryList(new HashMap<>(100));
            permsList = new ArrayList<>(menuList.size());
            for(SysMenu menu : menuList){
                permsList.add(menu.getPerms());
            }
        }else{
            permsList = sysUserDao.queryAllPerms(userId);
        }
        //用户权限列表
        Set<String> permsSet = new HashSet<>();
        for(String perms : permsList){
            if(StringUtils.isBlank(perms)){
                continue;
            }
            permsSet.addAll(Arrays.asList(perms.trim().split(",")));
        }
        return permsSet;
    }

    @Override
    public SysUserToken queryByToken(String token) {
        return sysUserTokenDao.queryByToken(token);
    }

    @Override
    public SysUser queryUser(Long userId) {
        return sysUserDao.selectById(userId);
    }
}
