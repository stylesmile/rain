package com.stylesmile.console.system.domain;

import com.stylesmile.console.system.entity.SysUserEntity;
import lombok.Data;

/**
 * @author chenye
 * @date 2020-0410
 */
@Data
public class LoginResult {
    private String token;
    private SysUserEntity user;
}

