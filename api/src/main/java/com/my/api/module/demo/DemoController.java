package com.my.api.module.demo;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.my.core.module.demo.entity.Demo;
import com.my.core.module.demo.service.DemoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author wenlf
 * @since 2018/4/17
 */
@AllArgsConstructor
@RestController
@RequestMapping("/demo")
public class DemoController {

    //private ApplicationProperties applicationProperties;

    //private final StringRedisTemplate stringRedisTemplate;

    //private final ValueOperations valueOperations;

    private final DemoService demoService;


    @GetMapping("/test")
    public List<Demo> test(){
        //stringRedisTemplate.opsForValue().set("name2","zhangsan");
        //stringRedisTemplate.delete("name2");
        //stringRedisTemplate.setValueSerializer(new HashMap<String,String>());
        List<Demo> demoList = demoService.selectList(new EntityWrapper<Demo>().eq("remark", "男"));
        Page<Demo> page = demoService.selectPage(new Page<Demo>());
        return demoList;
    }
}
