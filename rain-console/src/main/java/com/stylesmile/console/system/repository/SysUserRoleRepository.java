package com.stylesmile.console.system.repository;

import com.stylesmile.console.system.entity.SysDepartEntity;
import com.stylesmile.console.system.entity.SysRoleEntity;
import com.stylesmile.console.system.entity.SysUserRoleEntity;
import com.stylesmile.console.system.query.SysRoleQuery;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;

/**
 * 用户mapper
 *
 * @author chenye
 * @date 2019/01/20
 */
@Repository
public interface SysUserRoleRepository extends BaseJpaRepository<SysUserRoleEntity, Integer> {
    /**
     * 通过用户id 查询该用户拥有的角色
     *
     * @param sysRoleQuery 用户id
     * @return Page
     */
    Page<SysRoleEntity> getUserRoleList(SysRoleQuery sysRoleQuery);
}
