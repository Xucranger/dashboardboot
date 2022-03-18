package com.xu.dashboard.controller;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.map.MapUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xu.dashboard.common.dto.LoginDto;
import com.xu.dashboard.common.lang.Result;
import com.xu.dashboard.entity.Userinfo;
import com.xu.dashboard.service.UserinfoService;
import com.xu.dashboard.util.JwtUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
public class AccountController {
    @Autowired
    JwtUtils jwtUtils;
    @Autowired
    UserinfoService userinfoService;
    @PostMapping("/login")
    public Result login(@RequestBody LoginDto loginDto, HttpServletResponse response){

        Userinfo userinfo = userinfoService.getOne(new QueryWrapper<Userinfo>().eq("username", loginDto.getUsername()));
        System.out.println(userinfo);
        Assert.notNull(userinfo,"用户不存在");
        if(!userinfo.getPassword().equals(loginDto.getPassword())){
            return Result.fail("密码不正确");
        }
        String jwt = jwtUtils.generateToken(userinfo.getId());

        response.setHeader("Authorization",jwt);
        response.setHeader("Access-control-Expose-Headers","Authorization");

        return Result.succ(MapUtil.builder()
                .put("id",userinfo.getId())
                .put("username",userinfo.getUsername())
                .put("avatar",userinfo.getAvatar())
                .put("permision",userinfo.getPermission())

        );
    }
    @RequiresAuthentication
    @GetMapping("/logout")
    public Result logout(){
        SecurityUtils.getSubject().logout();
        return Result.succ(null);
    }
}
