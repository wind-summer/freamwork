package com.my.core.sys.service;

import com.baomidou.mybatisplus.service.IService;
import com.my.common.utils.ApiResult;
import com.my.core.sys.entity.SysUserToken;

/**
 * <p>
 * 系统用户Token 服务类
 * </p>
 *
 * @author wenlf
 * @since 2018-04-28
 */
public interface SysUserTokenService extends IService<SysUserToken> {
	SysUserToken queryByToken(String token);

	/**
	 * 生成token
	 * @param userId
	 * @return
	 */
	ApiResult createToken(long userId);
}
