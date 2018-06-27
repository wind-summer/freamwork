package com.my.core.sys.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.my.common.annotation.DataFilter;
import com.my.core.sys.dao.SysRoleDao;
import com.my.core.sys.entity.SysRole;
import com.my.core.sys.service.SysRoleDeptService;
import com.my.core.sys.service.SysRoleMenuService;
import com.my.core.sys.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 角色 服务实现类
 * </p>
 *
 * @author wenlf
 * @since 2017-10-28
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleDao, SysRole> implements SysRoleService {
	@Autowired
	private SysRoleDao sysRoleDao;
	
	@Autowired
	private SysRoleMenuService sysRoleMenuService;
	@Autowired
	private SysRoleDeptService sysRoleDeptService;
	
	@Override
	public Page<SysRole> queryPageList(Page<SysRole> page, Map<String, Object> map) {
		page.setRecords(sysRoleDao.queryPageList(page, map));
		return page;
	}
	
	@Override
	@DataFilter(tableAlias = "r", user = false)
	public List<SysRole> queryList(Map<String, Object> map) {
		return sysRoleDao.queryList(map);
	}
	
	@Override
	@Transactional
	public void save(SysRole role) {
		role.setCreateTime(new Date());
		sysRoleDao.insert(role);
		
		//保存角色与菜单关系
		sysRoleMenuService.saveOrUpdate(role.getRoleId(), role.getMenuIdList());

		//保存角色与部门关系
		sysRoleDeptService.saveOrUpdate(role.getRoleId(), role.getDeptIdList());
	}

	@Override
	@Transactional
	public void update(SysRole role) {
		sysRoleDao.updateById(role);
		
		//更新角色与菜单关系
		sysRoleMenuService.saveOrUpdate(role.getRoleId(), role.getMenuIdList());

		//保存角色与部门关系
		sysRoleDeptService.saveOrUpdate(role.getRoleId(), role.getDeptIdList());
	}

	@Override
	@Transactional
	public void deleteBatch(Long[] roleIds) {
		sysRoleDao.deleteBatch(roleIds);
	}
	
	
}
