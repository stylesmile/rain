package com.stylesmile.console.system.controller;

import com.stylesmile.console.system.entity.SysUserEntity;
import com.stylesmile.console.system.query.SysUserQuery;
import com.stylesmile.console.system.service.SysUserService;
import com.stylesmile.util.Result;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * 用户管理
 *
 * @author StyleSmile
 * @date 2018/12/08
 */
@RestController
public class SysUserController {

    private final String BASE_URL_PATH = "/user";
    private final String BASE_HTML_PATH = "/system/sysUser";
    @Resource
    private SysUserService sysUserService;

    /**
     * 菜单管理
     */
    @GetMapping(BASE_URL_PATH + "/index.html")
    @ResponseBody
    public ModelAndView index() {
        ModelAndView view = new ModelAndView(BASE_HTML_PATH + "/user");
        return view;
    }

    /**
     * 首页数据
     */
    @GetMapping(BASE_URL_PATH + "/list.json")
    public Result selectUserPage(SysUserQuery sysUserQuery) {
        Page<SysUserEntity> page = sysUserService.getUserList(sysUserQuery);
        return Result.success(page);
    }

    /**
     * 进入新增用户页面
     */
    @GetMapping(BASE_URL_PATH + "/add.html")
    @ResponseBody
    public ModelAndView add() {
        ModelAndView view = new ModelAndView(BASE_HTML_PATH + "/user_add");
        return view;
    }

    /**
     * 新增用户
     */
    @PostMapping(BASE_URL_PATH + "/add.json")
    @ResponseBody
    public Result add(SysUserEntity user) {
        return Result.bool(false);
    }


    /**
     * 编辑用户
     */
    @PostMapping(BASE_URL_PATH + "/edit.json")
    @ResponseBody
    public Result edit(SysUserEntity user) {
        Boolean b = sysUserService.updateUser(user);
        if (b) {
            return Result.success();
        } else {
            return Result.fail();
        }
    }

    /**
     * 删除用户
     */
    @PostMapping(BASE_URL_PATH + "/delete.json")
    @ResponseBody
    public Result delete(Integer id) {
        Boolean b = sysUserService.deleteUser(id);
        if (b) {
            return Result.success();
        } else {
            return Result.fail();
        }
    }

}
