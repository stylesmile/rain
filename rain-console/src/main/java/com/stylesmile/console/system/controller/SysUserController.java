package com.stylesmile.console.system.controller;

import com.stylesmile.console.common.constant.UrlConstant;
import com.stylesmile.console.system.entity.SysUserEntity;
import com.stylesmile.console.system.query.SysUserQuery;
import com.stylesmile.console.system.service.SysUserService;
import com.stylesmile.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 用户管理
 *
 * @author StyleSmile
 * @date 2018/12/08
 */
@RestController
@Api(value = UrlConstant.ServerConfig.CONTEXT + UrlConstant.SystemUrl.USER_URL_PATH)
public class SysUserController {

    @Resource
    private SysUserService sysUserService;

    /**
     * 首页数据
     */
    @ApiOperation(value = "/用户列表", notes = "根据条件查询用户列表")
    @GetMapping(UrlConstant.SystemUrl.USER_URL_PATH + "/list.json")
    public Result selectUserPage(@RequestBody @Validated SysUserQuery sysUserQuery,
                                 Pageable pageable) {
        Page<SysUserEntity> page = sysUserService.getUserList(sysUserQuery, pageable);
        return Result.success(page);
    }

    /**
     * 新增用户
     */
    @PostMapping(UrlConstant.SystemUrl.USER_URL_PATH + "/add.json")
    public Result add(SysUserEntity user) {
        return Result.success(sysUserService.save(user));
    }


    /**
     * 编辑用户
     */
    @PostMapping(UrlConstant.SystemUrl.USER_URL_PATH + "/edit.json")
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
    @PostMapping(UrlConstant.SystemUrl.USER_URL_PATH + "/delete.json")
    public Result delete(Integer id) {
        Boolean b = sysUserService.deleteUser(id);
        if (b) {
            return Result.success();
        } else {
            return Result.fail();
        }
    }

}
