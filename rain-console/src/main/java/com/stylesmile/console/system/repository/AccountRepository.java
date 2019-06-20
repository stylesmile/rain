package com.stylesmile.console.repository;

import com.stylesmile.console.entity.UserEntity;
import com.stylesmile.console.system.repository.BaseJpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 用户帐号数据操作相关接口类
 *
 * @author chenye
 * @date 2019-06-12
 */
@Repository
public interface AccountRepository extends BaseJpaRepository<UserEntity, String> {

}
