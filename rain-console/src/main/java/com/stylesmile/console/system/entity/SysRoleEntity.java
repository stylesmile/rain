package com.stylesmile.console.system.entity;

import com.stylesmile.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author Stylesmile
 * @date 2019/06/19
 */
@Entity
@Table(name = "sys_role")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SysRoleEntity extends BaseEntity {
    /**
     * 主键
     */
    @Id
    @Column(length = 20)
    private Integer id;
    /**
     * 名称
     */
    @Column(length = 20)
    private String name;
    /**
     * 编号
     */
    @Column(length = 20)
    private String code;
    /**
     * 排序
     */
    @Column(length = 20)
    private Integer sort;
    /**
     * 删除标识 0.未删除，1.删除
     */
    @Column(length = 1)
    private Integer delFlag;
}
