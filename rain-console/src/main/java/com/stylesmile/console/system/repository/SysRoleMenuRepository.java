package com.stylesmile.console.system.repository;

import com.stylesmile.console.system.entity.SysRoleMenuEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户mapper
 *
 * @author chenye
 * @date 2019/01/20
 */
@Repository
public interface SysRoleMenuRepository extends BaseJpaRepository<SysRoleMenuEntity, String> {
    /**
     * 通过用户id 查询该用户拥有的菜单
     *
     * @param roleId 角色id
     * @return List<SysRoleMenu>
     */
    List<Integer> getRoleMenuList(Integer roleId);
}
