package com.my.admin.sys.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.my.core.sys.entity.SysUser;
import com.my.core.sys.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author wenlf
 * @since 2018/6/22
 */
@Slf4j
@AllArgsConstructor
@RestController
@Api(description = "用户管理api")
public class SysUserController {

    private final SysUserService sysUserService;

    /**
     * 查询所有用户列表
     * @return
     */
    @ApiOperation(value = "用户列表")
    @GetMapping("/sys/users")
    public Page<SysUser> querySysUsers(@RequestParam Map<String,Object> params,Page<SysUser> page){
        List<SysUser> sysUsers = sysUserService.queryList(params);
        return page.setRecords(sysUsers);
    }
}
