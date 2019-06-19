package com.stylesmile.console.system.repository;

import com.stylesmile.console.system.entity.SysDepartEntity;
import com.stylesmile.console.system.query.SysRoleQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author chenye
 * @date 2018/12/31
 */
@Repository
public interface SysRoleMapper extends BaseJpaRepository<SysDepartEntity, String> {
    /**
     * 查询
     *
     * @param sysRoleQuery 查询条件
     * @return Page
     */
    Page<SysDepartEntity> getRoleList(SysRoleQuery sysRoleQuery);

    /**
     * 修改角色
     *
     * @param role 角色信息
     * @return Boolean
     */
    Boolean updateRole(SysDepartEntity role);

    /**
     * 删除角色
     *
     * @param id 主键
     * @return Boolean
     */
    Boolean deleteRole(@Param("id") String id);

    /**
     * 检查角色编号是否重复角色
     *
     * @param code 角色编号
     * @return Boolean
     */
    Integer checkDuplicate(@Param("code") String code);


}
