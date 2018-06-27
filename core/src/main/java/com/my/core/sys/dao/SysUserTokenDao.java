package com.my.core.sys.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.my.core.sys.entity.SysUserToken;

/**
 * <p>
  * 系统用户Token Mapper 接口
 * </p>
 *
 * @author wenlf
 * @since 2017-10-28
 */
public interface SysUserTokenDao extends BaseMapper<SysUserToken> {

	SysUserToken queryByToken(String token);
    
}