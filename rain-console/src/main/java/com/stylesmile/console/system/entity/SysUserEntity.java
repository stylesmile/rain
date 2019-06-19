package com.stylesmile.console.system.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

/**
 * @author Stylesmile
 * @date 2019/06/19
 */
@Entity
@Table(name = "sys_user", indexes = {@Index(columnList = "id", name = "sys_user_id")})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SysUserEntity  {
    /**
     * 主键
     */
    @Id
    @Column(length = 20)
    private Integer id;
    /**
     * 登陆用户名
     */
    @Column(length = 20)
    @NotEmpty(message = "登录名不能为空")
    private String username;
    /**
     * 昵称
     */
    @Column(length = 20)
    @NotEmpty(message = "昵称不能为空")
    private String nickname;
    /**
     * 秘密啊
     */
    @Column(length = 20)
    @NotEmpty(message = "密码不能为空")
    @Length(min = 6, message = "密码长度不能小于6位")
    private String password;
    /**
     * 手机好嘛
     */
    @Column(length = 20)
    private String phone;
    /**
     * 邮箱
     */
    @Column(length = 20)
    private String email;
    /**
     * 删除标识 0.未删除，1.删除
     */
    @Column(length = 20)
    private Integer delFlag;
    public SysUserEntity(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public SysUserEntity(String username) {
        this.username = username;
    }

}
