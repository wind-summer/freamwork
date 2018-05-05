package com.my.core.module.demo.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.my.core.module.demo.dao.DemoDao;
import com.my.core.module.demo.entity.Demo;
import com.my.core.module.demo.service.DemoService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wenlf
 * @since 2018-04-24
 */
@Service
@AllArgsConstructor
@Slf4j
public class DemoServiceImpl extends ServiceImpl<DemoDao, Demo> implements DemoService {

}
