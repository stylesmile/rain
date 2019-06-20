package com.stylesmile.console.system.service.common;

import com.stylesmile.console.system.repository.BaseJpaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.ValidationException;
import java.io.Serializable;
import java.util.List;

/**
 * Service层基类
 *
 * @author chenye
 * @date 2019/06/19
 */
public abstract class BaseServiceImpl<M, Q, ID extends Serializable> implements BaseService<M, Q, ID> {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired(required = false)
    protected BaseJpaRepository<M, ID> repository;


    @Transactional
    @Override
    public M save(M model) {
        logger.debug("create object: {}", model.toString());
        return repository.save(model);
    }

    @Transactional
    @Override
    public Long delete(ID id) {
        this.beforeDelete(id);
        M model = this.detail(id);
        if (model != null) {
            this.beforeDelete(model);
            this.repository.delete((M) id);
            this.afterDelete(model);
            return 1L;
        }
        throw new ValidationException("数据异常或指定id不存在");
    }

    @Transactional
    @Override
    public Long deleteByIds(List<ID> ids) {
        //repository.deleteAll(ids);
        throw new ValidationException("数据异常或指定id不存在");
    }

    @Transactional
    @Override
    public M modify(M target) {
        this.beforeModify(target);
        target = this.repository.save(target);
        this.afterModify(target);
        return target;
    }

    /**
     * 如果有缓存实现 ，则先从缓存中获取
     */
    @Override
    public M detail(ID id) {
        M e = this.repository.getOne(id);
        return e;
    }


    @Override
    public List<M> list(Q query, Sort sort) {
        //return entitys = this.repository.findAll(query, sort);
        return null;
    }

    @Override
    public Page<M> search(Q query, Pageable pageable) {
        //return entitys = this.repository.findAll(query, sort);
        return null;
    }


    protected void beforeCreate(M model) {
    }

    protected void afterCreate(M model) {
    }

    /**
     * 注意：override此方法时，
     * 如果将model转entity时，忽略某些字段，须去掉super.beforeModify(model,entity);,并手动实现转化
     * 如果将model转entity时，不忽略字段，super.beforeModify(model,entity);须放在首行
     *
     * @param model
     */
    protected void beforeModify(M model) {

    }

    protected void afterModify(M model) {
    }

    protected void beforeDelete(ID id) {

    }

    protected void beforeDelete(M model) {

    }

    protected void afterDelete(M model) {
    }

    protected void afterList(List<M> views) {
    }

    protected void copyTo(Object source, Object target, String... ignoreProperties) {
        BeanUtils.copyProperties(source, target, ignoreProperties);
    }

}
