package com.stylesmile.console.system.controller;


import com.stylesmile.console.system.service.SysMenuService;
import com.stylesmile.console.system.service.SysUserService;
import com.stylesmile.console.system.tree.MenuTree;
import com.stylesmile.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

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
@RequestMapping("/")
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
            @ApiImplicitParam(name = "username", value = "用户登录名", dataType = "String", required = true, paramType = "form"),
            @ApiImplicitParam(name = "password", value = "密码", dataType = "String", required = true, paramType = "form")
    })
    @RequestMapping("/login.json")
    public Result<String> login(String username, String password, HttpSession session) {
        return sysUserService.getSysUserByNameAndPassword(username, password, session);
    }

    /**
     * 退出登陆
     * 注销session，并跳转登陆页面
     *
     * @param httpSession session
     */
    @GetMapping("/logOut.do")
    public ModelAndView logOut(HttpSession httpSession) {
        //注销session
        httpSession.invalidate();
        //跳转登陆页面
        return new ModelAndView("/login");
    }

    /**
     * 后台管理系统首页
     */
    @GetMapping("/index.html")
    public ModelAndView index(HttpServletRequest httpServletRequest) {
        ModelAndView view = new ModelAndView("/index");

        //通过用户id获取当前用户的菜单
        MenuTree menuTree = sysMenuService.getMenuListByUserId(httpServletRequest);
        view.addObject("menuList", menuTree.getChildren());
        return view;
    }

}
