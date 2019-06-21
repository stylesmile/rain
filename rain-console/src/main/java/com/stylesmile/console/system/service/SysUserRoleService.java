package com.stylesmile.console.system.service;

import com.stylesmile.console.system.entity.SysRoleEntity;
import com.stylesmile.console.system.entity.SysUserRoleEntity;
import com.stylesmile.console.system.query.SysRoleQuery;
import com.stylesmile.console.system.query.SysUserRoleQuery;
import com.stylesmile.console.system.service.common.BaseService;
import org.springframework.data.domain.Page;

import javax.servlet.http.HttpSession;

/**
 * 用户管理
 *
 * @author chenye
 * @date 2019/1/8
 */
public interface SysUserRoleService extends BaseService<SysUserRoleEntity, SysUserRoleQuery, String> {

    /**
     * 用户增加角色
     *
     * @param useId   用户id
     * @param roleIds 角色id
     * @return Boolean
     */
    Boolean addRole(Integer useId, String roleIds, HttpSession session);

    /**
     * 删除角色
     *
     * @param id 主键
     * @return Boolean
     */
    Boolean deleteRole(Integer id);

    /**
     * 通过用户id 查询该用户拥有的角色
     *
     * @param sysRoleQuery 用户id
     * @return Page<SysRole>
     */
    Page<SysRoleEntity> getUserRoleList(SysRoleQuery sysRoleQuery);
}
