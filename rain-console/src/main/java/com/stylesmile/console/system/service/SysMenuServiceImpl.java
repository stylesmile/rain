package com.stylesmile.console.system.service;

import com.stylesmile.common.service.BaseServiceImpl;
import com.stylesmile.console.system.entity.SysMenuEntity;
import com.stylesmile.console.system.repository.SysMenuRepository;
import com.stylesmile.console.system.repository.SysUserRepository;
import com.stylesmile.console.system.service.common.BaseServiceImpl;
import com.stylesmile.console.system.tree.MenuTree;
import com.stylesmile.constant.UserConstant;
import com.stylesmile.system.entity.SysMenu;
import com.stylesmile.system.entity.SysUser;
import com.stylesmile.system.mapper.SysMenuMapper;
import com.stylesmile.system.tree.MenuTree;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 菜单管理
 *
 * @author chenye
 * @date 2019/1/8
 */
@Service("sysMenuService")
public class SysMenuServiceImpl implements SysMenuService {

    @Resource
    SysMenuRepository sysMenuRepository;
    @Resource
    SysUserService sysUserService;

    /**
     * 查询菜单
     *
     * @return List<SysMenu>
     */
    @Override
    public List<SysMenuEntity> getList() {
        return sysMenuRepository.getMenuList();
    }

    /**
     * 修改菜单
     *
     * @param sysMenu 菜单信息
     * @return Boolean
     */
    @Override
    public Boolean updateMenu(SysMenuEntity sysMenu) {
        return sysMenuRepository.updateMenu(sysMenu);
    }

    /**
     * 删除菜单
     *
     * @param id 主键
     * @return Boolean
     */
    @Override
    public Boolean deleteMenu(String id) {
        return sysMenuRepository.deleteMenu(id);
    }

    /**
     * 通过用户id获取当前用户的菜单
     *
     * @param httpServletRequest request
     * @return MenuTree
     */
    @Override
    public MenuTree getMenuListByUserId(HttpServletRequest httpServletRequest) {
        //获取session中的用户
        SysMenuEntity sysUser = sysUserService.getSessionUser(httpServletRequest);
        Integer userId = sysUser.getUsername() == UserConstant.SUPPER_ADMIN ? sysUser.getId() : null;
        //通过用户id获取菜单list
        List<SysMenuEntity> sysMenuList = sysMenuRepository.getMenuListByUserId(userId);
        //list to tree
        return MenuTree.listToTree(sysMenuList);
    }

}
