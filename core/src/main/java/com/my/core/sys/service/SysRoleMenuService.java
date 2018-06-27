package com.my.core.sys.service;

import java.util.List;

import com.baomidou.mybatisplus.service.IService;
import com.my.core.sys.entity.SysRoleMenu;

/**
 * <p>
 * 角色与菜单对应关系 服务类
 * </p>
 *
 * @author wenlf
 * @since 2017-10-28
 */
public interface SysRoleMenuService extends IService<SysRoleMenu> {
	void saveOrUpdate(Long roleId, List<Long> menuIdList);
	
	/**
	 * 根据角色ID，获取菜单ID列表
	 */
	List<Long> queryMenuIdList(Long roleId);
}
