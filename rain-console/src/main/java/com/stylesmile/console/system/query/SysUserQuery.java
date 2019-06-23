package com.stylesmile.console.system.query;

import lombok.Data;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;

/**
 * @author chenye
 * @date 2019/06/19
 */
@Data
public class SysUserQuery extends SpringDataWebProperties.Pageable {

    private String id;
    private String username;
    private String nickname;
    private String phone;
    private String email;

}
