package com.stylesmile.console.system.service;

import com.stylesmile.console.system.entity.SysDepartEntity;
import com.stylesmile.console.system.query.SysDepartQuery;
import com.stylesmile.console.system.repository.SysDepartRepository;
import com.stylesmile.console.system.service.common.BaseServiceImpl;
import com.stylesmile.constant.CacheConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 部门管理
 *
 * @author chenye
 * @date 2019/1/8
 */
@Service("sysDepartService")
public class SysDepartServiceImpl implements SysDepartService {

    @Autowired
    SysDepartRepository sysDepartRepository;

    /**
     * 查询部门
     *
     * @return List<SysDepart>
     */
    @Cacheable(value = CacheConstant.DEPART_LIST_CACHE)
    @Override
    public List<SysDepartEntity> getList() {
        return sysDepartRepository.getDepartList();
    }

    /**
     * 修改部门
     *
     * @param sysDepart 部门信息
     * @return Boolean
     */
    @Override
    public Boolean updateDepart(SysDepartEntity sysDepart) {
        boolean b = sysDepartRepository.updateDepart(sysDepart);
        //清除缓存
        this.clearDepartListCache();
        return b;
    }

    /**
     * 删除部门
     *
     * @param id 主键
     * @return Boolean
     */
    @Override
    public Boolean deleteDepart(String id) {
        Boolean b = sysDepartRepository.deleteDepart(id);
        //清除缓存
        this.clearDepartListCache();
        return b;
    }

    /**
     * 清除部门缓存
     */
    @CacheEvict(value = CacheConstant.DEPART_LIST_CACHE)
    @Override
    public void clearDepartListCache() {
    }

}
