package com.stylesmile.console.common.jpa;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

/**
 * @author chenye
 */
public class PageableImpl implements Pageable {
    @Override
    public int getPageNumber() {
        return 1;
    }

    @Override
    public int getPageSize() {
        return 10;
    }

    @Override
    public long getOffset() {
        return 0;
    }

    @Override
    public Sort getSort() {
        return null;
    }

    @Override
    public Pageable next() {
        return null;
    }

    @Override
    public Pageable previousOrFirst() {
        return null;
    }

    @Override
    public Pageable first() {
        return null;
    }

    @Override
    public boolean hasPrevious() {
        return false;
    }

}
