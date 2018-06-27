package com.my.admin.sys.controller;

import com.my.common.utils.ApiResult;
import com.my.core.sys.entity.SysMenu;
import com.my.core.sys.service.ShiroService;
import com.my.core.sys.service.SysMenuService;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * @author wenlf
 * @since 2018/6/26
 */
@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/sys/menu")
@Api(description = "菜单管理api")
public class SysMenuController extends AbstractController {

    @Autowired
    private SysMenuService sysMenuService;
    @Autowired
    private ShiroService shiroService;

    /**
     * 导航菜单
     */
    @RequestMapping("/nav")
    public ApiResult nav(){
        List<SysMenu> menuList = sysMenuService.getUserMenuList(getUserId());
        Set<String> permissions = shiroService.getUserPermissions(getUserId());
        return ApiResult.ok().put("menuList", menuList).put("permissions", permissions);
    }

    /**
     * 所有菜单列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:menu:list")
    public List<SysMenu> list(){
        List<SysMenu> menuList = sysMenuService.queryList(new HashMap<>());

        return menuList;
    }
}
