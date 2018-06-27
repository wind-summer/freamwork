package com.my.admin.sys.controller;

import com.my.core.sys.entity.SysUser;
import org.apache.shiro.SecurityUtils;

/**
 * Controller公共组件
 * 
 * @author wenlf
 *
 * @date 2018年06月9日
 */
public abstract class AbstractController {

	protected SysUser getUser() {
		return (SysUser) SecurityUtils.getSubject().getPrincipal();
	}

	protected Long getUserId() {
		return getUser().getUserId();
	}

	protected Long getDeptId() {
		return getUser().getDeptId();
	}
}
