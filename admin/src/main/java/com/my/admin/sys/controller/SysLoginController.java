package com.my.admin.sys.controller;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import com.my.common.utils.ApiResult;
import com.my.core.sys.entity.SysUser;
import com.my.core.sys.service.SysUserService;
import com.my.core.sys.service.SysUserTokenService;
import com.my.core.utils.ShiroUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @author wenlf
 * @since 2018/4/27
 */
@Slf4j
@AllArgsConstructor
@RestController
@Api("admin登录api")
public class SysLoginController {

    @Autowired
    private final Producer producer;

    private final SysUserService sysUserService;

    private final SysUserTokenService sysUserTokenService;

    private final ValueOperations<String,String> valueOperations;

    @ApiOperation("获取验证码图片-接口")
    @GetMapping("captcha.jpg")
    public void captcha(HttpServletResponse response,HttpServletRequest request) throws ServletException,IOException {
        response.setHeader("Cache-Control", "no-store, no-cache");
        response.setContentType("image/jpeg");

        //生成文字验证码
        String text = producer.createText();
        //生成图片验证码
        BufferedImage image = producer.createImage(text);
        //保存到shiro session
        ShiroUtils.setSessionAttribute(Constants.KAPTCHA_SESSION_KEY, text);

        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(image, "jpg", out);
        IOUtils.closeQuietly(out);
    }

    /**
     * 登录
     * @param username
     * @param password
     * @param captcha
     * @return
     */
    @ApiOperation("登录-接口")
    @PostMapping("/sys/login")
    public ApiResult login(String username, String password, String captcha) throws IOException{
        /*String kaptcha = ShiroUtils.getKaptcha(Constants.KAPTCHA_SESSION_KEY);
        if(!captcha.equalsIgnoreCase(kaptcha)){
            return ApiResult.error("验证码不正确");
        }*/

        //用户信息
        SysUser user = sysUserService.queryByUserName(username);

        //账号不存在、密码错误
        if(user == null || !user.getPassword().equals(new Sha256Hash(password, user.getSalt()).toHex())) {
            return ApiResult.error("账号或密码不正确");
        }

        //账号锁定
        if(user.getStatus() == 0){
            return ApiResult.error("账号已被锁定,请联系管理员");
        }

        //生成token，并保存到数据库
        ApiResult r = sysUserTokenService.createToken(user.getUserId());
        return r;
    }
}
