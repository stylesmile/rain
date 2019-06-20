package com.stylesmile.console.system.entity;

import com.stylesmile.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * @author Stylesmile
 * @date 2019/06/19
 */
@Entity
@Table(name = "sys_menu", indexes = {@Index(columnList = "id", name = "sys_menu_id")})
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysMenuEntity extends BaseEntity {
    /**
     * 主键
     */
    @Id

    @Column(length = 20)
    private Integer id;
    /**
     * 父级id
     */

    @Column(length = 20)
    @NotNull(message = "parentId不能为空")
    private Integer parentId;
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
     * 资源定位地址
     */

    @Column(length = 20)
    private String url;
    /**
     * 类型
     */

    @Column(length = 20)
    private String type;
    /**
     * 排序
     */

    @Column(length = 20)
    private Integer sort;
}
