package com.stylesmile.console.system.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

/**
 * @author Stylesmile
 * @date 2019/06/19
 */
@Entity
@Table(name = "sys_user_role", indexes = {@Index(columnList = "id", name = "sys_user_role_id")})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SysUserRoleEntity implements java.io.Serializable {

    /**
     * 主键
     */
    @Id
    @Column(length = 20)
    private Integer id;
    /**
     * 用户id
     */
    @Column(length = 20)
    @NotEmpty(message = "用户id不能为空")
    private Integer userId;
    /**
     * 用户id
     */
    @Column(length = 20)
    @NotEmpty(message = "用户id不能为空")
    private Integer roleId;

    public SysUserRoleEntity(@NotEmpty(message = "用户id不能为空") Integer userId, @NotEmpty(message = "用户id不能为空") Integer roleId) {
        this.userId = userId;
        this.roleId = roleId;
    }
}
