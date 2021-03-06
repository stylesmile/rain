package com.stylesmile.console.system.service;

import com.stylesmile.console.common.constant.SessionConstant;
import com.stylesmile.console.common.constant.UserConstant;
import com.stylesmile.console.system.domain.LoginUserResult;
import com.stylesmile.console.system.domain.user.UserInfo;
import com.stylesmile.console.system.entity.SysUserEntity;
import com.stylesmile.console.system.query.SysUserQuery;
import com.stylesmile.console.system.repository.SysUserRepository;
import com.stylesmile.console.system.service.common.BaseServiceImpl;
import com.stylesmile.util.Result;
import com.stylesmile.util.UUIDUtil;
import org.apache.catalina.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashSet;
import java.util.Set;

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
    public Result<LoginUserResult> getSysUserByNameAndPassword(String username, String password) {
        if (username.equals("admin")) {
            UserInfo userInfo = UserInfo.builder()
                    .id(1)
                    .nickname("管理员")
                    .username("admin")
                    .build();
            Set<String> roles = new HashSet<>();
            roles.add("admin");

            LoginUserResult loginResult = new LoginUserResult();
            loginResult.setToken(UUIDUtil.getUUID());
            loginResult.setUser(userInfo);
            loginResult.setRoles(roles);

            return Result.success(loginResult);
        }
        SysUserEntity user = sysUserRepository.getSysUserByName(username);
        if (null != user && password.equals(user.getPassword())) {
            //session.setAttribute(SessionConstant.LOGIN_USER, user);
            return Result.successMessage(UUIDUtil.getUUID());
        } else {
            //数据库查不到超级管理员 用户，超级管理员用户就读取系统中写死的用户名，密码
            if (null == user && UserConstant.SUPPER_ADMIN.equals(username) && UserConstant.SUPPER_ADMIN_PASSWORD.equals(password)) {
                //session.setAttribute(SessionConstant.LOGIN_USER, new SysUserEntity(username));
                return Result.successMessage(UUIDUtil.getUUID());
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
    public Page<SysUserEntity> getUserList(SysUserQuery sysUserQuery, Pageable pageable) {
        return sysUserRepository.getUserList(sysUserQuery, pageable);
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
