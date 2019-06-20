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
public interface BaseService<M, Q, ID extends Serializable> {

    public M save(M target);

    public Long delete(ID id);

    public Long deleteByIds(List<ID> ids);

    public M modify(M target);

    public M detail(ID id);


    public List<M> list(Q query, Sort sort);

    public Page<M> search(Q query, Pageable pageable);
}
