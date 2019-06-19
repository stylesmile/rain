package com.stylesmile.console.system.repository;

import com.stylesmile.console.system.entity.SysDepartEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author chenye
 * @date 2018/11/18
 */
@Repository
public interface SysDepartMapper extends BaseJpaRepository<SysDepartEntity, String> {
    /**
     * 查询全部部门
     *
     * @return list
     */
    List<SysDepartEntity> getDepartList();

    /**
     * 更新部门
     *
     * @param sysDepart 部门
     * @return Boolean
     */
    Boolean updateDepart(SysDepartEntity sysDepart);

    /**
     * 删除
     *
     * @param id 主键
     * @return Boolean
     */
    Boolean deleteDepart(String id);
}
