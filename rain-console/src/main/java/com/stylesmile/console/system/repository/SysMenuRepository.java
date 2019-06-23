package com.stylesmile.console.system.repository;

import com.stylesmile.console.system.entity.SysDepartEntity;
import com.stylesmile.console.system.entity.SysMenuEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author chenye
 * @date 2018/11/18
 */
@Repository
public interface SysMenuRepository extends BaseJpaRepository<SysMenuEntity, String> {
    /**
     * 查询全部菜单
     *
     * @return list
     */
    @Query(value = "select * from SysUserEntity ", nativeQuery = true)
    List<SysDepartEntity> getMenuList();

    /**
     * 通过用户id获取当前用户的菜单
     *
     * @param userId 用户id
     * @return List<SysMenu>
     */
    @Query(value = "select * from SysUserEntity ", nativeQuery = true)
    List<SysMenuEntity> getMenuListByUserId(@Param("userId") Integer userId);

    /**
     * 更新菜单
     *
     * @param sysMenu 菜单
     * @return Boolean
     */
    @Query(value = "select * from SysUserEntity ", nativeQuery = true)
    Boolean updateMenu(SysDepartEntity sysMenu);

    /**
     * 删除
     *
     * @param id 主键
     * @return Boolean
     */
    @Query(value = "select * from SysUserEntity ", nativeQuery = true)
    Boolean deleteMenu(@Param("id") String id);

}
