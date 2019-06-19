package com.stylesmile.console.system.service;

import com.stylesmile.common.service.BaseService;
import com.stylesmile.console.system.entity.SysDepartEntity;

import java.util.List;

/**
 * 部门管理
 *
 * @author chenye
 * @date 2019/1/8 21:23
 */
public interface SysDepartService extends BaseService<SysDepartEntity> {

    /**
     * 查询部门列表
     *
     * @return List<SysDepart>
     */
    List<SysDepartEntity> getList();

    /**
     * 修改部门
     *
     * @param sysDepart 部门信息
     * @return Boolean
     */
    Boolean updateDepart(SysDepartEntity sysDepart);

    /**
     * 删除部门
     *
     * @param id 主键
     * @return Boolean
     */
    Boolean deleteDepart(String id);

    /**
     * 清除部门缓存
     */
    void clearDepartListCache();

}
