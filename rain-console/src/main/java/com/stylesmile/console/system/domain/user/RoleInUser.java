package com.stylesmile.console.system.domain.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author chenye
 * @date 2020-0410
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoleInUser {
    /**
     * 主键
     */
    private Integer id;
    /**
     * 名称
     */
    private String name;
    /**
     * 编号
     */
    private String code;
}
