package com.stylesmile.console.system.service;

import com.stylesmile.console.system.entity.SysRoleEntity;
import com.stylesmile.console.system.query.SysRoleQuery;
import com.stylesmile.console.system.repository.SysRoleRepository;
import com.stylesmile.console.system.service.common.BaseServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 角色 RoleService
 *
 * @author StyleSmile
 * @date 2019/1/8
 */
@Service("sysRoleService")
public class SysRoleServiceImpl extends BaseServiceImpl<SysRoleEntity, SysRoleQuery, String> implements SysRoleService {
    @Resource
    SysRoleRepository sysRoleRepository;

    @Override
    public Page<SysRoleEntity> getRoleList(SysRoleQuery sysRoleQuery, Pageable pageable) {
        return sysRoleRepository.getRoleList(sysRoleQuery, pageable);
    }

    @Override
    public Boolean updateRole(SysRoleEntity sysRoleEntity) {
        return sysRoleRepository.updateRole(sysRoleEntity);
    }

    /**
     * 删除
     *
     * @param id 主键
     * @return Boolean
     */
    @Override
    public Boolean deleteRole(String id) {
        return sysRoleRepository.deleteRole(id);
    }

    /**
     * 检查角色编号是否重复角色
     *
     * @param code 角色编号
     * @return Integer
     */
    @Override
    public Integer checkDuplicate(String code) {
        return sysRoleRepository.checkDuplicate(code);
    }

}
