package com.stylesmile.console.system.service;

import com.stylesmile.console.system.entity.SysRoleEntity;
import com.stylesmile.console.system.entity.SysUserEntity;
import com.stylesmile.console.system.query.SysRoleQuery;
import com.stylesmile.console.system.query.SysUserQuery;
import com.stylesmile.console.system.repository.SysUserRepository;
import com.stylesmile.console.system.service.common.BaseServiceImpl;
import com.stylesmile.constant.SessionConstant;
import com.stylesmile.constant.UserConstant;
import com.stylesmile.util.Result;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 用户管理
 *
 * @author chenye
 * @date 2019/1/8
 */
@Service("sysUserService")
public class SysUserServiceImpl extends BaseServiceImpl<SysUserEntity, SysUserQuery, String> implements SysUserService {
    @Resource
    SysUserRepository sysUserRepository;
    /**
     * @param httpServletRequest
     * @return SysUser
     */
    @Override
    public SysUserEntity getSessionUser(HttpServletRequest httpServletRequest) {
        HttpSession session = httpServletRequest.getSession();
        //获取登录的session信息
        Object user = session.getAttribute(SessionConstant.LOGIN_USER);
        return (SysUserEntity) user;
    }

    /**
     * 通过用户名密码查询用户
     *
     * @param username 用户名
     * @param password 密码
     * @return Result
     */
    @Override
    public Result<String> getSysUserByNameAndPassword(String username, String password, HttpSession session) {
        SysUserEntity user = sysUserRepository.getSysUserByNameAndPassword(username);
        if (null != user && password.equals(user.getPassword())) {
            session.setAttribute(SessionConstant.LOGIN_USER, user);
            return Result.successMessage("登陆成功");
        } else {
            //数据库查不到超级管理员 用户，超级管理员用户就读取系统中写死的用户名，密码
            if (null == user && UserConstant.SUPPER_ADMIN.equals(username) && UserConstant.SUPPER_ADMIN_PASSWORD.equals(password)) {
                session.setAttribute(SessionConstant.LOGIN_USER, new SysUserEntity(username));
                return Result.successMessage("登陆成功");
            }
            return Result.failMessage("用户名或者密码错误");
        }
    }

    /**
     * 查询用户
     *
     * @param sysUserQuery 条件
     * @return Page
     */
    @Override
    public Page<SysUserEntity> getUserList(SysUserQuery sysUserQuery) {
        return sysUserRepository.getUserList(sysUserQuery);
    }

    /**
     * 修改用户
     *
     * @param user 用户
     * @return Boolean
     */
    @Override
    public Boolean updateUser(SysUserEntity user) {
        return sysUserRepository.updateUser(user);
    }

    /**
     * 删除用户
     *
     * @param id 主键
     * @return Boolean
     */
    @Override
    public Boolean deleteUser(Integer id) {
        return sysUserRepository.deleteUser(id);
    }

    /**
     * 通过用户id ,请求路径判断是否有该路径的权限
     *
     * @param url    请求路径
     * @param userId 用户id
     * @return Integer
     */
    @Override
    public Integer queryPermission(String url, Integer userId) {
        return sysUserRepository.queryPermission(url, userId);
    }


}
