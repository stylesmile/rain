package com.stylesmile.console.system.service;

import com.stylesmile.console.system.entity.SysRoleMenuEntity;
import com.stylesmile.console.system.query.SysRoleMenuQuery;
import com.stylesmile.console.system.service.common.BaseService;

import java.awt.print.Pageable;
import java.util.List;

/**
 * 用户管理
 *
 * @author chenye
 * @date 2019/1/8
 */
public interface SysRoleMenuService extends BaseService<SysRoleMenuEntity, SysRoleMenuQuery, String> {

    /**
     * 角色增加菜单
     *
     * @param roleId  角色id
     * @param menuIds 以逗号分隔的菜单id
     * @return Boolean
     */
    Boolean addRoleMenu(Integer roleId, String menuIds);

    /**
     * 通过角色id 查询该用户拥有的菜单
     *
     * @param roleId 角色id
     * @return List<Integer>
     */
    List<Integer> getRoleMenuList(Integer roleId);
}
