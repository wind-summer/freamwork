package com.my.core.sys.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import java.util.Date;

import com.my.common.utils.ApiResult;
import com.my.core.config.ApplicationProperties;
import com.my.core.oauth2.TokenGenerator;
import com.my.core.sys.dao.SysUserTokenDao;
import com.my.core.sys.entity.SysUserToken;
import com.my.core.sys.service.SysUserTokenService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统用户Token 服务实现类
 * </p>
 *
 * @author wenlf
 * @since 2017-10-28
 */

@AllArgsConstructor
@Slf4j
@Service
public class SysUserTokenServiceImpl extends ServiceImpl<SysUserTokenDao, SysUserToken> implements SysUserTokenService {
	@Autowired
	private SysUserTokenDao sysUserTokenDao;
	@Autowired
	ApplicationProperties applicationProperties;
	//12小时后过期
	private final static int EXPIRE = 3600 * 12;
	
	@Override
	public SysUserToken queryByToken(String token) {
		return sysUserTokenDao.queryByToken(token);
	}
	
	@Override
	public ApiResult createToken(long userId) {
		//生成一个token
		String token = TokenGenerator.generateValue();

		//当前时间
		Date now = new Date();
		//过期时间
		//Date expireTime = new Date(now.getTime() + EXPIRE * 1000);
		Date expireTime = new Date(now.getTime() + applicationProperties.getSecurity().getTokenExpire() * 1000);

		//判断是否生成过token
		SysUserToken tokenEntity = sysUserTokenDao.selectById(userId);
		if(tokenEntity == null){
			tokenEntity = new SysUserToken();
			tokenEntity.setUserId(userId);
			tokenEntity.setToken(token);
			tokenEntity.setUpdateTime(now);
			tokenEntity.setExpireTime(expireTime);

			//保存token
			sysUserTokenDao.insert(tokenEntity);
		}else{
			tokenEntity.setToken(token);
			tokenEntity.setUpdateTime(now);
			tokenEntity.setExpireTime(expireTime);

			//更新token
			sysUserTokenDao.updateById(tokenEntity);
		}
		ApiResult r = ApiResult.ok().put("token", token).put("expire", applicationProperties.getSecurity().getTokenExpire());
		return r;
	}
	
}
