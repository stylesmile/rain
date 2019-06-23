package com.stylesmile.console.system.repository;

import com.stylesmile.console.system.entity.SysRoleEntity;
import com.stylesmile.console.system.entity.SysUserRoleEntity;
import com.stylesmile.console.system.query.SysRoleQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Map;

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
     * @param userId 用户id
     * @return Page
     */
    @Query(nativeQuery = true,
            value = "select sr.id,sr.code,sr.name FROM sys_role sr" +
                    "left join sys_user_role sur on sur.role_id = sr.id" +
                    "where sr.del_flag = 0 and sur.user_id =:userId")
    Page<SysRoleEntity> getUserRoleList(String userId, Pageable pageable);
}
