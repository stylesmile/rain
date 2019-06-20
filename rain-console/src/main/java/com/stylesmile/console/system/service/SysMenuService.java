package com.stylesmile.console.system.service;

import com.stylesmile.console.system.entity.SysMenuEntity;
import com.stylesmile.console.system.tree.MenuTree;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 菜单管理
 *
 * @author chenye
 * @date 2019/1/8 21:23
 */
public interface SysMenuService {

    /**
     * 查询菜单列表
     *
     * @return List<SysMenu>
     */
    List<SysMenuEntity> getList();

    /**
     * 修改菜单
     *
     * @param sysMenu 菜单信息
     * @return Boolean
     */
    Boolean updateMenu(SysMenuEntity sysMenu);

    /**
     * 删除菜单
     *
     * @param id 主键
     * @return Boolean
     */
    Boolean deleteMenu(String id);

    /**
     * 通过用户id获取当前用户的菜单
     *
     * @param httpServletRequest request
     * @return List<SysMenu>
     */
    MenuTree getMenuListByUserId(HttpServletRequest httpServletRequest);
}
