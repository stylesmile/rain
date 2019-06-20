package com.stylesmile.console.system.service.common;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.io.Serializable;
import java.util.List;

/**
 * Service层基类
 *
 * @author chenye
 * @date 2019/06/19
 */
public interface BaseService<M, F, ID extends Serializable> {

    public M create(M target);

    public Long delete(ID id);

    public M modify(M target);

    public M detail(ID id);

    public long count(F filter);

    public boolean exists(ID id);

    public List<M> list(F filter, Sort sort);

    public Page<M> search(F filter, Pageable pageable);
}
