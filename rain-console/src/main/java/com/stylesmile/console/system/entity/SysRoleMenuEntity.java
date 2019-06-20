package com.stylesmile.console.system.entity;

import com.stylesmile.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Stylesmile
 * @date 2019/06/19
 */
@Entity
@Table(name = "sys_role_menu")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SysRoleMenuEntity extends BaseEntity {

    @Id
    @Column(length = 20)
    private Integer id;

    @Column(length = 20)
    private Integer roleId;

    @Column(length = 20)
    private Integer menuId;

    public SysRoleMenuEntity(Integer roleId, Integer menuId) {
        this.roleId = roleId;
        this.menuId = menuId;
    }
}
