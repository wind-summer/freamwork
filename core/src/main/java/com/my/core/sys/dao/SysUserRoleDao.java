package com.my.core.sys.dao;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.my.core.sys.entity.SysUserRole;

/**
 * <p>
  * 用户与角色对应关系 Mapper 接口
 * </p>
 *
 * @author wenlf
 * @since 2017-10-28
 */
public interface SysUserRoleDao extends BaseMapper<SysUserRole> {

	List<SysUserRole> queryList(Map<String, Object> map);
	
	/**
	 * 根据用户ID，获取角色ID列表
	 */
	List<Long> queryRoleIdList(Long userId);
	
	void save(Map<String, Object> map);
	
	int deleteByUserId(Long userId);
}