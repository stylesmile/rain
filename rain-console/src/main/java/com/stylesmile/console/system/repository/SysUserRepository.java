package com.stylesmile.console.system.repository;

import com.stylesmile.console.system.entity.SysUserEntity;
import com.stylesmile.console.system.query.SysUserQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * 用户mapper
 *
 * @author chenye
 * @date 2018/11/18
 */
@Repository
public interface SysUserRepository extends BaseJpaRepository<SysUserEntity, String> {
    /**
     * 通过用户名密码查询用户
     *
     * @param username 用户名
     * @return SysUser
     */
    SysUserEntity getSysUserByNameAndPassword(@Param("username") String username);

    /**
     * 编辑用户
     *
     * @param user 用户
     * @return Boolean
     */
    Boolean updateUser(SysUserEntity user);

    /**
     * 删除
     *
     * @param id 用户id
     * @return Boolean
     */
    Boolean deleteUser(@Param("id") Integer id);

    /**
     * 查询用户list
     *
     * @param sysUserQuery 条件
     * @return Page
     */
    Page<SysUserEntity> getUserList(SysUserQuery sysUserQuery);

    /**
     * 根据url查询用户是否有该url的权限
     *
     * @param url 路径
     * @return Page
     */
    Integer queryPermission(@Param("url") String url, @Param("userId") Integer userId);

}
