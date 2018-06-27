package com.my.core.sys.dao;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.my.core.sys.entity.SysRoleMenu;

/**
 * <p>
  * 角色与菜单对应关系 Mapper 接口
 * </p>
 *
 * @author wenlf
 * @since 2017-10-28
 */
public interface SysRoleMenuDao extends BaseMapper<SysRoleMenu> {

	/**
	 * 根据角色ID，获取菜单ID列表
	 */
	List<Long> queryMenuIdList(Long roleId);
	
	void save(Map<String, Object> map);

	void deleteByRoleId(Long roleId);
	
}