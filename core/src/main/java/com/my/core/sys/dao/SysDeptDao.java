package com.my.core.sys.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.my.core.sys.entity.SysDept;

import java.util.List;
import java.util.Map;

/**
 * <p>
  * 部门管理 Mapper 接口
 * </p>
 *
 * @author theodo
 * @since 2017-10-28
 */
public interface SysDeptDao extends BaseMapper<SysDept> {
	
	List<SysDept> queryList(Map<String, Object> map);
	
	/**
     * 查询子部门ID列表
     * @param parentId  上级部门ID
     */
    List<Long> queryDetpIdList(Long parentId);

}