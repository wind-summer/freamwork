package com.my.core.sys.service;

import java.util.List;

import com.baomidou.mybatisplus.service.IService;
import com.my.core.sys.entity.SysUserRole;

/**
 * <p>
 * 用户与角色对应关系 服务类
 * </p>
 *
 * @author wenlf
 * @since 2017-10-28
 */
public interface SysUserRoleService extends IService<SysUserRole> {
	void saveOrUpdate(Long userId, List<Long> roleIdList);
	
	/**
	 * 根据用户ID，获取角色ID列表
	 */
	List<Long> queryRoleIdList(Long userId);
	
	void deleteByUserId(Long userId);
}
