package com.stylesmile.console.system.domain;

import com.stylesmile.console.system.domain.user.UserInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Set;

/**
 * @author chenye
 * @date 2020-0410
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginUserResult implements Serializable {

    private static final long serialVersionUID = -4472757093725949095L;
    private String token;
    private UserInfo user;
    private Set<String> roles;

}

