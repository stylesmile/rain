package com.stylesmile.console.system.repository;

import com.stylesmile.console.system.entity.SysUserEntity;
import com.stylesmile.console.system.query.SysUserQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
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
     * 通过用户名查询用户
     *
     * @param username 用户名
     * @return SysUser
     */

    @Query(value = "select * from sys_user where username=:username", nativeQuery = true)
    SysUserEntity getSysUserByName(@Param("username") String username);

    /**
     * 编辑用户
     *
     * @param user 用户
     * @return Boolean
     */
    @Query(value = "select * from SysUserEntity ", nativeQuery = true)
    Boolean updateUser(SysUserEntity user);

    /**
     * 删除
     *
     * @param id 用户id
     * @return Boolean
     */
    @Query(value = "select * from SysUserEntity ", nativeQuery = true)
    Boolean deleteUser(@Param("id") Integer id);

    /**
     * 查询用户list
     *
     * @param sysUserQuery 条件
     * @return Page
     */
    @Query(value = "select * from SysUserEntity ", nativeQuery = true)
    Page<SysUserEntity> getUserList(SysUserQuery sysUserQuery, Pageable pageable);

    /**
     * 根据url查询用户是否有该url的权限
     *
     * @param url    路径
     * @param userId 用户id
     * @return Page
     */
    @Query(nativeQuery = true,
            value = "select count(1) from (select * from sys_menu where url = :url) sm" +
                    "left join sys_role_menu srm on srm.menu_id = sm.id" +
                    "left join sys_role sr on  sr.id = srm.role_id" +
                    "left join sys_user_role sur on sur.role_id = sr.id" +
                    "left join sys_user su on su.id =sur.user_id" +
                    "where su.id = :userId")
    Integer queryPermission(@Param("url") String url, @Param("userId") Integer userId);

}
