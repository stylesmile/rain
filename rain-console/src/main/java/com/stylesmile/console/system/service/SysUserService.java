package com.stylesmile.console.system.service;

import com.stylesmile.console.system.entity.SysUserEntity;
import com.stylesmile.console.system.query.SysUserQuery;
import com.stylesmile.console.system.service.common.BaseService;
import com.stylesmile.util.Result;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.servlet.http.HttpServletRequest;

/**
 * 用户管理
 *
 * @author chenye
 * @date 2019/1/8
 */
public interface SysUserService extends BaseService<SysUserEntity, SysUserQuery, String> {

    SysUserEntity getSessionUser(HttpServletRequest httpServletRequest);

    /**
     * 通过用户名密码查询用户
     *
     * @param username 用户名
     * @param password 密码
     * @return Result
     */
    Result<String> getSysUserByNameAndPassword(String username, String password);

    /**
     * 查询用户
     *
     * @param sysUserQuery 条件
     * @return Page
     */
    Page<SysUserEntity> getUserList(SysUserQuery sysUserQuery, Pageable pageable);

    /**
     * 修改用户
     *
     * @param user 用户信息
     * @return Boolean
     */
    Boolean updateUser(SysUserEntity user);

    /**
     * 删除用户
     *
     * @param id 主键
     * @return Boolean
     */
    Boolean deleteUser(Integer id);

    /**
     * 通过用户id ,请求路径判断是否有该路径的权限
     *
     * @param url    请求路径
     * @param userId 用户id
     * @return Integer
     */
    Integer queryPermission(String url, Integer userId);
}
