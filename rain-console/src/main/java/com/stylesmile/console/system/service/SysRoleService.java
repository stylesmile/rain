package com.stylesmile.console.system.service;

import com.stylesmile.console.system.entity.SysRoleEntity;
import com.stylesmile.console.system.query.SysRoleQuery;
import org.springframework.data.domain.Page;

/**
 * @Description: 角色管理
 * @Author: StyleSmile
 * @Date: 2019/1/8
 */
public interface SysRoleService {
    /**
     * 查询角色
     *
     * @param sysRoleQuery 条件
     * @return Page
     */
    Page<SysRoleEntity> getRoleList(SysRoleQuery sysRoleQuery);

    /**
     * 修改角色
     *
     * @param role 角色信息
     * @return Boolean
     */
    Boolean updateRole(SysRoleEntity role);

    /**
     * 删除角色
     *
     * @param id 主键
     * @return Boolean
     */
    Boolean deleteRole(String id);

    /**
     * 检查code是否重复
     *
     * @param code 编号
     * @return Integer
     */
    Integer checkDuplicate(String code);

}
