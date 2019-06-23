package com.stylesmile.console.system.repository;

import com.stylesmile.console.system.entity.SysDepartEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author chenye
 * @date 2018/11/18
 */
@Repository
public interface SysDepartRepository extends BaseJpaRepository<SysDepartEntity, String> {
    /**
     * 查询全部部门
     *
     * @return list
     */
    @Query(value = "select * from SysUserEntity ", nativeQuery = true)
    List<SysDepartEntity> getDepartList();

    /**
     * 更新部门
     *
     * @param sysDepart 部门
     * @return Boolean
     */
    @Query(value = "select * from SysUserEntity ", nativeQuery = true)
    Boolean updateDepart(SysDepartEntity sysDepart);

    /**
     * 删除
     *
     * @param id 主键
     * @return Boolean
     */
    @Query(value = "select * from SysUserEntity ", nativeQuery = true)
    Boolean deleteDepart(String id);
}
