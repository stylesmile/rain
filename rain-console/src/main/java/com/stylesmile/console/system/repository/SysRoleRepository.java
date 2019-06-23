package com.stylesmile.console.system.repository;

import com.stylesmile.console.system.entity.SysRoleEntity;
import com.stylesmile.console.system.query.SysRoleQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author chenye
 * @date 2018/12/31
 */
@Repository
public interface SysRoleRepository extends BaseJpaRepository<SysRoleEntity, String> {
    /**
     * 查询
     *
     * @param sysRoleQuery 查询条件
     * @return Page
     */
    @Query(value = "select * from SysUserEntity ", nativeQuery = true)
    Page<SysRoleEntity> getRoleList(SysRoleQuery sysRoleQuery, Pageable pageable);

    /**
     * 修改角色
     *
     * @param role 角色信息
     * @return Boolean
     */
    @Query(value = "select * from SysUserEntity ", nativeQuery = true)
    Boolean updateRole(SysRoleEntity role);

    /**
     * 删除角色
     *
     * @param id 主键
     * @return Boolean
     */
    @Query(value = "select * from SysUserEntity ", nativeQuery = true)
    Boolean deleteRole(@Param("id") String id);

    /**
     * 检查角色编号是否重复角色
     *
     * @param code 角色编号
     * @return Boolean
     */
    @Query(value = "select count(1) from sys_role where code = :code", nativeQuery = true)
    Integer checkDuplicate(@Param("code") String code);

    /**
     * 批量删除
     */
    @Query(value = "delete from sys_role_menu where id in (:ids)", nativeQuery = true)
    void deleteByIds(List<Integer> ids);

    /**
     * 通过角色id 查询该角色拥有的菜单
     *
     * @param roleId 角色id
     * @return List<SysRoleMenu>
     */
    @Query(value = "select menu_id from sys_role_menu where role_id =:roleId ", nativeQuery = true)
    public List<Integer> getRoleMenuList(Integer roleId);
}
