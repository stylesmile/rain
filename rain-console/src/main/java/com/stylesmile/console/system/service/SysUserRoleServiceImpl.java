package com.stylesmile.console.system.service;

import com.stylesmile.console.system.entity.SysRoleEntity;
import com.stylesmile.console.system.entity.SysUserRoleEntity;
import com.stylesmile.console.system.query.SysRoleQuery;
import com.stylesmile.console.system.query.SysUserRoleQuery;
import com.stylesmile.console.system.repository.SysUserRoleRepository;
import com.stylesmile.console.system.service.common.BaseServiceImpl;
import com.stylesmile.util.ConvertUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户管理
 *
 * @author chenye
 * @date 2019/1/8
 */
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@Service("sysUserRoleService")
public class SysUserRoleServiceImpl extends BaseServiceImpl<SysUserRoleEntity, SysUserRoleQuery, String> implements SysUserRoleService {
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    SysUserRoleRepository sysUserRoleRepository;

    /**
     * 用户添加角色
     *
     * @param userId  用户id
     * @param roleIds 以逗号分隔的角色id字符串
     * @param session session
     * @return Boolean
     */
    @Override
    public Boolean addRole(Integer userId, String roleIds, HttpSession session) {
        List<Integer> roleIdss = ConvertUtil.strToLongList(roleIds);
        List<SysUserRoleEntity> sysUserRoleList = new ArrayList<>();
        for (Integer roleId : roleIdss) {
            SysUserRoleEntity userRole = new SysUserRoleEntity(userId, roleId);
            sysUserRoleList.add(userRole);
        }
        if (sysUserRoleList.size() == 0) {
            return false;
        }
        sysUserRoleRepository.saveAll(sysUserRoleList);
        return true;
    }
    /**
     * 删除角色
     *
     * @param id 主键
     * @return Boolean
     */
    @Override
    public Boolean deleteRole(Integer id) {
        sysUserRoleRepository.deleteById(id);
        return true;
    }

    /**
     * 通过用户id 查询 该用户拥有的角色
     *
     * @param sysRoleQuery 用户id
     * @return Page<SysRole>
     */
    @Override
    public Page<SysRoleEntity> getUserRoleList(SysRoleQuery sysRoleQuery, Pageable pageable) {
        return sysUserRoleRepository.getUserRoleList(sysRoleQuery.getUserId(), pageable);
    }
}
