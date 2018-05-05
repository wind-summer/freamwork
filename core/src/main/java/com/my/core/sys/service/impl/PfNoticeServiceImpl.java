package com.my.core.sys.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import java.util.Map;

import com.my.core.sys.dao.PfNoticeDao;
import com.my.core.sys.entity.PfNotice;
import com.my.core.sys.service.PfNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author theodo
 * @since 2017-12-18
 */
@Service
public class PfNoticeServiceImpl extends ServiceImpl<PfNoticeDao, PfNotice> implements PfNoticeService {

	@Autowired
	private PfNoticeDao pfNoticeDao;
	
	@Override
	public Page<PfNotice> queryPageList(Page<PfNotice> page, Map<String, Object> map) {
		page.setRecords(pfNoticeDao.queryPageList(page, map));
		return page;
	}

	@Override
	public void deleteBatch(Long[] noticeIds) {
		pfNoticeDao.deleteBatch(noticeIds);
	}
	
}
