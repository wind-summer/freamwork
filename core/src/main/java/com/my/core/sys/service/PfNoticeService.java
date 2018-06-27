package com.my.core.sys.service;

import java.util.Map;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.my.core.sys.entity.PfNotice;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wenlf
 * @since 2017-12-18
 */
public interface PfNoticeService extends IService<PfNotice> {

	Page<PfNotice> queryPageList(Page<PfNotice> pageUtil, Map<String, Object> map);

	void deleteBatch(Long[] noticeIds);
	
}
