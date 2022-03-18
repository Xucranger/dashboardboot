package com.xu.dashboard.controller;


import cn.hutool.core.lang.Assert;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xu.dashboard.common.lang.Result;
import com.xu.dashboard.entity.Tmninfo;
import com.xu.dashboard.entity.Userinfo;
import com.xu.dashboard.mapper.TmninfoMapper;
import com.xu.dashboard.service.TmninfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.sql.Wrapper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 学涂
 * @since 2022-03-11
 */
@RestController
    @RequestMapping("/terminals")
public class TmninfoController {
    @Autowired
    TmninfoService tmninfoService;
    @Resource
    TmninfoMapper tmninfoMapper;

    //region 获取所有终端信息
    @GetMapping("/alltmns")
    public Result terminals(){
        List<Tmninfo> tmninfoList = tmninfoMapper.selectList(null);
//        for (Tmninfo tmninfo : tmninfoList) {
//            System.out.println(tmninfo); 
//        }
        return Result.succ(tmninfoList);
    }
    //endregion

    //region 终端页面
    @PostMapping("/getTmndetail")
    public Result tmndetail(@RequestBody HashMap<String, String> map){
        Tmninfo tmninfo = tmninfoService.getById(map.get("id"));
        Assert.notNull(tmninfo,"该机器不存在！");
        return Result.succ(tmninfo);
    }
    //endregion

}
