package com.stylesmile.console.system.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author Stylesmile
 * @date 2019/06/19
 */
@Entity
@Table(name = "sys_depart", indexes = {
        @Index(columnList = "id", name = "sys_depart_id"),
        @Index(columnList = "name", name = "sys_depart_name"),
        @Index(columnList = "code", name = "sys_depart_code")
})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SysDepartEntity {
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
     * 排序
     */
    @Column(length = 5)
    private Integer sort;
}
