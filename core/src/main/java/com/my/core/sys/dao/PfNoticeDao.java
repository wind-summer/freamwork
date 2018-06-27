package com.my.core.sys.dao;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.my.core.sys.entity.PfNotice;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author wenlf
 * @since 2017-12-18
 */
public interface PfNoticeDao extends BaseMapper<PfNotice> {

	List<PfNotice> queryPageList(Page<PfNotice> page, Map<String, Object> map);

	void deleteBatch(Long[] noticeIds);
		
}