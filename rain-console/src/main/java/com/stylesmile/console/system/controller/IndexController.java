package com.stylesmile.console.system.controller;


import com.stylesmile.console.system.domain.LoginUserResult;
import com.stylesmile.console.system.service.SysMenuService;
import com.stylesmile.console.system.service.SysUserService;
import com.stylesmile.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 首页
 *
 * @author chenye
 * @date 2018/11/18
 */
@Slf4j
@RestController
//@RequestMapping("/index")
@Api(value = "测试接口Controller")
public class IndexController {

    @Resource
    SysUserService sysUserService;
    @Resource
    SysMenuService sysMenuService;


    /**
     * 登陆方法
     *
     * @param username 登陆用户名称
     * @param password 密码
     * @return Result
     * <p>
     * LogLoginAnnotation 为登陆日志aop
     */
    @ApiOperation(value = "测试用接口", notes = "测试用接口", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户登录名", example = "admin", dataType = "String", required = true),
            @ApiImplicitParam(name = "password", value = "密码", example = "111111", dataType = "String", required = true)
    })
    @RequestMapping("/login")
    public Result<LoginUserResult> login(String username, String password) {
        return sysUserService.getSysUserByNameAndPassword(username, password);
    }

    /**
     * 退出登陆
     * 注销session，并跳转登陆页面
     *
     * @param httpSession session
     */
    @GetMapping("/logOut")
    public Result logOut(HttpSession httpSession) {
        //注销session
        httpSession.invalidate();
        //跳转登陆页面
        return Result.success();
    }

    /**
     * 后台管理系统首页
     */
    @GetMapping("/index")
    public Result index(HttpServletRequest httpServletRequest) {
        return Result.success(sysMenuService.getMenuListByUserId(httpServletRequest));
    }

}
